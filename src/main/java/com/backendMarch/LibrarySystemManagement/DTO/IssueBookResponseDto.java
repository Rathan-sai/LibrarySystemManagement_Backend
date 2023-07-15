package com.backendMarch.LibrarySystemManagement.DTO;

import com.backendMarch.LibrarySystemManagement.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {

    private String transactionId;
    private String bookName;
    private TransactionStatus transactionStatus;
}
