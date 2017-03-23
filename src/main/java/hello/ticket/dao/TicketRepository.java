package hello.ticket.dao;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity, Long>{

	TicketEntity findByDescription( String description )  ;
}
