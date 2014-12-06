/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Alg.ComparableRequestQuery;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.time.Clock;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xiaomao
 */
public class MatchServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        //System.out.println("Hello");
         //   res.setContentType("application/json;charset=UTF-8");
            String id = req.getParameter("rowID");
            
            String action = req.getParameter("purposeRadio");
            String item = req.getParameter("requestType");
            String locLat = req.getParameter("locLat"); 
            String locLng = req.getParameter("locLng"); 
<<<<<<< HEAD

            String phone = req.getParameter("contactPhone");
            String email = req.getParameter("contactEmail");
=======
            String contact = req.getParameter("contactPhone");
>>>>>>> parent of f05caa6... t

            
            double lat = Double.parseDouble(locLat);
            double lng = Double.parseDouble(locLng);

            
        try {
<<<<<<< HEAD
           ComparableRequestQuery t = Alg.AlgUtil.ALG.newQuery(action, item, new Point2D.Double(lat, lng), phone);
          

=======
           ComparableRequestQuery t = Alg.AlgUtil.ALG.newQuery(action, item, new Point2D.Double(lat, lng), contact, "hello ", "hello");
          
>>>>>>> parent of f05caa6... t
           if (t != null){
               //sent stuff
               //email();
               System.out.println("MATCH!");
           }
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("My bad");
        }
            
            System.out.println(Alg.AlgUtil.ALG.list.get(0).size());
            res.sendRedirect(res.encodeRedirectURL("index.html"));

    }
    public void email(String number, String email, String messageText, String keyword){
        final String username = "letsexchangegoods@gmail.com";
		final String password = "bananapan";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("letsexchangegoods@gmail.com"));
                        if (number != null){
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@tmomail.net"));
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@txt.att.net"));
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@vtext.com"));
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@messaging.sprintpcs.com"));
                        }
                        if (email != null)
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
 
                        message.setSubject("Match found: "+keyword);
			message.setText(messageText);
                        
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
}
