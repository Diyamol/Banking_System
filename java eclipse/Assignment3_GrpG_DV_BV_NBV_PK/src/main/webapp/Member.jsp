<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Member</title>

</head>
<body>
<div id="main_div">
	<h2 style="text-align:center;">Members</h2>
	<a href="LibraryManagementHome.jsp">Home</a>
	
	<form action="MemberServlet" method="post">
		<div style="width:100%;">
			<section style="width:50%;float:left;">
				
				<table>
					<tr>
						<td>Member Id</td>
						<td>
						<input type="text" name="txt_mem_Id"/>
						</td>
					</tr>
					<tr>
						<td>Member Name</td>
						<td>
						<input type="text" name="txt_mem_name"/>
						</td>
					</tr>
					<tr>
						<td>Address</td>
						<td>
						<input type="text" name="txt_mem_address"/>
						</td>
					</tr>
					<tr>
						<td>Membership Type</td>
						<td>
						<select name="mem_type">
							<option value="select">--select--</option>
							<option value="student">Student</option>
							<option value="adult">Adult</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>Membership Date</td>
						<td>
						<input type="text" name="txt_mem_date"/>
						</td>
					</tr>
					<tr>
						<td>Membership Expiry Date</td>
						<td>
						<input type="text" name="txt_mem_exp_date"/>
						</td>
					</tr>
					<tr>
						<td>
						<input type="submit" value="Add" name="member"/>
						<input type="submit" value="Update" name="member"/>
						</td>
						<td></td>
					</tr>
				</table>
			</section>
			<section style="width:50%;float:right;">
				<label>Enter Member to Delete</label>
				<input type="text" name="txt_mem_Id_del"/><br/>
				<input type="submit" value="Delete" name="member"/>
			</section>
		</div>		
	</form>
</div>
</body>
</html>