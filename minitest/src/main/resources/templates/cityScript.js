function getCountry() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/countries",
        success: function (data) {
            console.log(data)
            let country = `<option>Quốc Gia:</option>`
            for (let i = 0; i < data.length; i++) {
                country += `<option value="${data[i].id}">${data[i].name}</option>`
                document.getElementById('country').innerHTML = country;
            }
        }
    })
}

function getAllCity() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/cities",
        success: function (city) {
            console.log(city)
            getCountry()
            displayCity(city)

        }
    })
}

function displayCity(array) {
    let res = "";
    res += `<hr>
        <select id="country"  ></select>
        
            <hr>`
    res += `<table border="1" cellpadding="5">
    <tr>
         <th>#</th>
        <th>Thành Phố</th>
        <th>Quốc Gia</th>
        <th colspan="2">Action</th>
    </tr>`
    for (let i = 0; i < array.length; i++) {
        res += `<tr>
    <td> ${i}</td>
    <td onclick="viewCity(${array[i].id})"> ${array[i].name}</td>
    <td> ${array[i].country.name}</td>
    <td><button onclick="showFormEditCity(${array[i].id})">Edit</button></td>
    <td><button onclick="deleteCityz(${array[i].id})">Delete</button></td>
</tr>`
    }
    res += `</table>`
    console.log(res)
    document.getElementById("listCity").innerHTML = res;
}

function viewCity(id) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/cities?id=" + id,
        success: function (city) {
            console.log(city)
            let view = `<table cellpadding="5">
                                    <tr>
                                        <th>Tên thành phố: </th>
                                        <td>${city.name}</td>
                                    </tr>
                                    <tr>
                                        <th>Quốc gia: </th>
                                        <td>${city.country.name}</td>
                                    </tr>
                                    <tr>
                                        <th>Diện tích: </th>
                                        <td>${city.area}</td>
                                    </tr> 
                                    <tr>
                                        <th>Dân số: </th>
                                        <td>${city.population}</td>
                                    </tr>
                                    <tr>
                                        <th>GDP: </th>
                                        <td>${city.gdp}</td>
                                    </tr
                                    <tr>
                                        <th>Mô tả: </th>
                                        <td>${city.description}</td>
                                    </tr>
                                   
                                    <tr>
                                         <td><button onclick="showFormEditCity(${city.id})">Edit</button></td>
                                         <td><button onclick="deleteCityz(${city.id})">Delete</button></td>
                                    </tr>
                                   
                                </table>`;
            console.log(view)
            document.getElementById("listCity").innerHTML = view;
        }
    })
}


function formCreateCity() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/countries",
        success: function (country) {
            console.log(country);
            let form = `<table cellpadding="5">
                      
                            <tr>
                                <th>Tên Thành phố: </th>
                                <td><input type="text" id="name"></td>
                            </tr>
                            <tr>
                                <th>Diện tích: </th>
                                <td><input type="text" id="area"></td>
                            </tr>
                            <tr>
                                <th>Dân sô: </th>
                                <td><input type="text" id="population"></td>
                            </tr>
                            <tr>
                                <th>GDP: </th>
                                <td><input type="number" id="gdp"></td>
                            </tr>
                            <tr>
                                <th>Mô Tả: </th>
                                <td><input type="text" id="description"></td>
                            </tr>
                            <tr>
                                <th>Quốc Gia: </th>
                                <td>
                                    <select id="country">`
            for (let i = 0; i < country.length; i++) {
                form += `<option value="${country[i].id}">${country[i].name}</option>`
            }
            form += `</select>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td><button onclick="saveCity()">Save</button></td>
                            </tr>
                        </table>`;
            document.getElementById("listCity").innerHTML = form;
        }
    })
}

function saveCity() {
    let city = {
        "name": document.getElementById("name").value,
        "area": document.getElementById("area").value,
        "population": document.getElementById("population").value,
        "gdp": document.getElementById("gdp").value,
        "description": document.getElementById("description").value,
        "country": {
            "id": document.getElementById("country").value,
        }
    }
    console.log(city)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/api/cities/create",
        data: JSON.stringify(city),
        success: function () {
            alert("Thêm Thành Công")
            getAllCity();
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function deleteCityz(id) {
    if (confirm("Are you sure")) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api/cities?id=" + id,
            success: getAllCity,
            error: function (error) {
                console.log(error)
            }
        })
    } else {
    }
}

function showFormEditCity(id) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/cities?id=" + id,
        success: function (city) {
            console.log(city)
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/countries",
                success: function (country) {
                    console.log(country)
                    let form =
                        "<p>Tên Thành phố:</p>" + `<input type="text" id="name" value="${city.name}">\n` + "<br>" +
                        "<p>Diện tích:</p>" + `<input type="text" id="area" value="${city.area}">\n` + "<br>" +
                        "<p>Dân sô:</p>" + `<input type="text" id="population" value="${city.population}">\n` + "<br>" +
                        "<p>GDP:</p>" + `<input type="number" id="gdp" value="${city.gdp}">\n` + "<br>" +
                        "<p>Mô Tả:</p>" + `<input type="text" id="description" value="${city.description}">\n` + "<br>" +
                        "<p>Quốc Gia:</p>" + `<select  id="country">
                                 <option value="${city.country.id}"> ${city.country.name}</option>`
                    for (let i = 0; i < country.length; i++) {
                        form += `<option value="${country[i].id}">${country[i].name}</option>`
                    }
                    form += `</select>`
                        + `<button onclick="updateCity(${city.id})">Thay đổi</button>` + '<br>'
                    console.log(form)
                    document.getElementById("listCity").innerHTML = form;
                }
            })
        }
    })
}

function updateCity(id) {
    let name = document.getElementById("name").value;
    let area = document.getElementById("area").value;
    let population = document.getElementById("population").value;
    let gdp = document.getElementById("gdp").value;
    let description = document.getElementById("description").value;
    let country = document.getElementById("country").value;
    let quiz = {
        name: name,
        area: area,
        population: population,
        gdp: gdp,
        description: description,
        country: {
            "id": country
        }
    }
    console.log(quiz)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/api/cities?id=" + id,
        data: JSON.stringify(quiz),
        success: alert("Sứa thành công"),
        error: function (error) {
            console.log(error)
        }
    })
}
