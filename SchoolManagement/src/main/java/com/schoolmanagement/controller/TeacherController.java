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
import com.schoolmanagement.model.Teacher;
import com.schoolmanagement.repository.TeacherRepository;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	//get Teachers
	@GetMapping("/teachers/getTeachers")
	public List<Teacher> getAllTeachers(){
		return this.teacherRepo.findAll();
	}
	
	//get Teacher by ID
	@GetMapping("/teachers/getTeacherById/{id}")
	public ResponseEntity<Teacher> getStudentById(@PathVariable(value = "id") Long teacherID) throws ResourceNotFoundException{
		Teacher teacher = teacherRepo.findById(teacherID).orElseThrow(()-> new ResourceNotFoundException("Teacher not found for this id :"+teacherID));
		return ResponseEntity.ok().body(teacher);
	}
	
	//Add Teacher
	@PostMapping("/teachers/saveTeacher")
	public Teacher addStudent(@RequestBody Teacher teacher) {
		return this.teacherRepo.save(teacher);
	}
	
	//Update Teacher
	@PutMapping("/teachers/updateTeacher/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable(value = "id") Long teacherID, @Valid @RequestBody Teacher teacherDetails) throws ResourceNotFoundException {
		Teacher teacher = teacherRepo.findById(teacherID).orElseThrow(()-> new ResourceNotFoundException("Teacher not found for this id :"+teacherID));
		
		teacher.setEmail(teacherDetails.getEmail());
		teacher.setPhoneNo(teacherDetails.getPhoneNo());
		teacher.setFirstName(teacherDetails.getFirstName());
		teacher.setLastName(teacherDetails.getLastName());
		teacher.setGender(teacherDetails.getGender());
		return ResponseEntity.ok(this.teacherRepo.save(teacher));
	}
	
	//Delete Students
	@DeleteMapping("/teachers/deleteTeacher/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long teacherID) throws ResourceNotFoundException{
		Teacher teacher = teacherRepo.findById(teacherID).orElseThrow(()-> new ResourceNotFoundException("Teacher not found for this id :"+teacherID));
		
		this.teacherRepo.delete(teacher);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("DELETED", Boolean.TRUE);
		return response;
	}
}
