package com.codegym.blogmanager.service;

import com.codegym.blogmanager.model.Blog;
import org.springframework.data.repository.query.Param;

public interface IBlogService extends IGeneralService<Blog>{
    Iterable<Blog> findByModeId();
}
