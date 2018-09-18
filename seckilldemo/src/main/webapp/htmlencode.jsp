<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Html Entity Encode</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body> 
    Encoding <br>
  <form action="login" method="POST">
    <table>
    	<tr>
			<td><input name="source" type="text" id="source"></td> 
			<td><input name="" type="submit" title="zh" text="zh"></td>	
    	</tr>
    </table>
 </form>
 	<%
    String safe = (String)session.getAttribute("safe");
    %>
    safe:<%= safe%>
  </body>
</html>
