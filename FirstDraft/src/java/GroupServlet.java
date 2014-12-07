/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Alg.User;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        String name = req.getParameter("name");
        String action = req.getParameter("action");
        String number = req.getParameter("number");
        String groupName = req.getParameter("groupName");
        
        if (!Alg.AlgUtil.GRP.getUserList().keySet().contains(name))
            Alg.AlgUtil.GRP.createUser(name, number, "");
        
        User temp = Alg.AlgUtil.GRP.getUser(name);
        
        //join
        if (action.equals("join")){
            Alg.AlgUtil.GRP.getGroup(groupName).subscribe(temp);
        }
        //leave
//        if (action.)
        //send
    }

}
