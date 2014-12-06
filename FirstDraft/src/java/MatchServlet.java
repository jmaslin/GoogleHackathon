/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            String loc = req.getParameter("location");
            String contact = req.getParameter("contactPhone");
            System.out.println(action);
            res.sendRedirect(res.encodeRedirectURL("index.html"));

    }

}
