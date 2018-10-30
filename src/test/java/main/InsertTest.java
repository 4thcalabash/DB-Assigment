package main;

import data.CallUtil;
import data.FlowUtil;
import data.MailUtil;
import data.MealUtil;
import entity.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Random;

public class InsertTest {
    private static final String user[] = {"110","119","120","911"};
    private static final double cost[] = {1.2,0.5,3.5,1.6};
    private static final double amount[] = {12,30,50,1.55};
    private static final Long duration[] = {10L,20L,30L,40L};

    @Test
    public void FLowInsertTest() throws Exception {
        System.out.println("insert flow record");
        Flow flow = new Flow();
        flow.setAmount(amount[new Random().nextInt(amount.length)]);
        flow.setCost(cost[new Random().nextInt(cost.length)]);
        flow.setDate(LocalDateTime.now());
        flow.setDuration(duration[new Random().nextInt(duration.length)]);
        flow.setType(new Random().nextInt(2) == 0?"LOCAL":"NATION");
        flow.setUser(user[new Random().nextInt(user.length)]);
        Long start = System.currentTimeMillis();
        FlowUtil.getInstance().insert(flow);
        Long end = System.currentTimeMillis();
        System.out.println("time : "+ (end - start)+" millis");
    }
    @Test
    public void callInsertTest(){
        System.out.println("insert call record");
        Call call = new Call();call.setCost(cost[new Random().nextInt(cost.length)]);
        call.setDuration(duration[new Random().nextInt(duration.length)]);
        call.setStart_date(LocalDateTime.now());
        call.setListener(user[new Random().nextInt(user.length)]);
        call.setCaller(user[new Random().nextInt(user.length)]);
        Long start = System.currentTimeMillis();
        CallUtil.getInstance().insert(call);
        Long end = System.currentTimeMillis();
        System.out.println("time : "+ (end - start)+" millis");
    }
    @Test
    public void mailInsertTest(){
        System.out.println("insert mail record");
        Mail mail = new Mail();
        mail.setCost(cost[new Random().nextInt(cost.length)]);
        mail.setSender(user[new Random().nextInt(user.length)]);
        mail.setReceiver(user[new Random().nextInt(user.length)]);
        mail.setDate(LocalDateTime.now());
        Long start = System.currentTimeMillis();
        MailUtil.getInstance().insert(mail);
        Long end = System.currentTimeMillis();
        System.out.println("time : "+ (end - start)+" millis");
    }
    @Test
    public void mealInsertTest(){
        System.out.println("insert meal record");
        Meal meal;
        int x = new Random().nextInt(4);
        if (x == 0){
            meal = Meal.CALL_MEAL;
        }else if (x == 1){
            meal = Meal.MAIL_MEAL;
        }else if (x == 2){
            meal = Meal.LOCAL_MEAL;
        }else{
            meal = Meal.NATION_MEAL;
        }
        meal.setCost(cost[new Random().nextInt(cost.length)]);
        meal.setStartDate(LocalDateTime.now());
        meal.setExceedCallCost(cost[new Random().nextInt(cost.length)]);
        meal.setExceedMailCost(cost[new Random().nextInt(cost.length)]);
        meal.setExceedLocalFlowCost(cost[new Random().nextInt(cost.length)]);
        meal.setExceedNationFlowCost(cost[new Random().nextInt(cost.length)]);
        meal.setFreeCall(1.0*amount[new Random().nextInt(amount.length)]);
        meal.setFreeMail((int)amount[new Random().nextInt(amount.length)]);
        meal.setFreeNationFlow(amount[new Random().nextInt(amount.length)]);
        meal.setFreeLocalFlow(amount[new Random().nextInt(amount.length)]);
        meal.setEndDate(LocalDateTime.now());
        meal.setOwner(user[new Random().nextInt(user.length)]);
        Long start = System.currentTimeMillis();
        MealUtil.getInstance().insert(meal);
        Long end = System.currentTimeMillis();
        System.out.println("time : "+ (end - start)+" millis");
    }
}
