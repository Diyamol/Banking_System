package com.grpG.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grpG.Model.BookClass_GroupG;
import com.grpG.Model.BorrowDetailsClass_GroupG;

/**
 * @author diyaa bhavya nithin pardeep
 */

public class BookDaoClass_groupG {
	public int addBook(BookClass_GroupG bk) throws ClassNotFoundException {
		/**
		 * add book
		 */
		String INSERT_BOOK_SQL = "INSERT INTO book (bookId,title, price,Available,Author)" + "values (?,?,?,?,?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(INSERT_BOOK_SQL);
			ps.setInt(1, bk.getBookId());
			ps.setString(2, bk.getTitle());
			ps.setDouble(3, bk.getPrice());
			ps.setString(4, bk.getAvailable());
			ps.setString(5, bk.getAuthor());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	public int updateBook(BookClass_GroupG bk) throws ClassNotFoundException {
		/**
		 * update book
		 */
		String UPDATE_BOOK_SQL = "UPDATE book SET title=?, price=?,Available=?,Author=? where bookId=?;";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(UPDATE_BOOK_SQL);
			ps.setString(1, bk.getTitle());
			ps.setDouble(2, bk.getPrice());
			ps.setString(3, bk.getAvailable());
			ps.setString(4, bk.getAuthor());
			ps.setInt(5, bk.getBookId());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	public int issueBook(BorrowDetailsClass_GroupG bd) throws ClassNotFoundException {
		/**
		 * insert issued book details
		 */
		String INSERT_BORROW_SQL = "INSERT INTO borrowdetails (bookId,memb_id,issue,due_date,return_date)"
				+ "values (?,?,?,?,?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(INSERT_BORROW_SQL);

			ps.setInt(1, bd.getBookId());
			ps.setInt(2, bd.getMemb_Id());
			ps.setString(3, bd.getIssue());
			ps.setDate(4, bd.getDue_date());
			ps.setDate(5, bd.getReturn_date());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	/**
	 * exceptionfunction for printing sql state , error code and message
	 */
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + ((SQLException) e).getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause" + t);
					t = t.getCause();
				}
			}
		}
	}

	public int deleteBook(BookClass_GroupG bk) throws ClassNotFoundException {
		/**
		 * delete book
		 */
		int result = 0;
		String DELETE_BOOK_SQL = "DELETE from book where bookId=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(DELETE_BOOK_SQL);
			ps.setInt(1, bk.getBookId());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;

	}

	public List<BorrowDetailsClass_GroupG> selectAllIssuedBooks() throws ClassNotFoundException {
		/**
		 * view issued books
		 */
		String SELECT_BOOK_BORROWED_SQL = "SELECT * from borrowdetails;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		List<BorrowDetailsClass_GroupG> borrowedBooks = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(SELECT_BOOK_BORROWED_SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int bookid = rs.getInt("bookId");
				int membid = rs.getInt("memb_id");
				String issue = rs.getString("issue");
				Date dueDate = rs.getDate("due_date");
				Date returndate = rs.getDate("return_date");

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return borrowedBooks;
	}
}
