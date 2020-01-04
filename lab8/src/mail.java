import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class mail {
    public static boolean sendmessage(String email,String pass,String s) {
        String from = "kill.real.2019@gmail.com";
        String host = "smtp.gmail.com";
        String password="worldoftanks00";
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "false");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(s); // subject line
            message.setText("Your password "+pass);
            Transport.send(message);
            return true;
        } catch (MessagingException mex){ return false; }
    }}