package com.example.demo.repositories;

import com.example.demo.domain.Ticket;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketsRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.category = ?1")
    public Ticket findByCategory(String category);
}
