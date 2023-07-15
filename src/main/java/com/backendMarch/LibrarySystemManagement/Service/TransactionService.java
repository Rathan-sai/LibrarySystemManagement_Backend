package com.backendMarch.LibrarySystemManagement.Service;

import com.backendMarch.LibrarySystemManagement.DTO.BookResponseDto;
import com.backendMarch.LibrarySystemManagement.DTO.IssueBookRequestDto;
import com.backendMarch.LibrarySystemManagement.DTO.IssueBookResponseDto;
import com.backendMarch.LibrarySystemManagement.Entity.Book;
import com.backendMarch.LibrarySystemManagement.Entity.LibraryCard;
import com.backendMarch.LibrarySystemManagement.Entity.Transaction;
import com.backendMarch.LibrarySystemManagement.Enum.CardStatus;
import com.backendMarch.LibrarySystemManagement.Enum.TransactionStatus;
import com.backendMarch.LibrarySystemManagement.Repository.BookRepository;
import com.backendMarch.LibrarySystemManagement.Repository.LibraryCardRepository;
import com.backendMarch.LibrarySystemManagement.Repository.TransactionRepository;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    LibraryCardRepository libraryCardRepository;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    JavaMailSender emailSender;

    public IssueBookResponseDto IssueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(String.valueOf((UUID.randomUUID())));
        transaction.setIssueOperation(true);

        LibraryCard card;
        try{
            card = libraryCardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionstatus(TransactionStatus.FAILED);
            transaction.setTransactionMessage("card not issue.");
            transactionRepository.save(transaction);
            throw new Exception("card not issue.");
        }

        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e) {
            transaction.setTransactionstatus(TransactionStatus.FAILED);
            transaction.setTransactionMessage("book not present.");
             throw new Exception("book not present.");
        }

        transaction.setBook(book);
        transaction.setCard(card);

        if(card.getStatus() != CardStatus.ACTIVATED){
            transaction.setTransactionstatus(TransactionStatus.FAILED);
            transaction.setTransactionMessage("card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("card is not activated.");
        }

        if(book.isIssued() == true){
            transaction.setTransactionstatus(TransactionStatus.FAILED);
            transaction.setTransactionMessage("sorry! book is already issued.");
            transactionRepository.save(transaction);
            throw new Exception("sorry! book is already issued.");
        }

        transaction.setTransactionstatus(TransactionStatus.SUCCEED);
        transaction.setTransactionMessage("Transaction Completed Successfully");
        transactionRepository.save(transaction);

        card.getTransactions().add(transaction);
        card.getBooks().add(book);
        book.getTransactions().add(transaction);
        book.setIssued(true);
        book.setCard(card);

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionId(transaction.getTransactionId());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCEED);

        String text = "congratulations !! "+ card.getStudent().getName()+" use was issued "+book.getTitle()+" book";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backendgoat18@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Book issued notification.");
        message.setText(text);
        emailSender.send(message);

        return issueBookResponseDto;
    }
}
