package com.company.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
		
}
