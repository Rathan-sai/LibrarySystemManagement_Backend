package com.backendMarch.LibrarySystemManagement.Entity;

import com.backendMarch.LibrarySystemManagement.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private boolean isIssued;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    LibraryCard card;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
}
