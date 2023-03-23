package com.kadiraksoy.StudentManagement.controller;


import com.kadiraksoy.StudentManagement.model.Student;
import com.kadiraksoy.StudentManagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;


    }

    @GetMapping("/students")
    public String listStundets(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }

    public String createStudent(Model model){
        Student student = new Student();

        model.addAttribute("student",student);

        return "create_student";
    }


}
