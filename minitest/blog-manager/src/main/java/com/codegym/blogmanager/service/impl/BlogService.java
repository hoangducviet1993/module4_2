package com.codegym.blogmanager.service.impl;

import com.codegym.blogmanager.model.Blog;
import com.codegym.blogmanager.repository.BlogRepository;
import com.codegym.blogmanager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findByModeId() {
        return blogRepository.findByModeId();
    }
}
