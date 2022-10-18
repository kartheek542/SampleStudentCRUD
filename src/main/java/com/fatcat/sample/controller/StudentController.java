package com.fatcat.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatcat.sample.model.Student;
import com.fatcat.sample.repository.StudentRepository;

@RestController
@RequestMapping("/apis")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Student was successfully added";
	}
	
	@GetMapping("/students/{sid}")
	public Student getStudentById(@PathVariable("sid") long sid) {
		return studentRepository.findBySid(sid);
	}
	
	@PutMapping("/students/{sid}")
	public String updateStudent(@PathVariable("sid") long sid, @RequestBody Student student) {
		Student existingStudent = studentRepository.findBySid(sid);
		if(existingStudent == null) {
			return "No such student";
		} else {
			studentRepository.update(student);
			return "Student details updated successfully";
		}
	}
	
	@DeleteMapping("/students/{sid}")
	public String deleteStudent(@PathVariable("sid") long sid) {
		studentRepository.deleteBySid(sid);
		return "Student details deleted successfully";
	}
}
