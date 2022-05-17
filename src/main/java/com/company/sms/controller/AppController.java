package com.company.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.sms.entity.Student;
import com.company.sms.service.StudentService;

@Controller
public class AppController {

	@Autowired
	private StudentService service;

	@GetMapping("/students")
	public String listStudents(Model model) {
		List<Student> listStudents = service.listAll();
		model.addAttribute("listStudents", listStudents);
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "new_student";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.save(student);
		return "redirect:/students";
	}



	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", service.get(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = service.get(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		service.update(existingStudent);
		return "redirect:/students";		
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		Student student=service.get(id);
		service.delete(student);
		
		return "redirect:/students";
	}

}
