package hello.ticket.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.ticket.dao.TicketEntity;
import hello.ticket.dao.TicketRepository;
import hello.ticket.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository ; 
	
	private static long COUNTER = 1 ; 

	@Override
	public Ticket create(Ticket ticket) {
		TicketEntity ticketEntity = new TicketEntity() ; 
		BeanUtils.copyProperties( ticket, ticketEntity );
		ticketEntity.setId( COUNTER++ ) ;
		ticketRepository.save( ticketEntity ) ; 
		return null;
	}

	@Override
	public List<Ticket> getTickets() {
		Iterable<TicketEntity> ticketEntities = ticketRepository.findAll() ;
		List<Ticket> tickets = new ArrayList<Ticket>();
		if( ticketEntities != null ) {
			Iterator<TicketEntity> ticketIter = ticketEntities.iterator() ; 
			while( ticketIter.hasNext() ) {
				Ticket ticket = new Ticket() ;
				BeanUtils.copyProperties( ticketIter.next(), ticket );
				tickets.add(ticket) ; 
			}
		} 
		return tickets;
	}

}
