package web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by blacktea on 2017/4/9.
 */
public class GetApiTest extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("blacktea hello world");
        PrintWriter out = resp.getWriter();
        // get name
        String name = req.getParameter("name");
        out.println("<h1>Hello," + name + "</h1>");
        // get contact
        String[] infos = req.getParameterValues("info");
        if (infos != null) {
            out.println("<h1>Favor fruit:</h1>");
            for (String info : infos) {
                out.println("<h1>" + info + "</h1>");
            }
        }
        out.close();
    }
}

