/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Alg.ComparableRequestQuery;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
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

            String json = req.getParameter("data");
            JsonReader reader = new JsonReader(new StringReader(json));
            reader.beginObject();
            
            reader.skipValue();
            String name = reader.nextString();
            
            reader.skipValue();
            String action = reader.nextString();

            reader.skipValue();
            String request = reader.nextString();
            
            reader.skipValue();
            String locLat = reader.nextString();
            
            reader.skipValue();
            String locLng = reader.nextString();

            reader.skipValue();
            String phone = reader.nextString();

            reader.skipValue();
            String email = reader.nextString();
            
           
            System.out.println(json);
            double lat = Double.parseDouble(locLat);
            double lng = Double.parseDouble(locLng);

            
        try {

           ComparableRequestQuery t = Alg.AlgUtil.ALG.newQuery(action, request, new Point2D.Double(lat, lng), name, phone, email);
          
           
           if (t != null){
               //sent stuff
               //System.out.println("here");
               email(phone, email, name, request);
               System.out.println("MATCH!");
           }
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("My bad");
        }
            
        res.sendRedirect(res.encodeRedirectURL("index.html"));

    }
    public void email(String number, String email, String name, String keyword){
        final String username = "tradersofstuff@gmail.com";
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
			message.setFrom(new InternetAddress("tradersofstuff@gmail.com"));
                        if (number != null){
                           if (!number.equals("")){
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@tmomail.net"));
                           // message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@txt.att.net"));
                           // message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@vtext.com"));
                           // message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(number+"@messaging.sprintpcs.com"));
                           }
                        }
                        if (email != null){
                            if (!email.equals("")){
                            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                              System.out.println("here");
                            }
                        }
                        message.setSubject("Match found: "+keyword);
			message.setText("Name"+name);
                        
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
}
