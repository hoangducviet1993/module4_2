package com.codegym.blogmanager.repository;

import com.codegym.blogmanager.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("select b from Blog b where b.mode.id = 1 ")
    Iterable<Blog> findByModeId();

}
