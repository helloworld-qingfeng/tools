import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/check_ing")
public class Check_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8"); //设置字符集;
//        //1.设置会话域
//        HttpSession session = req.getSession(); //获取seesion对象：
//        String Reference_markss = req.getParameter("check_img");  //请粘贴附图标记词组
//        System.out.println(Reference_markss);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //设置字符集;
        //1.设置会话域
        HttpSession session = req.getSession(); //获取seesion对象：
        String Reference_markss = req.getParameter("ExPws");  //请粘贴附图标记词组
        Check_ing check_ing = new Check_ing();


        String Check_ing_2 = check_ing.Check_ing_2(Reference_markss).replaceAll("\\r\\n","<br><HR style=\"FILTER: alpha(opacity=100,finishopacity=0,style=3)\" width=\"80%\" color=#987cb9 SIZE=3><br>");
        session.setMaxInactiveInterval(1);  //设置时间;
        session.setAttribute("wait_check_2", Check_ing_2);//设置查询时间的域对象;
        resp.setStatus(302);
        resp.sendRedirect(req.getContextPath()+"check.jsp"); //重定向
    }
}
