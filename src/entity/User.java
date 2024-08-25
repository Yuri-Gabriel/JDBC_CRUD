package entity;

public class User {
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_password;
	private Timer[] timers;
	
	public User(int user_id, String user_name, String user_email, String user_password, Timer[] timers) {
		this.setUser_id(user_id);
		this.setUser_name(user_name);
		this.setUser_email(user_email);
		this.setUser_password(user_password);
		this.setTimers(timers);
	}
	
	public User(String user_name, String user_email, String user_password) {
		this.setUser_name(user_name);
		this.setUser_email(user_email);
		this.setUser_password(user_password);
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Timer[] getTimers() {
		return timers;
	}

	public void setTimers(Timer[] timers) {
		this.timers = timers;
	}
}
