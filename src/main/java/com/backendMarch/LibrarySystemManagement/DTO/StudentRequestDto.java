package com.backendMarch.LibrarySystemManagement.DTO;

import com.backendMarch.LibrarySystemManagement.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDto {

    private int age;
    private String name;
    private String email;
    private Department department;
}
