<%@ page language="java" contentType="text/html; charset=BIG5"%>
<%
	out.print("<p>請求方法: "+request.getMethod()+"</p>");
	out.print("<p>現在時間:"+new java.util.Date()+"</p>");
%>
