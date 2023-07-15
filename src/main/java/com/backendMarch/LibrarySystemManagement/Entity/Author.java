package com.backendMarch.LibrarySystemManagement.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String mobileNo;
    private String email;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();
}
