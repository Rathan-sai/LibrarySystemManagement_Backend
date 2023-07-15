package com.backendMarch.LibrarySystemManagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorRequestDto {

    private String name;
    private int age;
    private String mobile_no;
    private String email;

}
