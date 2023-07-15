package com.backendMarch.LibrarySystemManagement.Repository;

import com.backendMarch.LibrarySystemManagement.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
