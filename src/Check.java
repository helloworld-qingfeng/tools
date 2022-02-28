import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/check")
public class Check extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //设置字符集;

        String QuanLiYaoQiu = req.getParameter("check_img").replaceAll(System.lineSeparator(),"tts").replaceAll("\\r","").replaceAll(":","：");  //获取权利要请求书
        String ShuoMingShu = req.getParameter("check_img2");  //获取说明书

        Check_ing check_ing = new Check_ing();
        if(ShuoMingShu.length()>0 && QuanLiYaoQiu.length()>0){
            //1.设置会话域
            HttpSession session = req.getSession(); //获取seesion对象：
            session.setMaxInactiveInterval(1);  //设置时间;
            session.setAttribute("wait_check", ShuoMingShu);//设置 说明书的 seesion域，下一步复用;

            session.setAttribute("wait_check_QuanLiYaoQiu", QuanLiYaoQiu);//设置 权利要求书的 seesion域，下一步复用;

            //第一步检测;
            String wait_check_1 = check_ing.Check_ing_1((String) session.getAttribute("wait_check_QuanLiYaoQiu"),check_ing.get_cizu("First_Check_CiZu")).replaceAll("tts","<br><HR style=\"FILTER: alpha(opacity=100,finishopacity=0,style=3)\" width=\"80%\" color=#987cb9 SIZE=3><br>");
            session.setAttribute("wait_check_1", wait_check_1);//设置查询时间的域对象;

            resp.setStatus(302);
            resp.sendRedirect(req.getContextPath()+"/check.jsp"); //重定向
        }else{
            resp.setStatus(302);
            resp.sendRedirect(req.getContextPath()+"/check.jsp"); //重定向
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
