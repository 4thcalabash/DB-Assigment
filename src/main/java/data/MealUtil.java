package data;


import entity.Bill;
import entity.BillItem;
import entity.Meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MealUtil extends EntityUtil {
    private static MealUtil instance = new MealUtil();
    private MealUtil(){}
    public static MealUtil getInstance(){return instance;}
    public void insert(Meal meal){
        super.insert(meal);
    }
    public Bill getBill(String user, LocalDateTime start,LocalDateTime end){
        String hql = "from Meal where start_date <=\'"+ end.toString()+
                "\' and end_date >= \'"+ start.toString()+"\' and owner = \'"+user+"\' and free_call >0";
        Bill callBill = new Bill(super.query(hql));
        hql = "from Meal where start_date <=\'"+ end.toString()+
                "\' and end_date >= \'"+ start.toString()+"\' and owner = \'"+user+"\' and free_mail >0";
        Bill mailBill = new Bill(super.query(hql));
        hql = "from Meal where start_date <=\'"+ end.toString()+
                "\' and end_date >= \'"+ start.toString()+"\' and owner = \'"+user+"\' and free_local_flow >0";
        Bill localBill = new Bill(super.query(hql));
        hql = "from Meal where start_date <=\'"+ end.toString()+
                "\' and end_date >= \'"+ start.toString()+"\' and owner = \'"+user+"\' and free_nation_flow >0";
        Bill nationBill = new Bill(super.query(hql));
        Bill bill = new Bill(new ArrayList<BillItem>());
        bill.setTotAmount(callBill.getTotAmount());
        bill.setTotAmount2(mailBill.getTotAmount());
        bill.setTotAmount3(localBill.getTotAmount());
        bill.setTotAmount4(nationBill.getTotAmount());
        bill.getList().addAll(callBill.getList());
        bill.getList().addAll(mailBill.getList());
        bill.getList().addAll(localBill.getList());
        bill.getList().addAll(nationBill.getList());
        return bill;
    }
}
