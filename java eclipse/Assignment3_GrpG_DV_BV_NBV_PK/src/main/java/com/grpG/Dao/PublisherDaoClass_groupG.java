package com.grpG.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.grpG.Model.PublisherClass_GroupG;

/**
 * 
 * @author diyaa  methods to add publisher, update
 *         publisher, delete publisher
 */

public class PublisherDaoClass_groupG {

	public int addPublisher(PublisherClass_GroupG pb) throws ClassNotFoundException {
		/**
		 * insert publisher details to database
		 */
		int result = 0;
		String ADD_USER_SQL = "INSERT INTO publisher (pub_id,address,name) values (?,?,?);";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(ADD_USER_SQL);
			ps.setInt(1, pb.getPub_id());
			ps.setString(2, pb.getAddress());
			ps.setString(3, pb.getName());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	public int updatePublisher(PublisherClass_GroupG pb) throws ClassNotFoundException {
		/**
		 * update publisher details to database
		 */
		int result = 0;
		String UPDATE_PUBLISHER_SQL = "UPDATE publisher SET address=?,name=? where pub_id=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(UPDATE_PUBLISHER_SQL);
			ps.setString(1, pb.getAddress());
			ps.setString(2, pb.getName());
			ps.setInt(3, pb.getPub_id());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	public int deletePublisher(PublisherClass_GroupG pb) throws ClassNotFoundException {
		/**
		 * delete publisher details from databse
		 */
		int result = 0;
		String DELETE_PUBLISHER_SQL = "DELETE from publisher where pub_id=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_schema", "root",
					"Diya@mysql1");
			PreparedStatement ps = connection.prepareStatement(DELETE_PUBLISHER_SQL);
			ps.setInt(1, pb.getPub_id());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	/**
	 * 
	 * @param ex exceptionfunction for printing sql state , error code and message
	 * 
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
}
