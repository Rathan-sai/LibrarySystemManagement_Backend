package com.backendMarch.LibrarySystemManagement.Service;

import com.backendMarch.LibrarySystemManagement.DTO.AuthorRequestDto;
import com.backendMarch.LibrarySystemManagement.Entity.Author;
import com.backendMarch.LibrarySystemManagement.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(AuthorRequestDto authorRequestDto){
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());
        author.setMobileNo(authorRequestDto.getMobile_no());

        authorRepository.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
}
