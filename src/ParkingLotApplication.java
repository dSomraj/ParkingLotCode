import Controller.TicketController;
import Dto.IssueTicketRequestDto;
import Dto.IssueTicketResponseDto;
import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Repository.TicketRepository;
import Repository.VehicleRepository;
import Service.TicketService;
import model.VehicleType;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository=new GateRepository();
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();
        TicketRepository ticketRepository=new TicketRepository();

        TicketService ticketService=new TicketService(gateRepository,ticketRepository,vehicleRepository,parkingLotRepository);
        TicketController ticketController=new TicketController(ticketService);
        IssueTicketRequestDto issueTicketRequestDto=new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(01L);
        issueTicketRequestDto.setOwnerName("Mr. Hindol Bhattacharjee");
        issueTicketRequestDto.setVehicleNumber("BH 01 0007");
        issueTicketRequestDto.setVehicleType(VehicleType.FourWheeler);
        IssueTicketResponseDto parkingTicket;
        parkingTicket=ticketController.issueTicket(issueTicketRequestDto);

    }
}
