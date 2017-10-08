/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorMailG;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gonzalo
 */
public class InterfazServidorMail {

    public void enviarCorreo(String to, String mes, Date fecha) {
        String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(fecha);
        sendEmail("controllecturasmasivo@gmail.com",
                "grupo4dsi",
                to,
                "Control Lectura de " + fechaString,
                mes);

    }

    private void sendEmail(String userName, String pass, String to, String subj, String men) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, pass);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subj);
            message.setText(men);

            Transport.send(message);

            System.out.println("\tResumen enviado con exito.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
