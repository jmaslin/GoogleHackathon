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
            //String id = req.getParameter("rowID");
            
            String action = req.getParameter("purposeRadio");
            String item = req.getParameter("requestType");
            String locLat = req.getParameter("locLat"); 
            String locLng = req.getParameter("locLng"); 
            String phone = req.getParameter("contactPhone");
            String email = req.getParameter("contactEmail");
            String loc = req.getParameter("locLng");
            String lat = req.getParameter("locLat");
     
        try {


           ComparableRequestQuery t = Alg.AlgUtil.ALG.newQuery(action, item, new Point2D.Double(0, 0), "",phone,email);
        

           if (t != null){
               //sent stuff
                System.out.println("MATCH!");
               email(phone, email, "hello", "world");
              
           }
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("My bad");
        }

            System.out.println(loc);
          
           // res.sendRedirect(res.encodeRedirectURL("index.html"));

          //  System.out.println(loc);
         System.out.println("email:"+email);
          System.out.println("phone:"+phone);
          //  System.out.println(Alg.AlgUtil.ALG.list.get(0).values().size());
           // res.sendRedirect(res.encodeRedirectURL("index.html"));


        
           // res.sendRedirect(res.encodeRedirectURL("index.html"));


    }
    public void email(String number, String email, String messageText, String keyword){
                final String username = "tradersofstuff@gmail.com";
		final String password = "bananapan";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                //   System.out.print("here");
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
                        message.setSubject("Match found: "+keyword);
			message.setText(messageText);
			message.setFrom(new InternetAddress("tradersofstuff@gmail.com"));
                        if (number != null){
                                  System.out.println("here");
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@tmomail.net"));
                           
                          //   System.out.println(message.getAllRecipients());
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@txt.att.net"));
                            //Transport.send(message);
                          //   System.out.println(message.getAllRecipients());
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@vtext.com"));
                           // Transport.send(message);
                         //    System.out.println(message.getAllRecipients());
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@messaging.sprintpcs.com"));
                          //  Transport.send(message);
                          //   System.out.println(message.getAllRecipients());
                        }
                        if (email != null){
                            if(!email.equals("")){
                                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                               // Transport.send(message);
                               //  System.out.println(message.getAllRecipients());
                            }
                        }
                        
   
                      
			 Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
}
