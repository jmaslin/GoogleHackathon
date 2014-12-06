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
            String action = req.getParameter("purposeRadio");
            String item = req.getParameter("requestType");
            String locLat = req.getParameter("locLat"); 
            String locLng = req.getParameter("locLng"); 
            String contact = req.getParameter("contactPhone");
            
        try {
           ComparableRequestQuery t = Alg.AlgUtil.ALG.newQuery(action, item, new Point2D.Double(0, 0), contact);
           if (t != null){
               //sent stuff
               email();
           }
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("My bad");
        }
            System.out.println(action);
            System.out.println(Alg.AlgUtil.ALG.list.get(0).size());
            res.sendRedirect(res.encodeRedirectURL("index.html"));

    }
    public void email(){
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
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("8562468429@tmomail.net"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
}
