package com.backendMarch.LibrarySystemManagement.Controller;

import com.backendMarch.LibrarySystemManagement.DTO.StudentRequestDto;
import com.backendMarch.LibrarySystemManagement.DTO.StudentResponseDto;
import com.backendMarch.LibrarySystemManagement.DTO.StudentUpdateEmailRequestDto;
import com.backendMarch.LibrarySystemManagement.Entity.Student;
import com.backendMarch.LibrarySystemManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        studentService.addStudent(studentRequestDto);
        return "Student has been added";
    }

    @GetMapping("/getStudent")
    public String getStudent(@RequestParam("email") String email){
        Student student = studentService.getStudent(email);
        return student.getName();
    }

    @GetMapping("/getAllByAge")
    public List<Student> getAllStudents(@RequestParam("age") int age){
        return studentService.getAllByAge(age);
    }

    @PutMapping("/update_email")
    public StudentResponseDto updateEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }
}
