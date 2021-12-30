package com.codegym.blogmanager.controller;

import com.codegym.blogmanager.model.Mode;
import com.codegym.blogmanager.service.IModeService;
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
@RequestMapping("/api/modes")
public class ModeController {
    @Autowired
    private IModeService modeService;

    @GetMapping
    public ResponseEntity<Iterable<Mode>> findAllMode() {
        List<Mode> modes = (List<Mode>) modeService.findAll();
        if (modes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(modes, HttpStatus.OK);
    }
}
