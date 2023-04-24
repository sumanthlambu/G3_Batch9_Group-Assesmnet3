package com.project.tta.service;

import java.util.List;

import com.project.tta.entity.Ticket;

public interface TicketService {
	
List<Ticket> getAllTickets();
	
	Ticket saveTicket(Ticket ticket);
	
	Ticket getTicketById(Long id);
	   
	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(Long id);

	List<Ticket> getTicketsbyTitle(String title);

}