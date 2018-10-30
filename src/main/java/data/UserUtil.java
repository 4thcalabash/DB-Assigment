package data;

import entity.Bill;
import entity.BillItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserUtil extends EntityUtil {
    private static UserUtil instance = new UserUtil();
    private UserUtil(){}
    public static UserUtil getInstance(){return instance;}
    public Bill getBill(String user, LocalDateTime start,LocalDateTime end){
        Bill callBill = CallUtil.getInstance().getBill(user,start,end);
        Bill mailBill = MailUtil.getInstance().getBill(user,start,end);
        Bill flowBill = FlowUtil.getInstance().getBill(user,start,end);
        List<BillItem> list = new ArrayList<>();
        list.addAll(callBill.getList());
        list.addAll(mailBill.getList());
        list.addAll(flowBill.getList());
        Bill bill = new Bill(list);
        bill.setTotAmount(callBill.getTotAmount());
        bill.setTotAmount2(mailBill.getTotAmount());
        bill.setTotAmount3(flowBill.getTotAmount());
        return bill;
    }
}
