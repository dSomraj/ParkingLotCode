package Service;

import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Repository.TicketRepository;
import Repository.VehicleRepository;
import Strategies.SlotAllotmentStrategy;
import Strategies.SlotAllotmentStrategyFactory;
import model.*;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    public TicketService(GateRepository gateRepository,TicketRepository ticketRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository){
        this.gateRepository=gateRepository;
        this.ticketRepository=ticketRepository;
        this.vehicleRepository=vehicleRepository;
        this.parkingLotRepository=parkingLotRepository;

    }
    public Ticket issueTicket(VehicleType vehicleType, String vehicleNumber, String ownerName, Long gateId){
        Ticket ticket=new Ticket();
        ticket.setEntryTime(new Date());
        Optional<Gate>gateOp=gateRepository.findById(gateId);
        if(!gateOp.isPresent()){
            throw new RuntimeException();
        }
        Gate gate=gateOp.get();
        ticket.setGeneratedBy(gate.getOperator());
        ticket.setEntryGate(gate);
        ticket.setTicketNumber(101);
        Optional<Vehicle> vehicleOp=vehicleRepository.getVehicleByNumber(vehicleNumber);
        if(!vehicleOp.isEmpty()){
            Vehicle v1=new Vehicle();
            v1.setOwnerName(ownerName);
            v1.setVehicleType(vehicleType);
            v1.setVehicleNumber(vehicleNumber);
            vehicleRepository.saveVehicle(v1);
        }
        ticket.setVehicle(vehicleOp.get());
        SlotAllotmentStrategyType slotAllotmentStrategyType=parkingLotRepository.getParkingLotByGate(gate).getSlotAllotmentStrategyType();
        SlotAllotmentStrategy slotAllotmentStrategy= SlotAllotmentStrategyFactory.getSlotForType(slotAllotmentStrategyType);
        ticket.setParkingSpot(slotAllotmentStrategy.getSpot(vehicleType,gate));
        ticketRepository.saveTicket(ticket);
        return ticket;


    }
}
