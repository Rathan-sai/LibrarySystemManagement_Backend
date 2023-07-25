package com.backendMarch.LibrarySystemManagement.Controller;

import com.backendMarch.LibrarySystemManagement.DTO.AuthorRequestDto;
import com.backendMarch.LibrarySystemManagement.Entity.Author;
import com.backendMarch.LibrarySystemManagement.Service.AuthorService;
import org.hibernate.dialect.function.AbstractAnsiTrimEmulationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        authorService.addAuthor(authorRequestDto);
        return "Author added Successfully.";
    }

    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping("/deleteAuthor/{authorId}")
    public ResponseEntity deleteAuthor(@PathVariable("authorId") int authorId){
        String str;
        try{
            str = authorService.deleteAuthor(authorId);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(str, HttpStatus.ACCEPTED);
    }
}