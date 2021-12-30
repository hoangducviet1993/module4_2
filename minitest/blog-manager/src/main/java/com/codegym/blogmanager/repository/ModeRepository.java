package com.codegym.blogmanager.repository;

import com.codegym.blogmanager.model.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeRepository extends JpaRepository<Mode, Long> {
}
