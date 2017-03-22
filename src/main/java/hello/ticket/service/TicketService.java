package hello.ticket.service;


import java.util.List;

import hello.ticket.model.Ticket;

public interface TicketService {

	Ticket create( Ticket ticket ) ; 
	
	List<Ticket> getTickets() ; 
	
}
