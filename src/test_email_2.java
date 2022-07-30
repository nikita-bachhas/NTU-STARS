//from internet mailtrap
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class test_email_2{
   public void send_email(String coursecode, String Index, String Username) {
      //provide recipient's email ID
      String to = Username.concat("@e.ntu.edu.sg");

      //provide sender's email ID
      String from = "angelhfy1508@gmail.com";
      //provide Mailtrap's username
      final String username = "f38f02830542ee";
      //provide Mailtrap's password
      final String password = "af9a51b52a3b95";

      //provide Mailtrap's host address 
      String host = "smtp.mailtrap.io";
      //configure Mailtrap's SMTP server details 
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");  
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      //create the Session object
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
    }
         });

      try {
    //create a MimeMessage object
    Message message = new MimeMessage(session);
 
    //set From email field 
    message.setFrom(new InternetAddress(from));
 
    //set To email field
    message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
 
    //set email subject field
    message.setSubject("Out of Waitlist!!!");
 
    //set the content of the email message
    message.setText("Dear Student, "
    		+ ""
    		+ "You have successfully added Course " +coursecode+ " Index "+Index);

    //send the email message
    Transport.send(message);

    System.out.println("Email Message Sent Successfully");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}