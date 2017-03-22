package hello.ticket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.ticket.model.Ticket;
import hello.ticket.service.TicketService;

@RestController
@RequestMapping("/")
public class TicketController {

	@Autowired
	private TicketService ticketService ; 
	
	@RequestMapping( value = "/{id}" , method = RequestMethod.POST )
	public Ticket create( @RequestBody Ticket ticket ) {
		ticketService.create(ticket) ;
		return ticket ; 
	}
	
	@RequestMapping( value = "/tickets"  )
	public Map<String , List<Ticket>> getTickets(  ) {
		Map<String, List<Ticket>> ticketMap = new HashMap<String,List<Ticket>>();
		System.out.println("sample");
		ticketMap.put("ticket", ticketService.getTickets() ) ; 
		return ticketMap ;  
	} 
	
	
	
}
