package web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by blacktea on 2017/4/9.
 */
public class PostApiTest extends HttpServlet {
    protected void  service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // right to read chinese
        req.setCharacterEncoding("utf-8");
        // right to output chinese
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // get name value
        String name = req.getParameter("name");
        out.println("<h1>Hello,"+name+"</h1>");
        // get info value
        String[] infos = req.getParameterValues("info");
        if (infos != null) {
            out.print("<h1>info :</h1>");
            for (String contact :infos) {
                out.print("<h1>"+contact+"</h1>");
            }
        }
    }
}
