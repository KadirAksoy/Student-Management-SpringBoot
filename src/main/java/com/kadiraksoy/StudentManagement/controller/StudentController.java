package com.kadiraksoy.StudentManagement.controller;


import com.kadiraksoy.StudentManagement.dto.StudentDto;
import com.kadiraksoy.StudentManagement.model.Student;
import com.kadiraksoy.StudentManagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students/new")
    public String createStudent(Model model){
        Student student = new Student();

        model.addAttribute("student",student);

        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute ("student") StudentDto studentDto){
        studentService.save(studentDto);
        return "redirect:/students";
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        // get student from database by id
        StudentDto existingStudent = studentService.getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }




}
