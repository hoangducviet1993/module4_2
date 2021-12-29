package com.codegym.homemanager.service.impl;

import com.codegym.homemanager.model.House;
import com.codegym.homemanager.repository.HouseRepository;
import com.codegym.homemanager.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService implements IHouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Override
    public Iterable<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public House save(House house) {
        return houseRepository.save(house);
    }

    @Override
    public void remove(Long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public Iterable<House> findAllByOrderByName() {
        return houseRepository.findAllByOrderByName();
    }

    @Override
    public Iterable<House> findWhereBathroomMoreThan2() {
        return houseRepository.findWhereBathroomMoreThan2();
    }

    @Override
    public Iterable<House> findByCategory(Long id) {
        return houseRepository.findByCategory(id);
    }
}
