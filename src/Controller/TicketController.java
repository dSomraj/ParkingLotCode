package Controller;

import Dto.IssueTicketRequestDto;
import Dto.IssueTicketResponseDto;
import Dto.ResponseStatus;
import Service.TicketService;
import model.Ticket;

public class TicketController {
//    public IssueTicketResponseDto bookingTicketController(IssueTicketRequestDto issueTicketRequestDto){
//        return null;
//    }  // we can directly return ticket as our ticket model does not contain any such security threat
    TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto req){
        IssueTicketResponseDto issueTicketResponseDto=new IssueTicketResponseDto();
        Ticket ticket;
        try{
            ticket=ticketService.issueTicket(req.getVehicleType(),req.getVehicleNumber(),req.getOwnerName(),req.getGateId());

        }
        catch (Exception e){
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILED);
            issueTicketResponseDto.setErrorMessage(e.getMessage());
            //System.out.println(e.getMessage());
            return issueTicketResponseDto; // as all are private attributes so what we set only it will show to the client
        }
        issueTicketResponseDto.setParkingSpot(ticket.getParkingSpot());
        issueTicketResponseDto.setTicketNumber(ticket.getTicketNumber());
        issueTicketResponseDto.setVehicleNumber(ticket.getVehicle().getVehicleNumber());
        issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return issueTicketResponseDto;
    }

}
