package com.backendMarch.LibrarySystemManagement.Repository;

import com.backendMarch.LibrarySystemManagement.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
