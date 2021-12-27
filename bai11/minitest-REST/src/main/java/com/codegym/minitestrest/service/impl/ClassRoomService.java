package com.codegym.minitestrest.service.impl;


import com.codegym.minitestrest.model.ClassRoom;
import com.codegym.minitestrest.repository.ClassRoomRepository;
import com.codegym.minitestrest.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return classRoomRepository.findById(id);
    }

    @Override
    public void save(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }

    @Override
    public void remove(Long id) {
    classRoomRepository.deleteById(id);
    }
}
