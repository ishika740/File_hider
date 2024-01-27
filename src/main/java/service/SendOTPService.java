package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendOTPService {
    public static void sendOTP(String email, String genOTP) {
        //Recipient's email ID
        String to = email;
        //Sender's email ID
        String from = "7404032215a@gmail.com";
        //Assuming you are sending email from through gmail smtp
        String host = "smtp.gmail.com";
        //Get system properties
        Properties properties = System.getProperties();
        //setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //get the session object and pass username and password
        Session session = Session.getInstance(properties, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, "osww gppj ffkd cvtb");
                    }
        });
        //used to debug SMTP issues
        session.setDebug(true);

        try {
            //Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);
            //set from: header field of the header
            message.setFrom(new InternetAddress(from));
            //set to: header field of the header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //set subject : header field
            message.setSubject("File Enc ka OTP");
            //Now set the actual message
            message.setText("Your OTP for file Enc app is" + genOTP);
            System.out.println("sending...");
            //Send message
            Transport.send(message);
            System.out.println("Sent message Successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
