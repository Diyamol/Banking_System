<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
<style>
</style>
</head>
<body>
	<div id="main_div">
		<h2 style="text-align: center">Books</h2>
		<a href="LibraryManagementHome.jsp">Home</a>
		<form action="BookServlet" method="post">
			<div style="width: 100%;">
				<section style="width: 50%; float: left;">
					<table>
						<tr>
							<td>Book Id</td>
							<td><input type="text" name="txt_book_id" /></td>
						</tr>
						<tr>
							<td>Book Title</td>
							<td><input type="text" name="txt_book_title" /></td>
						</tr>
						<tr>
							<td>Price</td>
							<td><input type="number" name="txt_price" /></td>
						</tr>
						<tr>
							<td>Availability</td>
							<td><input type="radio" name="availability" value="yes"><label
								for="yes">Yes</label> &nbsp&nbsp <input type="radio" id="css"
								name="availability" value="no"> <label for="no">No</label>
							</td>
						</tr>
						<tr>
							<td>Author</td>
							<td><input type="text" name="txt_author" /></td>
						</tr>

						<tr>
							<td><input type="submit" value="Add" name="book" /> <input
								type="submit" value="Update" name="book" /></td>
							<td></td>
						</tr>
					</table>
				</section>
				<section style="width: 50%; float: right;">
					<label>Select A Book to Delete</label> <input type="text"
						name="txt_book_id_del" /> <input type="submit" name="book"
						value="Delete" />

				</section>
			</div>
			<div style="width: 50%;">
				<h4>Issue Book</h4>
				<table>
					<tr>
						<td>Book Id</td>
						<td><input type="text" name="txt_issue_book_id" /></td>
					</tr>
					<tr>
						<td>Member Id</td>
						<td><input type="text" name="txt_issue_memb_id" /></td>
					</tr>
					<tr>
						<td>Issued by</td>
						<td><input type="text" name="txt_issued_by" /></td>
					</tr>
					<tr>
						<td>Due Date</td>
						<td><input type="text" name="txt_due_date" /></td>
					</tr>
					<tr>
						<td>Return Date</td>
						<td><input type="text" name="txt_return_date" /></td>
					</tr>
					<tr>
						<td><input type="submit" name="book" value="Issue" /></td>
						<td></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>