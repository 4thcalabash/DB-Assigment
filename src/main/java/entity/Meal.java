package entity;

import java.security.acl.Owner;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Meal implements BillItem{
    public static final Meal CALL_MEAL = new Meal(),MAIL_MEAL = new Meal(),LOCAL_MEAL = new Meal(),NATION_MEAL = new Meal();
    static{
        CALL_MEAL.setCost(20.0);
        CALL_MEAL.setFreeCall(100.0);
        CALL_MEAL.setExceedCallCost(0.5);
        CALL_MEAL.setExceedMailCost(0.1);
        CALL_MEAL.setExceedLocalFlowCost(2);
        CALL_MEAL.setExceedNationFlowCost(5);

        MAIL_MEAL.setCost(10.0);
        MAIL_MEAL.setFreeMail(200);
        MAIL_MEAL.setExceedMailCost(0.1);
        MAIL_MEAL.setExceedCallCost(0.5);
        MAIL_MEAL.setExceedLocalFlowCost(2);
        MAIL_MEAL.setExceedNationFlowCost(5);

        LOCAL_MEAL.setCost(20);
        LOCAL_MEAL.setFreeLocalFlow(2*1024*1024);
        LOCAL_MEAL.setExceedMailCost(0.1);
        LOCAL_MEAL.setExceedCallCost(0.5);
        LOCAL_MEAL.setExceedLocalFlowCost(2);
        LOCAL_MEAL.setExceedNationFlowCost(5);

        NATION_MEAL.setCost(30);
        NATION_MEAL.setFreeNationFlow(2*1024*1024);
        NATION_MEAL.setExceedNationFlowCost(3);
        LOCAL_MEAL.setExceedMailCost(0.1);
        LOCAL_MEAL.setExceedCallCost(0.5);
        LOCAL_MEAL.setExceedLocalFlowCost(2);

    };
    private long mid;
    private String owner;
    private double cost;
    private double freeCall;
    private int freeMail;
    private double freeLocalFlow;
    private double freeNationFlow;
    private double exceedCallCost;
    private double exceedMailCost;
    private double exceedLocalFlowCost;
    private double exceedNationFlowCost;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    protected Meal(){};
    @Override
    public double getAmount() {
        return freeCall+ freeNationFlow+ freeLocalFlow + freeMail;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public void print() {
        if (freeCall>0){
            System.out.printf("[%s - %s %5.2fminutes & cost %5.2f] %s\n",
                    startDate.toString(),endDate.toString(),freeCall,cost, owner);
        }else if (freeMail>0){
            System.out.printf("[%s - %s %5dones & cost %5.2f] %s\n",
                    startDate.toString(),endDate.toString(),freeMail,cost, owner);
        }else if (freeLocalFlow>0){
            System.out.printf("[%s - %s %5.2fKBs[Local] & cost %5.2f] %s\n",
                    startDate.toString(),endDate.toString(),freeLocalFlow,cost, owner);
        }else if (freeNationFlow >0){
            System.out.printf("[%s - %s %5.2fKBs[Nation] & cost %5.2f] %s\n",
                    startDate.toString(),endDate.toString(),freeNationFlow,cost, owner);
        }
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getFreeCall() {
        return freeCall;
    }

    public void setFreeCall(double freeCall) {
        this.freeCall = freeCall;
    }

    public int getFreeMail() {
        return freeMail;
    }

    public void setFreeMail(int freeMail) {
        this.freeMail = freeMail;
    }

    public double getFreeLocalFlow() {
        return freeLocalFlow;
    }

    public void setFreeLocalFlow(double freeLocalFlow) {
        this.freeLocalFlow = freeLocalFlow;
    }

    public double getFreeNationFlow() {
        return freeNationFlow;
    }

    public void setFreeNationFlow(double freeNationFlow) {
        this.freeNationFlow = freeNationFlow;
    }

    public double getExceedCallCost() {
        return exceedCallCost;
    }

    public void setExceedCallCost(double exceedCallCost) {
        this.exceedCallCost = exceedCallCost;
    }

    public double getExceedMailCost() {
        return exceedMailCost;
    }

    public void setExceedMailCost(double exceedMailCost) {
        this.exceedMailCost = exceedMailCost;
    }

    public double getExceedLocalFlowCost() {
        return exceedLocalFlowCost;
    }

    public void setExceedLocalFlowCost(double exceedLocalFlowCost) {
        this.exceedLocalFlowCost = exceedLocalFlowCost;
    }

    public double getExceedNationFlowCost() {
        return exceedNationFlowCost;
    }

    public void setExceedNationFlowCost(double exceedNationFlowCost) {
        this.exceedNationFlowCost = exceedNationFlowCost;
    }
}
