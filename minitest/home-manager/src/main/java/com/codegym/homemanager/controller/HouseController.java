package com.codegym.homemanager.controller;

import com.codegym.homemanager.model.House;
import com.codegym.homemanager.service.ICategoryService;
import com.codegym.homemanager.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/houses")
public class HouseController {
    @Autowired
    private IHouseService houseService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<House>> findAllHouse() {
        List<House> houses = (List<House>) houseService.findAll();
        if (houses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> findHouseById(@PathVariable Long id) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        House house = houseOptional.get();
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<House> saveStudent(@RequestBody House house) {

        return new ResponseEntity<>(houseService.save(house), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> updateStudent(@PathVariable Long id, @RequestBody House house) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        house.setId(houseOptional.get().getId());

        return new ResponseEntity<>(houseService.save(house), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<House> deleteStudent(@PathVariable Long id) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        houseService.remove(id);
        return new ResponseEntity<>(houseOptional.get(), HttpStatus.NO_CONTENT);
    }
    // Nâng cao
//    @GetMapping("/orderByName")
//        public ResponseEntity<Iterable<House>> findAllOderByName () {
//            List<House> houses = (List<House>) houseService.findAllByOrderByName();
//            if (houses.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(houses, HttpStatus.OK);
//        }
}
