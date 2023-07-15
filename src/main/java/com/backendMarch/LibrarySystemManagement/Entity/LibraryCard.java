package com.backendMarch.LibrarySystemManagement.Entity;

import com.backendMarch.LibrarySystemManagement.Enum.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cardNo;
    @Enumerated(EnumType.STRING)
    CardStatus status;

    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date updationDate;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    Student student;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();
}
