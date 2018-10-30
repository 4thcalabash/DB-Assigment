package entity;

import java.util.List;

public class Bill {
    private List<BillItem> list;
    private double totAmount;
    private double totAmount2;
    private double totAmount3;
    private double totAmount4;
    private double totCost;
    public Bill(List<BillItem>list){
        this.list = list;
        for (BillItem item : list){
            totAmount += item.getAmount();
            totCost += item.getCost();
        }
    }

    public double getTotAmount4() {
        return totAmount4;
    }

    public void setTotAmount4(double totAmount4) {
        this.totAmount4 = totAmount4;
    }

    public double getTotAmount2() {
        return totAmount2;
    }

    public void setTotAmount2(double totAmount2) {
        this.totAmount2 = totAmount2;
    }

    public double getTotAmount3() {
        return totAmount3;
    }

    public void setTotAmount3(double totAmount3) {
        this.totAmount3 = totAmount3;
    }

    public List<BillItem> getList() {
        return list;
    }

    public void setList(List<BillItem> list) {
        this.list = list;
    }

    public double getTotAmount() {
        return totAmount;
    }

    public void setTotAmount(double totAmount) {
        this.totAmount = totAmount;
    }

    public double getTotCost() {
        return totCost;
    }

    public void setTotCost(double totCost) {
        this.totCost = totCost;
    }
}
