import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/check")
public class Check extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //设置字符集;
        String Reference_markss = req.getParameter("check_img");  //请粘贴附图标记词组
        Check_ing check_ing = new Check_ing();

        if(Reference_markss.length()>0){
            //1.设置会话域
            HttpSession session = req.getSession(); //获取seesion对象：
            session.setMaxInactiveInterval(1);  //设置时间;
            session.setAttribute("wait_check", Reference_markss);//设置查询时间的域对象;

            //第一步检测;
            String wait_check_1 = check_ing.Check_ing_1((String) session.getAttribute("wait_check")).replaceAll("\\r\\n","<br><HR style=\"FILTER: alpha(opacity=100,finishopacity=0,style=3)\" width=\"80%\" color=#987cb9 SIZE=3><br>");
            session.setAttribute("wait_check_1", wait_check_1);//设置查询时间的域对象;

            resp.setStatus(302);
            resp.sendRedirect(req.getContextPath()+"check.jsp"); //重定向
        }else{
            resp.setStatus(302);
            resp.sendRedirect(req.getContextPath()+"check.jsp"); //重定向
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
