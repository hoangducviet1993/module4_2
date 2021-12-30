function loadHomeContent() {
    let html = `
        <div class="col-9" id="list-product"></div>
        <div class="col-3" id="categories"></div>`;
    document.getElementById('content').innerHTML = html;
    loadListProduct();
    loadListCategory();
}

function loadListProduct() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/blogs",
        success: function (blog) {
            console.log(blog);
            let html = `<div class="row p-3">`;
            for (let i = 0; i < blog.length; i++) {
                html += '<div class="col-4 house p-3">' +
                    '<h4>' + blog[i].title + '</h4>' + '<br>'+
                    '<h5>' + blog[i].content + '</h5>' + '<br>'+
                    '<h5>' +'Time: '+ blog[i].time + '</h5>' + '<br>'+
                    '</div>'
            }
            html += `</div>`;
            document.getElementById('list-product').innerHTML = html;
        }
    })
}
function loadListCategory() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/modes",
        success: function (mode) {
            console.log(mode);
            let html = `<div class="row p-3">`;
            for (let i = 0; i < mode.length; i++) {
                html += '<div class="col-12"><h5>' + mode[i].name + '</h5></div>'
            }
            html += `</div>`;
            document.getElementById('categories').innerHTML = html;
        }
    })
}

