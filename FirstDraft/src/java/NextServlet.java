
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NextServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        String fName = req.getParameter("qwerty");
        FileInputStream ins = new FileInputStream(fName);
        if (ins == null) {//Error message if filename is not found.
            pw.println("Not Found");
            res.setStatus(res.SC_NOT_FOUND);
        } else { //If filename is found, main code will run
            BufferedReader br = new BufferedReader((new InputStreamReader(ins)));
            String word;
            int count = 0;
            int row = Integer.parseInt(req.getParameter("asdf"));
            int columns = Integer.parseInt(req.getParameter("poli"));
            while ((word = br.readLine()) != null) {
                count += 1;
            }

            FileInputStream inss = new FileInputStream(fName);

            BufferedReader cr = new BufferedReader(new InputStreamReader(inss));
            String strLine2;
            String[][] edit = new String[count + 1 + row][columns];
            int cnt = 0;

            //Here an array will be created and populated by the contents of the file.
            while ((strLine2 = cr.readLine()) != null) {
                String token1[] = strLine2.split(":");

                for (int i = 0; i < columns; i++) {

                    edit[cnt][i] = token1[i];
                }
                cnt++;
            }
            int xx = 0;

            for (int p = 0; p < count; p++) {//In this loop, the array will recieve changed values based off of the hidden values of the previous servlet.
                for (int pp = 0; pp < columns; pp++) {
                    String meh = req.getParameter("hiddea" + xx);
                    edit[p][pp] = meh;
                    xx++;
                }
            }
            if (row != 0) {//This loop will add additional rows if the variable for rows does not equal 0.
                for (int a = count; a < (count + row); a++) {
                    for (int aa = 0; aa < columns; aa++) {
                        String meh = req.getParameter("hiddea" + xx);
                        edit[a][aa] = meh;
                        xx++;
                    }
                }
            }
            //The following code will take the array and write its contents into a file with the same name.
            StringBuilder fileContent = new StringBuilder();
            FileWriter hstreamWrite = new FileWriter(fName);
            BufferedWriter out = new BufferedWriter(hstreamWrite);
            for (int a = 0; a < (count + row); a++) {
                for (int b = 0; b < columns; b++) {
                    String newline = edit[a][b] + ":";
                    fileContent.append(newline);
                    out.write(newline.toString());
                }
                out.newLine();
            }
            out.close();
            String mehh = req.getParameter("qwerty");
            pw.println("Your file has been changed and the location is: " + mehh);
        }
    }
}
