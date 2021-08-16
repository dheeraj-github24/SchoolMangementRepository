package com.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
