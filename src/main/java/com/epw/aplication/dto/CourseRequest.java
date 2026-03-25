package com.epw.aplication.dto;

import jakarta.validation.constraints.*;

public class CourseRequest {

    @NotBlank(message = "Course name is required")
    @Size(min = 3, max = 100)
    private String name;

    @Size(max = 255)
    private String description;

    @NotNull(message = "Duration is required")
    @Min(1)
    @Max(500)
    private Integer duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}