package com.backendMarch.LibrarySystemManagement.Entity;

import com.backendMarch.LibrarySystemManagement.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
//import org.springframework.transaction.TransactionStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String TransactionId;
    @Enumerated(EnumType.STRING)
    TransactionStatus Transactionstatus;

    @CreatedDate
    private Date CreatedDate;
    private boolean isIssueOperation;
    private String transactionMessage;

    @ManyToOne
    @JoinColumn
    LibraryCard card;

    @ManyToOne
    @JoinColumn
    Book book;
}
