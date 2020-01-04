import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
// Отправка простого сообщения с типом контента "text/plain"
public class mail {
    public static boolean sendmessage(String email,String pass) {
        // Сюда необходимо подставить адрес получателя сообщения
        // sender email
        String from = "kill.real.2019@gmail.com";       // receiver email
        String host = "smtp.gmail.com";            // mail server host
        String password="worldoftanks00";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session); // email message
            message.setFrom(new InternetAddress(from)); // setting header fields
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("registration"); // subject line
            message.setText("Your password "+pass);
            Transport.send(message);
            return true;

        } catch (MessagingException mex){ return false; }
    }}