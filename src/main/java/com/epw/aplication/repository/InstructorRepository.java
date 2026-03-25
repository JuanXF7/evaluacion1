package com.epw.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epw.aplication.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}