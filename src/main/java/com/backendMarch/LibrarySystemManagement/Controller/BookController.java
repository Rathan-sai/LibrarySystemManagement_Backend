package com.backendMarch.LibrarySystemManagement.Controller;

import com.backendMarch.LibrarySystemManagement.DTO.BookRequestDto;
import com.backendMarch.LibrarySystemManagement.DTO.BookResponseDto;
import com.backendMarch.LibrarySystemManagement.Entity.Book;
import com.backendMarch.LibrarySystemManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto);
    }
}
