package com.backendMarch.LibrarySystemManagement.DTO;

import com.backendMarch.LibrarySystemManagement.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequestDto {

    private String title;
    private int price;
    private Genre genre;
    private int authorId;
}
