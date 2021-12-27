package com.codegym.minitestrest.service;


import com.codegym.minitestrest.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGeneralService<Student>{
    Page<Student> findByNameContaining(String firstName , Pageable pageable);
    Page<Student> findAll(Pageable pageable);
    Page<Student>findNameByOrderScoreGreaterThan8(Pageable pageable);
}
