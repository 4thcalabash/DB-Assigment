package main;

import data.CallUtil;
import data.FlowUtil;
import data.MealUtil;
import data.UserUtil;
import entity.Bill;
import entity.BillItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BillTest {
    public final static LocalDateTime start = LocalDateTime.of(LocalDate.of(2018,10,27), LocalTime.of(0,0,0));
    public final static LocalDateTime end = LocalDateTime.of(LocalDate.of(2018,10,30),LocalTime.of(23,59,59));

    @Test
    public void callBillTest(){
        System.out.println("generate call bill"+start + " to "+ end);
        Long startt = System.currentTimeMillis();
        Bill bill = CallUtil.getInstance().getBill("110",start,end);
        Long endt = System.currentTimeMillis();
        System.out.println("time : "+ (endt - startt)+" millis");
        System.out.println("total-cost: "+ bill.getTotCost()+"dollors");
        System.out.println("total-amount: "+bill.getTotAmount()+"seconds");
        for (BillItem item : bill.getList()){
            item.print();
        }
    }
    @Test
    public void flowBillTest(){
        System.out.println("generate flow bill"+start + " to "+ end);
        Long startt = System.currentTimeMillis();
        Bill bill = FlowUtil.getInstance().getBill("110",start,end);
        Long endt = System.currentTimeMillis();
        System.out.println("time : "+ (endt - startt)+" millis");
        System.out.println("total-cost: "+bill.getTotCost()+"dollors");
        System.out.println("total-amount: "+bill.getTotAmount()+"KBs");
        for (BillItem item : bill.getList()){
            item.print();
        }
    }
    @Test
    public void mealBillTest(){
        System.out.println("generate meal bill"+start + " to "+ end);
        Long startt = System.currentTimeMillis();
        Bill bill = MealUtil.getInstance().getBill("110",start,end);
        Long endt = System.currentTimeMillis();
        System.out.println("time : "+ (endt - startt)+" millis");
        System.out.println("total-cost: "+bill.getTotCost()+"dollors");
        System.out.println("total-amount[call]: "+bill.getTotAmount()+"seconds");
        System.out.println("total-amount[mail]: "+bill.getTotAmount2()+"ones");
        System.out.println("total-amount[local_flow]: "+bill.getTotAmount3()+"KBs");
        System.out.println("total-amount[nation_flow]: "+bill.getTotAmount4()+"KBs");
        for (BillItem item : bill.getList()){
            item.print();
        }
    }
    @Test
    public void getCompleteBill(){
        System.out.println("generate complete bill from "+start + " to "+ end);
        Long startt = System.currentTimeMillis();
        Bill bill = UserUtil.getInstance().getBill("110",start,end);
        Long endt = System.currentTimeMillis();
        System.out.println("time : "+ (endt - startt)+" millis");
        System.out.println("total-cost: "+bill.getTotCost()+"dollors");
        System.out.println("total-amount[call]: "+bill.getTotAmount()+"seconds");
        System.out.println("total-amount[mail]: "+bill.getTotAmount2()+"ones");
        System.out.println("total-amount[flow]: "+bill.getTotAmount3()+"KBs");
        for (BillItem item : bill.getList()){
            item.print();
        }
    }
}
