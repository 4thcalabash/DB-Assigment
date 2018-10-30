package data;

import entity.Bill;
import entity.BillItem;
import entity.Call;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CallUtil extends EntityUtil {
    private static CallUtil instance = new CallUtil();
    private CallUtil(){}
    public static CallUtil getInstance(){return instance;}
    public void insert(Call call){
        super.insert(call);
    }
    public Bill getBill(String user,LocalDateTime start,LocalDateTime end){
        String hql = "from Call where start_date >=\'" + start.toString() + "\' and start_date <= \'"+ end.toString()+"\' and caller = \'"+ user+"\'";
        //System.out.println(hql);
        List<BillItem> res = super.query(hql);
        return new Bill(res);
    }
}
