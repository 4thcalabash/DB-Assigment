package entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
public class Flow implements BillItem {
    private long fid;
    private String user;
    @Enumerated(EnumType.STRING)
    private FlowType type;
    private double amount;
    private LocalDateTime date;
    private long duration;
    private double cost;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public String getType() {
        return type.getName();
    }

    public void setType(String type) throws Exception {
        if (type.equals(FlowType.LOCAL.getName())){
            this.type = FlowType.LOCAL;
        }else if (type.equals(FlowType.NATION.getName())){
            this.type = FlowType.NATION;
        }else{
            throw new Exception();
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public void print() {
        System.out.printf("[%s %3dseconds & cost %5.2fdollors] %s used %5.2f KBs[%s]\n",getDate().toString(),getDuration(),getCost(),getUser(),getAmount(),getType());

    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
