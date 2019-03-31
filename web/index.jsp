<%--
  Created by IntelliJ IDEA.
  User: liujinjin
  Date: 2019/3/28
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>查询利率</title>
    <script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
    <script language="javascript" type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
</head>
<body>
<h1>查询利率</h1>
<hr/>
<form action="Servlet" method="post">
    开始日期：<input class="Wdate" name="fromDate"onFocus="WdatePicker({lang:'zh-cn'})" >
    结束日期：<input class="Wdate" name="toDate" onClick="WdatePicker({lang:'zh-cn'})" ></br>

    <%--<input type="text" name="fromDate" placeholder="yyyy-mm-dd样式"></br>--%>
    <%--<input type="text" name="toDate" placeholder="yyyy-mm-dd样式"></br>--%>
    起始金额：<input type="text" name="money"></br></br>
    <input type="submit" value="提交">
</form>

</body>
</html>
