package com.backendMarch.LibrarySystemManagement.Repository;

import com.backendMarch.LibrarySystemManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(String email);
    List<Student> findByAge(int age);
//    Student findByAge(int age);
}
