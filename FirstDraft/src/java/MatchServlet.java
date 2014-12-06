/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Alg.AlgUtil.ALG.newQuery(action, item, new Point2D.Double(0, 0), contact);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MatchServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("My bad");
        }
            System.out.println(action);
            System.out.println(Alg.AlgUtil.ALG.list.get(0).size());
            res.sendRedirect(res.encodeRedirectURL("index.html"));

    }

}
