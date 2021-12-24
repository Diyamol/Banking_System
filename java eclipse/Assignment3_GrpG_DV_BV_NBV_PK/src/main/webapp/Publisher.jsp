<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Publisher</title>
</head>
<body>
<div id="main_div" >
	<h2 style="text-align:center;">Publisher</h2>	
	<a href="LibraryManagementHome.jsp">Home</a>
	<form action="PublisherServlet" method="post">
	<div style="width:100%;">
		<section style="width:50%;float:left;">		
		<table>
			<tr>
				<td>Publisher Id</td>
				<td>
				<input type="text" name="txt_pub_id"/>
				</td>
			</tr>
			<tr>
				<td>Publisher Name</td>
				<td>
				<input type="text" name="txt_pub_name"/>
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
				<input type="text" name="txt_pub_address"/>
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="Add" name="publisher"/>
				<input type="submit" value="Update" name="publisher"/>
				</td>
				<td></td>
			</tr>
		</table>
		</section>
		<section style="width:50%;float:right">
			<label>Enter Publisher to Delete</label>
			<input type="text" name="txt_pub_id_del"/>
			<input type="submit" value="Delete" name="publisher"/>
		</section>
	</div>	
</form>
</div>
</body>
</html>