package com.project.tta.service.impl;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tta.repository.TicketRepository;
import com.project.tta.service.TicketService;
import com.project.tta.entity.Ticket;


@Service
public class TicketServiceImpl implements TicketService{
	

	@Autowired
    private TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		
		return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
	
		ticket.setCreateon(LocalDate.now());
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		
		return ticketRepository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicketById(Long id) {
		ticketRepository.deleteById(id);
		
	}

	@Override
	public List<Ticket> getTicketsbyTitle(String title) {

		if(title == null || title == "") {
			return ticketRepository.findAll();
		}
		return ticketRepository.findByTitleContainsAllIgnoreCase(title);
	}

	
	
}
	
