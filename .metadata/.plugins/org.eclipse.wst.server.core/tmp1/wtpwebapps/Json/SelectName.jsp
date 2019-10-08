<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String connUrl="jdbc:sqlserver://localhost:1433;databaseName=servdb";
	Connection conn = DriverManager.getConnection(connUrl,"sa","password");
	
	String qryStmt="select ename from employee";
	PreparedStatement stmt=conn.prepareStatement(qryStmt);
	ResultSet rs=stmt.executeQuery();
	
	String str="<select name='ename'>";
	String ename;
	while(rs.next()){
		ename =rs.getString("ename");
		str +="<option value='"+ename+"'>"+ename;
	}
	str +="</select>";
	out.print(str);
	conn.close();
%>