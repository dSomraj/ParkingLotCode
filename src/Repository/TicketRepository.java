package Repository;

import model.Ticket;

import java.util.HashSet;
import java.util.Set;

public class TicketRepository {
    Set<Ticket> set=new HashSet<>();
    public Ticket saveTicket(Ticket ticket){
        set.add(ticket);
        return ticket;
    }
}
