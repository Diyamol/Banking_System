<%@ page import ="java.util.List"%>
<%@page import="com.grpG.Model.BorrowDetailsClass_GroupG"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Borrow Details</title>
</head>
<body>
	<h3>Books Borrow Details</h3>
	<form action="BookServlet" method="post">
	<table>
		<tr>
			<th>Book Id</th>
			<th>Member Id</th>
			<th>Issued By</th>
			<th>Due Date</th>
			<th>Return Date</th>
		</tr>
		<%
			List<BorrowDetailsClass_GroupG> borrow=(List<BorrowDetailsClass_GroupG>)session.getAttribute("allBooksissued");
			for(BorrowDetailsClass_GroupG borrowedbooks:borrow){
		%>
		<tr>
			<td><%=borrowedbooks.getBookId() %></td>
			<td><%=borrowedbooks.getMemb_Id() %></td>
			<td><%=borrowedbooks.getIssue() %></td>
			<td><%=borrowedbooks.getDue_date() %></td>
			<td><%=borrowedbooks.getReturn_date() %></td>
		</tr>
		<% 
			}
		%>
	</table>
	</form>
</body>
</html>