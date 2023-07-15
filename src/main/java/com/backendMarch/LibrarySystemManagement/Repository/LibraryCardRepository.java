package com.backendMarch.LibrarySystemManagement.Repository;

import com.backendMarch.LibrarySystemManagement.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}
