/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Alg.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
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
public class GroupServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        //action
        String action = "blank";
        String message = "blank";
        String groupName = req.getParameter("modalPosts");
        String email = "blank";
        String phone = "blank";
        String sender = "blank";
        //user who send request
        User origin = Alg.AlgUtil.GRP.getUser(sender);
        
        //create user
        //add user to server?????
        Alg.AlgUtil.GRP.createUser(sender, phone, email);
        
        /*
        * *********
        * SHOP FUNCTIONALITY
        * - Owner updates items and updates all sub
        * - Sub can ping to get inv list
        * - Sub can buy : remove from inv list and message owner
        */
        User owner = Alg.AlgUtil.GRP.getGroup(groupName).getOwner();
        
        //buy
        Alg.AlgUtil.GRP.getGroup(groupName).getValues().remove(message);
        //notify owner
        email(owner.getNumber(), owner.getEmail(), message + "Buyer: "+ sender+"Contact: "+email + " "+phone, groupName);
        //notify if non existant
        
        //update
        Alg.AlgUtil.GRP.getGroup(groupName).sendValue(sender, message);
        
        //sub ping inv
        //don't actually loop this is dumb, long str
        String inv = "";
        for (String s: Alg.AlgUtil.GRP.getGroup(groupName).getValues())
            inv = inv + " "+s;
            
        email(phone, email, inv, groupName);
        
        /*
        * GROUP FUNCTIONALITY
        */
        
        //get list of user groups
        ArrayList<String> groups = Alg.AlgUtil.GRP.getUser(sender).getGroups();
        String g = "";
        for (String e : groups)
            g = g + " "+e;
        email(phone, email, g, "All Groups");
        
        //add validation
        //create group
        Alg.AlgUtil.GRP.addGroup(groupName, origin , new ArrayList<String>(), new ArrayList<String>());
        //join group
        Alg.AlgUtil.GRP.getGroup(groupName).subscribe(origin);
        //leave group
        Alg.AlgUtil.GRP.getGroup(groupName).unsubscribe(origin);
        
        //send group message
        //get message, loop through users and send email individually
        //if action is to chat
        Alg.AlgUtil.GRP.getGroup(groupName).sendValue(sender, message);
        for (User e : Alg.AlgUtil.GRP.getGroup(groupName).getUsers()){
            if (!e.getName().equals(sender))
                email(e.getNumber(), e.getNumber(), message, groupName);
        }
        
        //make json here
        
        //forward group  object
        req.setAttribute("group", Alg.AlgUtil.GRP.getGroup(groupName));
        //index address??
        req.getRequestDispatcher("index.html").forward(req, res);
        
    }
    public void email(String number, String email, String messageText, String groupName){
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
                        message.setSubject(groupName);
			message.setText(messageText);
                        
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
}
