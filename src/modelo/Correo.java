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

/**
 * Clase que permite la conexión con Gmail para enviar el correo electrónico
 *
 * @author Gustavo
 * @version 09/10/2021
 */
public class Correo {

  /**
   * Constructor de la clase
   * 
   * @param pCorreo     la dirección de correo electrónico del destinatario
   * @param pCodigoPlan el código del plan de estudios consultado
   * @param pEscuela    el nombre de la escuela propietaria del plan de estudios
   * @return Un booleano que indica si el envío fue exitoso.
   */
  public boolean EnvioMail(String pCorreo, String pCodigoPlan, String pEscuela){
    //Propiedades para la conexión con Gmail
    final String username = "gestorplanesestudio@gmail.com";
    final String password = "GestorPlanesEstudio_52";
    String fromEmail = "gestorplanesestudio@gmail.com";
    String toEmail = pCorreo;

    //Establecimiento de las propiedades
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS
    prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

    //Creación de la sesión
    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });

    MimeMessage msg = new MimeMessage(session);
    try{
      msg.setFrom(new InternetAddress(fromEmail));
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
      msg.setSubject("Plan de Estudio " + pCodigoPlan);

      Multipart emailContent = new MimeMultipart();

      //Cuerpo del correo
      MimeBodyPart textBodyPart = new MimeBodyPart();
      textBodyPart.setText("Se adjunta el Plan de Estudios de la escuela de " + pEscuela);

      //PDF del plan de estudios adjunto
      MimeBodyPart pdfAttachment = new MimeBodyPart();
      pdfAttachment.attachFile("planestudio.pdf");

      emailContent.addBodyPart(textBodyPart);
      emailContent.addBodyPart(pdfAttachment);

      msg.setContent(emailContent);

      Transport.send(msg);
      System.out.println("Sent message");
      return true;
      
    } catch (MessagingException | IOException e){
      System.err.println(e.getMessage());
      return false;
    }
  }
}
