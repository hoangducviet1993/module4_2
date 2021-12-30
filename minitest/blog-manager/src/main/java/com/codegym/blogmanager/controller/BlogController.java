package com.codegym.blogmanager.controller;

import com.codegym.blogmanager.model.Blog;
import com.codegym.blogmanager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Blog blog = blogOptional.get();
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        blog.setTime(LocalDateTime.now());
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());

        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteStudent(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/findByMode")
    public ResponseEntity<Iterable<Blog>> findAllByMode() {
        List<Blog> blogs = (List<Blog>) blogService.findByModeId();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
