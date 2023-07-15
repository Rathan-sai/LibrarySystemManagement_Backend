package com.backendMarch.LibrarySystemManagement.Service;

import com.backendMarch.LibrarySystemManagement.DTO.StudentRequestDto;
import com.backendMarch.LibrarySystemManagement.DTO.StudentResponseDto;
import com.backendMarch.LibrarySystemManagement.DTO.StudentUpdateEmailRequestDto;
import com.backendMarch.LibrarySystemManagement.Entity.LibraryCard;
import com.backendMarch.LibrarySystemManagement.Entity.Student;
import com.backendMarch.LibrarySystemManagement.Enum.CardStatus;
import com.backendMarch.LibrarySystemManagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(StudentRequestDto studentRequestDto){

        Student student = new Student();

        student.setEmail(studentRequestDto.getEmail());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setAge(studentRequestDto.getAge());

        //adding card attribute to the student
        LibraryCard card = new LibraryCard();
        card.setStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);
    }

    public Student getStudent(String  email){
        return studentRepository.findByEmail(email);
    }

    public List<Student> getAllByAge(int age){
        return studentRepository.findByAge(age);
    }

    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

        Student updateStudent = studentRepository.save(student);

        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setEmail(updateStudent.getEmail());
        studentResponseDto.setId(updateStudent.getId());
        studentResponseDto.setName(updateStudent.getName());

        return studentResponseDto;
    }
}
