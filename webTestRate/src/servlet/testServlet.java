package servlet;

import dao.imp.RateDaoImp;
import entity.result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=gb2312");
        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");
        String money = request.getParameter("money");
        System.out.println(fromDate);
        System.out.println(toDate);
        System.out.println(money);
        System.out.println("Get request!");
        PrintWriter out = response.getWriter();
        if (fromDate == null || toDate == null || money == null) {
            out.write("输入不能为空！");
        }
        RateDaoImp rateDaoImp = new RateDaoImp();
        List<result> results = rateDaoImp.selets(fromDate, toDate, money);
        if (results.size() == 0) {
            out.write("没有符合要求的利润！");
        } else {
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>查询结果</TITLE></HEAD>");
            out.println("  <BODY>");
            out.print("本金为：");
            out.print(money+"\t");
            out.print("结束时金额为：");
            out.print(results.get(results.size()-1).getEndmoney()+"\t");
            out.print("利润总和为：");
            out.print(results.get(results.size()-1).getRatemoney()+"\t");
            out.print("总利率(利润/本金)为：");
            out.print(results.get(results.size()-1).getRate()+"%\t");
            out.println("共"+results.get(results.size()-1).getDays()+"天<br>");
            out.print("<table border=\"1\">");
            out.print("<tr>");
            out.print("<th>开始时间</th>");
            out.print("<th>开始金额</th>");
            out.print("<th>结束时间</th>");
            out.print("<th>结束金额</th>");
            out.print("<th>利息</th>");
            out.print("<th>利率(利息/开始金额)</th>");
            out.print("<th>天数</th>");
            out.print("</tr>");
            for (int i=0; i<results.size()-1;i++){
                out.print("<tr>");
                out.print("<td>"+results.get(i).getFromDate()+"</td>");
                out.print("<td>"+results.get(i).getBeginmoney()+"</td>");
                out.print("<td>"+results.get(i).getToDate()+"</td>");
                out.print("<td>"+results.get(i).getEndmoney()+"</td>");
                out.print("<td>"+results.get(i).getRatemoney()+"</td>");
                out.print("<td>"+results.get(i).getRate()+"%</td>");
                out.print("<td>"+results.get(i).getDays()+"</td>");
                out.print("</tr>");
            }
            out.print("</table>");
            out.println("  </BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();

            System.out.println("Send Response...");
        }
    }
}
