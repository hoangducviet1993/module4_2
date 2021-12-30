package com.codegym.blogmanager.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String content;
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "modeId")
    private Mode mode;

    public Blog() {
    }

    public Blog(String title, String content, Mode mode) {
        this.title = title;
        this.content = content;
        this.mode = mode;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
