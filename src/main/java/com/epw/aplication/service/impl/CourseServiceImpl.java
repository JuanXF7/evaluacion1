package com.epw.aplication.service.impl;

import com.epw.aplication.dto.CourseRequest;
import com.epw.aplication.dto.CourseResponse;
import com.epw.aplication.entity.Course;
import com.epw.aplication.repository.CourseRepository;
import com.epw.aplication.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseResponse createCourse(CourseRequest request) {

        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setDuration(request.getDuration());

        Course savedCourse = courseRepository.save(course);

        return new CourseResponse(
                savedCourse.getId(),
                savedCourse.getName(),
                savedCourse.getDescription(),
                savedCourse.getDuration()
        );
    }

    @Override
    public List<CourseResponse> getAllCourses() {

        return courseRepository.findAll()
                .stream()
                .map(course -> new CourseResponse(
                        course.getId(),
                        course.getName(),
                        course.getDescription(),
                        course.getDuration()
                ))
                .collect(Collectors.toList());
    }
}