package com.kadiraksoy.StudentManagement.service;


import com.kadiraksoy.StudentManagement.dto.StudentDto;
import com.kadiraksoy.StudentManagement.model.Student;
import com.kadiraksoy.StudentManagement.repository.StudentRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        return studentList.stream().map(student -> StudentDto.builder()
                .email(student.getEmail())
                .name(student.getName())
                .lastName(student.getLastName())
                .build()
        ).toList();
    }

    public StudentDto save(StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());

        studentRepository.save(student);

        return studentDto;
    }

    public StudentDto getStudentById(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);

        return optionalStudent.map(student -> StudentDto
                .builder()
                .name(student.getName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build()).orElseThrow();

    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

    public StudentDto updateStudent(StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());

        studentRepository.save(student);

        return studentDto;

    }


}
