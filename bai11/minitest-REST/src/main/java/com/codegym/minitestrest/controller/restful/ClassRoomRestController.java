package com.codegym.minitestrest.controller.restful;

import com.codegym.minitestrest.model.ClassRoom;
import com.codegym.minitestrest.model.Student;
import com.codegym.minitestrest.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classRooms")
public class ClassRoomRestController {
    @Autowired
    private IClassRoomService classRoomService;

    @GetMapping
    public ResponseEntity<Iterable<ClassRoom>> findAllClassRoom() {
        List<ClassRoom> classRooms = (List<ClassRoom>) classRoomService.findAll();
        if (classRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classRooms, HttpStatus.OK);
    }

}
