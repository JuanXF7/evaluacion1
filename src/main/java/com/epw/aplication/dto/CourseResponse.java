package com.epw.aplication.dto;

public class CourseResponse {

    private Long id;
    private String name;
    private String description;
    private Integer duration;

    public CourseResponse(Long id, String name, String description, Integer duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuration() {
        return duration;
    }
}