package com.project.tta.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.tta.entity.Ticket;
import com.project.tta.service.TicketService;

@Controller
public class TicketController {
	

    private TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
   
    @GetMapping("/tickets")
    public String listTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "tickets";
    }  
    
    @GetMapping("/ticket")
    public String getTicket(@RequestParam("title") String title,Model model) {
        model.addAttribute("tickets", ticketService.getTicketsbyTitle(title));
        return "tickets";
    }  
    
    @GetMapping("/tickets/new")
    public String createTicketForm(Model model) {
        // create ticket object to hold ticket form data
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "create_ticket";
    }


    @PostMapping("/tickets")
    public String saveTicket(
            @ModelAttribute("ticket") Ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }  
    
    @GetMapping("/tickets/{task}/{id}")
 	public String editTicketForm(@PathVariable Long id,@PathVariable String task, Model model) {
 		model.addAttribute("ticket", ticketService.getTicketById(id));
 		if(task.equals("edit")) {
 			return "edit_ticket";
 		}
 		return "view_ticket";
 	}
    
    @PostMapping("/tickets/{id}")
 	public String updateTicket(
 			@PathVariable Long id, 
 			@ModelAttribute("ticket") Ticket ticket, 
 			Model model) {

 		// get ticket from database by id
 		Ticket existingTicket = ticketService.getTicketById(id);
 		existingTicket.setId(id);
 		existingTicket.setTitle(ticket.getTitle());
 		existingTicket.setDescript(ticket.getDescript());
 		existingTicket.setCreateon(ticket.getCreateon());

 		// save updated ticket object
 		ticketService.updateTicket(existingTicket);
 		return "redirect:/tickets";
 	}	

    
    @GetMapping("/tickets/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicketById(id);
        return "redirect:/tickets";
    }

	
	

}