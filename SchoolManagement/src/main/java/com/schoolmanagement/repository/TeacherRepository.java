package com.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
