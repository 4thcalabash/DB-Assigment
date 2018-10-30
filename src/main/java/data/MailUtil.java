package data;

import entity.Bill;
import entity.Mail;

import java.time.LocalDateTime;


public class MailUtil extends EntityUtil {
    private static MailUtil instance = new MailUtil();
    private MailUtil(){}
    public static MailUtil getInstance(){return instance;}
    public void insert(Mail mail){
        super.insert(mail);
    }
    public Bill getBill(String user, LocalDateTime start,LocalDateTime end){
        String hql = "from Mail where send_date >=\'"+ start.toString()+"\' and send_date <= \'"+ end.toString()+"\' and sender = \'"+user+"\'";
        return new Bill(super.query(hql));
    }
}
