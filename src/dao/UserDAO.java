package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utility.ConnectionManager;

public class UserDAO {
	public int signUp(User user) throws Exception {
		String INSERT_USERS1_SQL = "INSERT INTO USERS1(email, password)VALUES(?,?)";
		int result = 0;
		try
		{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS1_SQL);
			preparedStatement.setString(1,user.getEmail());
			preparedStatement.setString(2,user.getPassword());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	public boolean loginUser(User user) throws Exception {
		boolean status = false;
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				if(email.equals(user.getEmail()) && password.equals(user.getPassword()) ){
					System.out.println("-->login successfull");
					status =true;
					return status;
				}
				else {
					System.out.println("<--please enter valid credentilas!");
				}
			}
			System.out.println(status);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return status;
	}

}
