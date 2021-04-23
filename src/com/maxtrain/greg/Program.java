package com.maxtrain.greg;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/salesdb", "root", "Train@MAX");
		
		PreparedStatement stmt = conn.prepareStatement("SELECT * from customers where Id = ?;");
		stmt.setInt(1, 1);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			var id = rs.getInt("Id");
			var name = rs.getString("Name");
			System.out.println(id + " | " + name);
		}
	}

}
