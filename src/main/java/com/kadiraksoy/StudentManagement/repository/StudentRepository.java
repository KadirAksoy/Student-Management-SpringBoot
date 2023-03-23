package com.kadiraksoy.StudentManagement.repository;

import com.kadiraksoy.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
