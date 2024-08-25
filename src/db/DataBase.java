package db;

import java.sql.Statement;

import entity.Timer;
import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
	
	private String url = "jdbc:postgresql://localhost/pomoappdb";
	private String user = "postgres";
	private String password = "12345678";
	
	private Statement statement;
	private Connection connection;
	private ResultSet queryResult;
	
	public DataBase() {
		try {
			Class.forName("org.postgresql.Driver");
			this.setQueryResult(null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Crud startConnerction() {
		try {
			this.setConnection(DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword()));
			this.setStatement(this.connection.createStatement());
			Crud crud = new Crud(this.getStatement());
			return crud;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Statement getStatement() {
		return statement;
	}


	public void setStatement(Statement statement) {
		this.statement = statement;
	}


	public Connection getConnection() {
		return connection;
	}


	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ResultSet getQueryResult() {
		if (this.queryResult == null) {
			throw new Error("Nenhuma query foi executada");
		}
		return queryResult;
	}

	public void setQueryResult(ResultSet queryResult) {
		this.queryResult = queryResult;
	}
}
