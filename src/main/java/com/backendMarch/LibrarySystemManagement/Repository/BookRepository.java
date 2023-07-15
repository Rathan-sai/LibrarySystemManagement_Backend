package com.backendMarch.LibrarySystemManagement.Repository;

import com.backendMarch.LibrarySystemManagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
