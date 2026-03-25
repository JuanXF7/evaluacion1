package com.epw.aplication.service;

import com.epw.aplication.dto.CourseRequest;
import com.epw.aplication.dto.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(CourseRequest request);

    List<CourseResponse> getAllCourses();
}