package data;

import entity.Bill;
import entity.Flow;

import java.time.LocalDateTime;


public class FlowUtil extends EntityUtil {
    private static FlowUtil instance = new FlowUtil();
    private FlowUtil(){}
    public static FlowUtil getInstance(){return instance;}
    public void insert(Flow flow){
        super.insert(flow);
    }
    public Bill getBill(String user, LocalDateTime start,LocalDateTime end){
        String hql = "from Flow where caller = \'"+user+
                "\' and date >= \'" + start.toString()+"\' and date <= \'"+
                end.toString()+"\'";
        //System.out.println(hql);
        return new Bill(super.query(hql));
    }
}
