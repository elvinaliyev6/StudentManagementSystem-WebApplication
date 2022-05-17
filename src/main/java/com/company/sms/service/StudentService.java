package com.company.sms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.sms.entity.Student;
import com.company.sms.repository.StudentRepository;

@Service
@Transactional
public class StudentService{
	
	@Autowired
	StudentRepository repo;
	
	public List<Student> listAll(){
		return repo.findAll();
	}
	
	public void save(Student student) {
		repo.save(student);
	}
	
	public void delete(Student student) {
		repo.delete(student);
	}
	
	public Student get(Long id) {
		return repo.findById(id).get();
	}
	
	public void update(Student student) {
		 repo.save(student);
	}
	
}
