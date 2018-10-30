package entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Mail implements BillItem{
    private long mid;
    private String sender;
    private String receiver;
    private LocalDateTime date;
    private double cost;

    @Override
    public double getAmount() {
        return 1.0;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public void print() {
        System.out.printf("[%s cost %5.2fdollors] %s >>>>> %s\n",date.toString(),cost,sender,receiver);
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
