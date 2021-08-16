package com.schoolmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.exception.ResourceNotFoundException;
import com.schoolmanagement.model.Course;
import com.schoolmanagement.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepo;
	
		//get Courses
		@GetMapping("/courses/getCourses")
		public List<Course> getAllStudents(){
			return this.courseRepo.findAll();
		}
		
		//get Course by ID
		@GetMapping("/courses/getCourseById/{id}")
		public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Long courseID) throws ResourceNotFoundException{
			Course course = courseRepo.findById(courseID).orElseThrow(()-> new ResourceNotFoundException("Course not found for this id :"+courseID));
			return ResponseEntity.ok().body(course);
		}
		
		//Add Course
		@PostMapping("/courses/saveCourse")
		public Course addCourse(@RequestBody Course course) {
			return this.courseRepo.save(course);
		}
		
		//Update Course
		@PutMapping("/courses/updateCourse/{id}")
		public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long courseID, @Valid @RequestBody Course courseDetails) throws ResourceNotFoundException {
			Course course = courseRepo.findById(courseID).orElseThrow(()-> new ResourceNotFoundException("Course not found for this id :"+courseID));
			
			course.setCourseName(courseDetails.getCourseName());
			course.setCourseDesc(courseDetails.getCourseDesc());
			course.setCourseDuration(courseDetails.getCourseDuration());
			return ResponseEntity.ok(this.courseRepo.save(course));
		}
		
		//Delete Course
		@DeleteMapping("/courses/deleteCourse/{id}")
		public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") Long courseID) throws ResourceNotFoundException{
			Course course = courseRepo.findById(courseID).orElseThrow(()-> new ResourceNotFoundException("Student not found for this id :"+courseID));
			
			this.courseRepo.delete(course);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("DELETED", Boolean.TRUE);
			return response;
		}
}
