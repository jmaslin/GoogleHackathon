import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
public class XMLServler2 extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException
{
res.setContentType("text/html;charset=UTF-8");
PrintWriter pw = res.getWriter();
int columns=Integer.parseInt(req.getParameter("last_name"));
ServletContext cntxt = getServletContext();

pw.println("<html>");
pw.println("<head>");
pw.println("<script");
pw.println("function loadXMLDoc(filename){");
pw.println("if (window.XMLHttpRequest){");
pw.println("xhttp=new XMLHttpRequest();}");
pw.println("xhttp.open('GET',filename,false);");
pw.println("xhttp.send();");
pw.println("return xhttp.responseXML;");
pw.println("</script>");
pw.println("");
pw.println("");
pw.println("<script type='text/javascript'>");
pw.println("function myfunction(g)");
pw.println("{");
pw.println("document.getElementById('hidde'+g).value=document.getElementById(g).innerHTML");

pw.println("return true");
pw.println("}");
pw.println("</script>");


pw.println("</head>");
pw.println("<body>");



String garb=req.getParameter("first_name");
String xmld=req.getParameter("jo");
String fName = garb;
//InputStream ins = cntxt.getResourceAsStream(fName);
FileInputStream ins = new FileInputStream(fName);
if(ins == null){
pw.println("Not Found");
res.setStatus(res.SC_NOT_FOUND);
}
else
{
BufferedReader br = new BufferedReader((new InputStreamReader(ins)));
String word;
int count=0;

while((word= br.readLine())!= null)
{
    count+=1;
}

String mehh = req.getParameter("first_name");
String meh = req.getParameter("last_name");
//String mehhh = req.getParameter("hiddeC");

FileInputStream inss = new FileInputStream(fName);
      BufferedReader cr = new BufferedReader(new InputStreamReader(inss));
      String strLine2;
      String[][] edit = new String [count+1][columns];
      int cnt=0;


      while ((strLine2 = cr.readLine()) != null) {
        String token1[] = strLine2.split(":");

        for(int i=0;i<columns;i++){

          edit[cnt][i]=token1[i];
        }
        cnt++;}
      pw.println("<form method='POST' action='XMLServler2' name='yoho'><table hidden id='mytable' border='1'  >");
      int xx=0;
for(int z=0;z<count;z++){
    pw.print("<tr style='padding:15px'>");
    for(int zz=0;zz<columns;zz++){
        pw.print("<td style='padding:15px' oninput='myfunction(this.id)' contenteditable id='a"+xx+"'>"+edit[z][zz]+"</td>");
        String fudg="hiddea"+xx;
        pw.println("<input type='hidden' id='"+fudg+"' name='"+fudg+"' value='"+edit[z][zz]+"' /><div></div>");
        xx+=1;
    }
    pw.print("</tr>");
}
/*pw.println("<input type='hidden' id ='qwerty' name='qwerty' value='"+mehh+"'>");
pw.println("<input type='hidden' id ='asdf' name='asdf' value='0'>");
pw.println("<input type='hidden' id ='kuj' name='kuj' value='0'>");
pw.println("<input type='hidden' id ='asdf' name='asdf' value='0'>");
pw.println("<input type='hidden' id ='fil' name='fil' value='"+xmld+"'></form>");
pw.println("<script>");
pw.println("var xmld=document.getElementById('fil').value");
pw.println("var xmldoc=loadXMLDoc(xmld)");
pw.println("var x=xmldoc.getElementsByTagName('<j2ee-application>')");
pw.println("var cnt=0;");
pw.println("for (i=0;i<x.length;i++){");
pw.println("var nam=x[i].getAttribute('name')");
pw.println("if(nam=='MEjbApp' || nam=='__JWSappclients'   || nam=='__ejb_container_timer_app'){");
pw.println("cnt++;}");
pw.println("}");
pw.println("document.getElementById('kuj').value=(x.length-cnt)");
pw.println("document.getElemendById('yoho').submit()");
pw.println("</script>");
pw.println("</body></html>");*/


pw.println("flag");
int addd=Integer.parseInt(req.getParameter("kuj"));

pw.println(addd);
pw.println("flag");
for(int y=0;y<(addd/columns);y++){
    pw.print("<tr style='padding:15px'>");
    for(int zy=0;zy<columns;zy++){
        pw.print("<td style='padding:15px' oninput='myfunction(this.id)' contenteditable id='a"+xx+"'></td>");
        String fudg="hiddea"+xx;
        pw.println("<input type='hidden' id='"+fudg+"' name='"+fudg+"' value=' ' /><div></div>");
        xx+=1;
    }

    pw.print("</tr>");
}
pw.println("<script>");
pw.println("var xmldoc=loadXMLDoc('domain.xml')");
pw.println("var x=xmldoc.getElementsByTagName('<j2ee-application>')");
pw.println("var y=xmldoc.getElementsByTagName('<jdbc-resource>')");
pw.println("var z=xmldoc.getElementsByTagName('<jdbc-connection-pool>')");
pw.println("var w=xmldoc.getElementsByTagName('<server>')");

pw.println("var cnt=0;");
pw.println("for (i=0;i<x.length;i++){");
pw.println("var nam=x[i].getAttribute('name')");
pw.println("if(nam=='MEjbApp' || nam=='__JWSappclients'   || nam=='__ejb_container_timer_app'){");
pw.println("cnt++;}");
pw.println("}");
pw.println("for (i=cnt;i<x.length;i++){");
    pw.println("var name=x[i].getAttribute('name')");
    pw.println("");
    pw.println("for(h=1;h<w.length;h++;){");
    pw.println("var ty=w[h].getElementsByTagName('application-ref')");
    pw.println("for(hy=5;hy<ty.length;hy++;){");
    pw.println("var sv=ty[hy].getAttribute('ref')");
    pw.println("if (sv=name){");
    pw.println("var instance=w[h].getAttribute('name')}");
    pw.println("else{");
    pw.println("var instance=' '}");
    pw.println("}}");
    pw.println("for(k=0;k<y.length;k++){");
        pw.println("var df=y[k].getAttribute('jndi-name')");
        pw.println("var dg=y[k].getAttribute('pool-name')");
        pw.println("if('jdbc/'+name==df || 'jdo/'+name==df){    ");
            pw.println("var resource=df");
            pw.println("var pool=dg");
            pw.println("for(cxv=0;cxv<z.length;cxv++){");
                pw.println("var qw=z[cxv].getAttribute('name')");
                pw.println("if(pool==qz){");
                    pw.println("var vb=z[cxv].childNodes[0].getAttribute('value')");
                    pw.println("var arr= vb.split(':')");
                    pw.println("var ip=arr[3]");
                    pw.println("ip=ip.replace('@','')");
                    pw.println("var port=arr[4]");
                    pw.println("var sid=[5]");
                    pw.println("break;}");
                    pw.println("else{");
                    pw.println("var port=' '");
                    pw.println("var sid=' '");
                    pw.println("var ip =' '");
                    pw.println("}}");
            pw.println("break;}");
        pw.println("else{");
            pw.println("var resource=' '");
            pw.println("var pool=' '");
            pw.println("}");


    pw.println("}");
pw.println("}");
pw.println("");
pw.println("");
pw.println("");

pw.println("</script>");

pw.println("</table><p><input type='submit' value='Click to save changes' name='ede' onsubmit='myfunct()' /></p></form>");

pw.println("");
pw.println("");
pw.println("");
pw.println("");


pw.println("</body></html>");

}
}
}