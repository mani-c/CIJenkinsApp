package hello.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.ticket.model.Ticket;
import hello.ticket.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService ; 
	
	@RequestMapping( value = "/{id}" , method = RequestMethod.POST )
	public Ticket create( @RequestBody Ticket ticket ) {
		ticketService.create(ticket) ;
		return ticket ; 
	}
	
	
	
}
