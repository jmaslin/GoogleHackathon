/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Alg.Group;
import Alg.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xiaomao
 */
public class ListingsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        String type = req.getParameter("type");
        Alg.AlgUtil.GRP.createUser("name", "", "");
         User origin = Alg.AlgUtil.GRP.getUser("name");
            Alg.AlgUtil.GRP.addGroup("hello", origin , new ArrayList<String>(), new ArrayList<String>(), type);
        
        String json = Alg.AlgUtil.GRP.getGroupsByTypeJson(type);
        
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(json);
        
    }
    
}
