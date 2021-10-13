package modelo;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Correo {

    public boolean EnvioMail(String pCorreo, String pCodigoPlan, String pEscuela) {
      
        final String username = "gestorplanesestudio@gmail.com";
        final String password = "GestorPlanesEstudio_52";
        String fromEmail = "gestorplanesestudio@gmail.com";
        String toEmail = pCorreo;

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Plan de Estudio " + pCodigoPlan);

            Multipart emailContent = new MimeMultipart();
            
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Se adjunta el Plan de Estudios de la escuela de " + pEscuela);

            MimeBodyPart pdfAttachment = new MimeBodyPart();
            pdfAttachment.attachFile("planestudio.pdf");

            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(pdfAttachment);

            msg.setContent(emailContent);

            Transport.send(msg);
            System.out.println("Sent message");
            
            return true;
        } catch (MessagingException | IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

}
