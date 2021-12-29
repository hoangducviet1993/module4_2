package com.codegym.homemanager.repository;

import com.codegym.homemanager.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    Iterable<House> findAllByOrderByName();

    @Query("select h from House h where h.bathroom > 2")
    Iterable<House> findWhereBathroomMoreThan2();

    @Query("select h from House h where h.category.id = :id")
    Iterable<House> findByCategory(@Param("id") Long id);
}
