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
import com.schoolmanagement.model.Student;
import com.schoolmanagement.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	//get Students
	@GetMapping("/students/getStudents")
	public List<Student> getAllStudents(){
		return this.studentRepo.findAll();
	}
	
	//get Student by ID
	@GetMapping("/students/getStudentById")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentID) throws ResourceNotFoundException{
		Student stud = studentRepo.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("Student not found for this id :"+studentID));
		return ResponseEntity.ok().body(stud);
	}
	
	//Add Students
	@PostMapping("/students/saveStudent")
	public Student addStudent(@RequestBody Student student) {
		return this.studentRepo.save(student);
	}
	
	//Update Students
	@PutMapping("/students/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentID, @Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student stud = studentRepo.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("Student not found for this id :"+studentID));
		
		stud.setEmail(studentDetails.getEmail());
		stud.setFirstName(studentDetails.getFirstName());
		stud.setLastName(studentDetails.getLastName());
		stud.setGender(studentDetails.getGender());
		return ResponseEntity.ok(this.studentRepo.save(stud));
	}
	
	//Delete Students
	@DeleteMapping("/students/deleteStudent/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentID) throws ResourceNotFoundException{
		Student stud = studentRepo.findById(studentID).orElseThrow(()-> new ResourceNotFoundException("Student not found for this id :"+studentID));
		
		this.studentRepo.delete(stud);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("DELETED", Boolean.TRUE);
		return response;
	}
}
