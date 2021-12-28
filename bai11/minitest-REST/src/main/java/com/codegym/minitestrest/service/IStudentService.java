package com.codegym.minitestrest.service;


import com.codegym.minitestrest.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGeneralService<Student>{
    Page<Student> findByNameContaining(String name , Pageable pageable);
    Iterable<Student> findByNameContaining(String name);
    Page<Student> findAll(Pageable pageable);
    Page<Student>findNameByOrderScoreGreaterThan8(Pageable pageable);
}
