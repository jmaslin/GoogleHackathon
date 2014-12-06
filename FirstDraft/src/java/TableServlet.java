import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TableServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        int columns = Integer.parseInt(req.getParameter("last_name"));


        pw.println("<html>");
        pw.println("<head>");
        pw.println("<script type='text/javascript'>");  //This script runs whenever a table value is changed.
        pw.println("function myfunction(g)");
        pw.println("{");
        pw.println("document.getElementById('hidde'+g).value=document.getElementById(g).innerHTML"); //The script will set a hidden value to the changed data value.
        pw.println("return true");
        pw.println("}");
        pw.println("</script>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h4>Click outside of table to save. Do not press enter or a break will be added to text data. Click on the button below for final save and submit.");
      
        String garb = req.getParameter("first_name");
        String fName = garb;
        FileInputStream ins = new FileInputStream(fName);
        if (ins == null) { //Error message if filename cannot be found
            pw.println("Not Found");
            res.setStatus(res.SC_NOT_FOUND);
        } else { //If file is found, main code will run
            BufferedReader br = new BufferedReader((new InputStreamReader(ins)));
            String word;
            int count = 0;
            while ((word = br.readLine()) != null) {
                count += 1;
            }
            String mehh = req.getParameter("first_name");
            String meh = req.getParameter("last_name");
            FileInputStream inss = new FileInputStream(fName);
            BufferedReader cr = new BufferedReader(new InputStreamReader(inss));
            String strLine2;


            //Here an array will be created and populated with the contents of the file
            String[][] edit = new String[count + 1][columns];
            int cnt = 0;
            while ((strLine2 = cr.readLine()) != null) {
                String token1[] = strLine2.split(":");

                for (int i = 0; i < columns; i++) {

                    edit[cnt][i] = token1[i];
                }
                cnt++;
            }


            //This is where the html table is created
            pw.println("<form method='POST' action='NextServlet' name='yoho'><table id='mytable' border='1'  >");
            int xx = 0;
            for (int z = 0; z < count; z++) {
                pw.print("<tr style='padding:15px'>");
                for (int zz = 0; zz < columns; zz++) {
                    pw.print("<td style='padding:15px' oninput='myfunction(this.id)' contenteditable id='a" + xx + "'>" + edit[z][zz] + "</td>");
                    String fudg = "hiddea" + xx;
                    pw.println("<input type='hidden' id='" + fudg + "' name='" + fudg + "' value='" + edit[z][zz] + "' /><div></div>");
                    xx += 1;
                }
                pw.print("</tr>");
            }
            pw.println("<input type='hidden' id ='qwerty' name='qwerty' value='" + mehh + "'>");
            pw.println("<input type='hidden' id ='poli' name='poli' value='" + meh + "'>");

            pw.println("<input type='hidden' id ='asdf' name='asdf' value='0'>");
            pw.println("</table><p><input type='submit' value='Click to save changes' name='ede' onsubmit='myfunct()' /></p></form>");
            pw.println("</body></html>");
        }
    }
}
