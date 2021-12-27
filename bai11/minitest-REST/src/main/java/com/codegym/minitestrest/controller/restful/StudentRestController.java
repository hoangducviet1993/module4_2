package com.codegym.minitestrest.controller.restful;

import com.codegym.minitestrest.model.Student;
import com.codegym.minitestrest.service.IClassRoomService;
import com.codegym.minitestrest.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRoomService classRoomService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAllCustomer() {
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
