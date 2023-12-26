package model;

import Strategies.FeeCalculationStrategy;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private List<Payment> payments;
    private Ticket ticket;
    private int totalAmount;
    private Date exitTime;
    private Gate exitGate;
    private FeeCalculationStrategy feeCalculationStrategy;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public FeeCalculationStrategy getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }
}
