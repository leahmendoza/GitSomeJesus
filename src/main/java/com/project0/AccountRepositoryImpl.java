package com.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project0.model.Account;
import com.project0.util.ConnectionClosers;
import com.project0.util.ConnectionFactory;

public class AccountRepositoryImpl implements AccountRepository {

	public List<Account> getAllAccounts() {

		List<Account> accounts = new ArrayList<Account>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from account"; // Read All Query

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL); // Returns the ResultSet

			while (set.next()) { // Iterating through to read data
				accounts.add(new Account(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		return accounts;
	}

	public void insertAccount(Account a) {
		// Making connection
		Connection conn = null;
		// Statement that is executed to insert an account
		PreparedStatement stmt = null;

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.prepareStatement("insert into account values(default, ?, ?, ?, ?, ?)"); // Insert Query
			stmt.setString(1, a.getName());
			stmt.setString(2, a.getUsername());
			stmt.setString(3, a.getPassword());
			stmt.setString(4, a.getEmail());
			stmt.setString(5, a.getAddress());
			stmt.execute(); // To execute:

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); //closing connection
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteAccount(Account a) {
		// Making connection
		Connection conn = null;
		// Statement that is executed to delete an account
		PreparedStatement stmt = null;

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.prepareStatement("delete from account where user_id = ?"); // Delete Query
			stmt.setInt(1, a.getUser_id());
			stmt.execute(); // To execute:

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); //closing connection
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void updateAccount(Account a) {
		// Making connection
		Connection conn = null;
		// Statement that is executed to update an account
		PreparedStatement stmt = null;

		try {
			conn = ConnectionFactory.getConnection();

			String sql = "UPDATE account SET name_ = ?, username = ?, password = ?, email = ?, address = ? WHERE user_id = ?"; //Update Query

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //making user_id int available for retrieval 
			
			stmt.setString(1, a.getName());
			stmt.setString(2, a.getUsername());
			stmt.setString(3, a.getPassword());
			stmt.setString(4, a.getEmail());
			stmt.setString(5, a.getAddress());
			stmt.setInt(6, a.getUser_id());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}