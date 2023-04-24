package com.project.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.tta.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findByTitleContainsAllIgnoreCase(String title);
}