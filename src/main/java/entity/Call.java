package entity;


import java.time.LocalDateTime;

public class Call implements BillItem {
    private long cid;
    private String caller;
    private String listener;
    private LocalDateTime start_date;
    private long duration;
    private double cost;

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    @Override
    public double getAmount() {
        return duration;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener;
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
        System.out.printf("[%s %3dseconds & cost %5.2fdollors] %s >>>>> %s\n",getStart_date().toString(),getDuration(),getCost(),getCaller(),getListener());

    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
