package com.codegym.homemanager.service;

import com.codegym.homemanager.model.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHouseService extends IGeneralService<House> {
//    Iterable<House> findAllByOrderByName();
//
//    Iterable<House> findWhereBathroomMoreThan2();
//
//    Iterable<House> findByCategory(@Param("id") Long id);
}
