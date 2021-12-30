package com.codegym.blogmanager.service.impl;

import com.codegym.blogmanager.model.Mode;
import com.codegym.blogmanager.repository.ModeRepository;
import com.codegym.blogmanager.service.IModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeService implements IModeService {
    @Autowired
    private ModeRepository modeRepository;

    @Override
    public Iterable<Mode> findAll() {
        return modeRepository.findAll();
    }

    @Override
    public Optional<Mode> findById(Long id) {
        return modeRepository.findById(id);
    }

    @Override
    public Mode save(Mode mode) {
        return modeRepository.save(mode);
    }

    @Override
    public void remove(Long id) {
    modeRepository.deleteById(id);
    }
}
