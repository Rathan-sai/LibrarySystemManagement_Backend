package com.backendMarch.LibrarySystemManagement.Controller;

import com.backendMarch.LibrarySystemManagement.DTO.IssueBookRequestDto;
import com.backendMarch.LibrarySystemManagement.DTO.IssueBookResponseDto;
import com.backendMarch.LibrarySystemManagement.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("make_Transaction")
    public IssueBookResponseDto IssueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        return transactionService.IssueBook(issueBookRequestDto);
    }
}
