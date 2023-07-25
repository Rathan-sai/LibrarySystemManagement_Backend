package com.backendMarch.LibrarySystemManagement.Service;

import com.backendMarch.LibrarySystemManagement.DTO.BookRequestDto;
import com.backendMarch.LibrarySystemManagement.DTO.BookResponseDto;
import com.backendMarch.LibrarySystemManagement.Entity.Author;
import com.backendMarch.LibrarySystemManagement.Entity.Book;
import com.backendMarch.LibrarySystemManagement.Repository.AuthorRepository;
import com.backendMarch.LibrarySystemManagement.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public BookResponseDto addBook(BookRequestDto bookRequestDto){

        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setPrice(bookRequestDto.getPrice());
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setAuthor(author);

        author.getBooks().add(book);
        authorRepository.save(author);

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setPrice(bookRequestDto.getPrice());
        bookResponseDto.setName(bookRequestDto.getTitle());

        return bookResponseDto;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
