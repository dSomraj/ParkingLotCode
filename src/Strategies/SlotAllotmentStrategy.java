package Strategies;

import model.Gate;
import model.ParkingSpot;
import model.SlotAllotmentStrategyType;
import model.VehicleType;

public interface SlotAllotmentStrategy {
    public ParkingSpot getSpot(VehicleType vehicleType, Gate gate);
}
