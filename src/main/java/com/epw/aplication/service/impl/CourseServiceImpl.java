package com.epw.aplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.epw.aplication.dto.CourseRequest;
import com.epw.aplication.dto.CourseResponse;
import com.epw.aplication.entity.Course;
import com.epw.aplication.entity.Instructor;
import com.epw.aplication.repository.CourseRepository;
import com.epw.aplication.repository.InstructorRepository;
import com.epw.aplication.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                         InstructorRepository instructorRepository) {
    this.courseRepository = courseRepository;
    this.instructorRepository = instructorRepository;
}

@Override
public CourseResponse createCourse(CourseRequest request) {

    Instructor instructor = instructorRepository.findById(request.getInstructorId())
            .orElseThrow(() -> new RuntimeException("Instructor not found"));

    Course course = new Course();
    course.setName(request.getName());
    course.setDescription(request.getDescription());
    course.setDuration(request.getDuration());
    course.setInstructor(instructor);

    Course saved = courseRepository.save(course);

    return new CourseResponse(
            saved.getId(),
            saved.getName(),
            saved.getDescription(),
            saved.getDuration()
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