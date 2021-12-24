package com.grpG.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.grpG.Model.MemberClass_GroupG;
/**
 * @author diyaa bhavya nithin pardeep
 */
public class MemberDaoClass_groupG {
	
	public int addMember(MemberClass_GroupG mb) throws ClassNotFoundException {
		/**
		 * insert member to database
		 */
		String INSERT_MEMBER_SQL = "INSERT INTO member (memb_id,name,address,memb_type,memb_date,expiry_date)"
				+ "values (?,?,?,?,?,?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(INSERT_MEMBER_SQL);
			ps.setInt(1, mb.getMemb_id());
			ps.setString(2, mb.getName());
			ps.setString(3, mb.getAddress());
			ps.setString(4, mb.getMemb_type());
			ps.setDate(5, mb.getMemb_date());
			ps.setDate(6, mb.getExpiry_date());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	public int updateMember(MemberClass_GroupG mb) throws ClassNotFoundException {
		/**
		 * update member to database
		 */
		String UPDATE_MEMBER_SQL = "UPDATE member SET name=?,address=?,memb_type=?,memb_date=?,expiry_date=? where memb_id=?;";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root","Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(UPDATE_MEMBER_SQL);
			ps.setString(1, mb.getName());
			ps.setString(2, mb.getAddress());
			ps.setString(3, mb.getMemb_type());
			ps.setDate(4, mb.getMemb_date());
			ps.setDate(5, mb.getExpiry_date());
			ps.setInt(6, mb.getMemb_id());
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

	public int deleteMember(MemberClass_GroupG mb) throws ClassNotFoundException {
		/**
		 * delete member from database
		 */
		int result = 0;
		String DELETE_MEMBER_SQL = "DELETE from member where memb_id=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(DELETE_MEMBER_SQL);
			ps.setInt(1, mb.getMemb_id());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;

	}
}
