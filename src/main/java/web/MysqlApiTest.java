package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by blacktea on 2017/4/10.
 */
public class MysqlApiTest extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        // 设置中文输入输出
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html,charset=UTF=8");
        // 获取输出流对象
        PrintWriter out = response.getWriter();
        // 获取表单提交数据
        String name = request.getParameter("name");
        Double salary = Double.valueOf(request.getParameter("salary"));
        int age = Integer.valueOf(request.getParameter("age"));
        // 将数据插入到数据库yumi表
        Connection conn = null;
        PreparedStatement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //动态加载mysql驱动
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webserverDemo?user=root&password=19880622");
            stat = conn.prepareStatement("INSERT INTO userInfo VALUES" + "(NULL ,?,?,?)");
            stat.setString(1,name);
            stat.setDouble(2,salary);
            stat.setInt(3,age);
            stat.executeUpdate();
            out.println("添加成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            out.print("系统繁殖，稍后重置");
        }finally {
            if (stat != null) {
                try {
                    stat.close();
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            else {
                try {
                    conn.close();
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
