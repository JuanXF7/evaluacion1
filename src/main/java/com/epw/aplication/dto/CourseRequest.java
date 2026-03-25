package com.epw.aplication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CourseRequest {

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    private String description;

    @Min(1)
    private Integer duration;

    @NotNull
    private Long instructorId;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuration() {
        return duration;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}