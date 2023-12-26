package model;
import Strategies.FeeCalculationStrategy;
import Strategies.SlotAllotmentStrategy;

import java.util.List;
public class ParkingLot extends BaseModel{
    private String name;
    private List<Floor> floors;
    private List<Gate> gates;
    private String address;
    private ParkingLotStatus parkingLotStatus;
    private SlotAllotmentStrategyType slotAllotmentStrategyType;
    private FeeCalculationStrategyType feeCalculationStrategyType;

    public SlotAllotmentStrategyType getSlotAllotmentStrategyType() {
        return slotAllotmentStrategyType;
    }

    public void setSlotAllotmentStrategyType(SlotAllotmentStrategyType slotAllotmentStrategyType) {
        this.slotAllotmentStrategyType = slotAllotmentStrategyType;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}
