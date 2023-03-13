package bike_service_application;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail {
     public static void sendmail1(String rec){
        System.out.println("----------------------Preparing to send mail------------------");
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        String username = "aswin96777@gmail.com";
        String password  = "";
        Session s = Session.getInstance(p, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });
        Message message = prepareMessage1(s,username,rec);       
        try{
            Transport.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.print("done!!");
    }
    public static void sendmail(String rec){
        System.out.println("----------------------Preparing to send mail------------------");
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        String username = "aswin96777@gmail.com";
        String password  = "";
        Session s = Session.getInstance(p, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });
        Message message = prepareMessage(s,username,rec);       
        try{
            Transport.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.print("done!!");
    }

    private static Message prepareMessage(Session s, String username, String rec) {
            Message m=new MimeMessage(s);
            try{
                m.setFrom(new InternetAddress(username));
                m.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
                m.setSubject("REGISTRATION");
                m.setText("WELCOME TO BIKE SERVICE CENTRE\n-----SUCCESSFULLY REGISTERD-----");
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return m;

    }
    private static Message prepareMessage1(Session s, String username, String rec) {
            Message m=new MimeMessage(s);
            try{
                m.setFrom(new InternetAddress(username));
                m.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
                m.setSubject("Booking");
                m.setText(Customer.usr+" has booked a service");
            }catch(Exception e){
                e.printStackTrace();
            }
            return m;

    }
}
