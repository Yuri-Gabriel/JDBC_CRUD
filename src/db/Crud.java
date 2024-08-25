package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Timer;
import entity.User;

public class Crud {
	private Statement statement;
	private ResultSet queryResult;
	
	public Crud(Statement statement) {
		this.setStatement(statement);
	}
	
	private void executeQuery(String query) {
		try {
			this.setQueryResult(this.getStatement().executeQuery(query));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User[] getAlUsers() {
		try {
			this.executeQuery("SELECT * FROM users INNER JOIN timer ON timer.user_id = users.user_id");
			int cont = 0;
			while(this.getQueryResult().next()) {
				cont++;
			}
			User[] users = new User[cont];
			
			this.executeQuery("SELECT * FROM users INNER JOIN timer ON timer.user_id = users.user_id");
			cont = 0;
			while(this.getQueryResult().next()) {
				int user_id = Integer.parseInt(this.getQueryResult().getString("user_id"));
				String name = this.getQueryResult().getString("username");
				String email = this.getQueryResult().getString("useremails");
				String password = this.getQueryResult().getString("userpassword");
				String timer_name = this.getQueryResult().getString("timer_name");
				
				int timer_id = Integer.parseInt(this.getQueryResult().getString("timer_id"));
				int forwork = Integer.parseInt(this.getQueryResult().getString("forwork"));
				int forpause = Integer.parseInt(this.getQueryResult().getString("forpause"));
				int sessions = Integer.parseInt(this.getQueryResult().getString("sessions"));
				Timer[] timers = {
						new Timer(user_id, timer_id, timer_name, forwork, forpause, sessions)
				};
				users[cont] = new User(user_id, name, email, password, timers);
				cont++;
			}
			
			return users;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getOneUser(int user_id) {
		try {
			this.executeQuery("SELECT * FROM users INNER JOIN timer ON timer.user_id = users.user_id");
			while(this.getQueryResult().next()) {
				if(Integer.parseInt(this.getQueryResult().getString("user_id")) == user_id) {
						
					String name = this.getQueryResult().getString("username");
					String email = this.getQueryResult().getString("useremails");
					String password = this.getQueryResult().getString("userpassword");
					String timer_name = this.getQueryResult().getString("timer_name");
					
					int timer_id = Integer.parseInt(this.getQueryResult().getString("timer_id"));
					int forwork = Integer.parseInt(this.getQueryResult().getString("forwork"));
					int forpause = Integer.parseInt(this.getQueryResult().getString("forpause"));
					int sessions = Integer.parseInt(this.getQueryResult().getString("sessions"));
					Timer[] timers = {
							new Timer(user_id, timer_id, timer_name, forwork, forpause, sessions)
					};
					return new User(user_id, name, email, password, timers);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertUser(User user) {
		String query = String.format("INSERT INTO users VALUES ('%s', '%s', '%s')", user.getUser_name(), user.getUser_email(), user.getUser_password());
		
		this.executeQuery(query);
		System.out.print(query);
	}
	
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public ResultSet getQueryResult() {
		return queryResult;
	}
	public void setQueryResult(ResultSet queryResult) {
		this.queryResult = queryResult;
	}
}
