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
public class ConversationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        
        String groupName = req.getParameter("modelPosts");
        
        Alg.AlgUtil.GRP.createUser("name", "", "");
        
        User origin = Alg.AlgUtil.GRP.getUser("name");
        
        Alg.AlgUtil.GRP.addGroup("hello", origin , new ArrayList<String>(), new ArrayList<String>(), "convos");
        Alg.AlgUtil.GRP.getGroup("hello").sendValue("me", "bonjour");
        Alg.AlgUtil.GRP.getGroup("hello").sendValue("me", "hello");
        Alg.AlgUtil.GRP.getGroup("hello").sendValue("me", "hola");
        Alg.AlgUtil.GRP.getGroup("hello").sendValue("me", "ni hao");
        Alg.AlgUtil.GRP.getGroup("hello").sendValue("me", "aloha");
        Alg.AlgUtil.GRP.getGroup("hello").sendValue("me", "konichiwa");
        Group g = Alg.AlgUtil.GRP.getGroup(groupName);
        
        String json = g.getValueJson();
        System.out.println(json);
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(json);
    }
    
}
