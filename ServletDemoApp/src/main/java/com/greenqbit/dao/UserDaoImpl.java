package com.greenqbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.greenqbit.db.DBConnection;
import com.greenqbit.model.User;

public class UserDaoImpl extends DBConnection implements UserDao {

	@Override
	public void registration(User user) throws Exception {
		
		Connection conn = getDBConnection();

		String sql = "INSERT INTO `user` (`firstname`, `lastname`, `email`, `password`, `addressline1`, `addressline2`, `city`, `state`, `zip`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, user.getFirstName());
		stat.setString(2, user.getLastName());
		stat.setString(3, user.getEmail());
		stat.setString(4, user.getPassword());
		stat.setString(5, user.getAddressline1());
		stat.setString(6, user.getAddressline2());
		stat.setString(7, user.getCity());
		stat.setString(8, user.getState());
		stat.setString(9, user.getZip());
	

		stat.executeUpdate(); // execute query

		conn.close();
		
	}
	
	@Override
	public boolean validateUser(String email, String password) {
		try {

			Connection conn = getDBConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM user where email = '" + email + "' and password = '" + password + "'");
			boolean isValid = rs.next();
			conn.close();
			return isValid;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
