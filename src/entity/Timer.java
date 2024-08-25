package entity;

public class Timer {
	private int user_id;
	private int timer_id;
	private String timer_name;
	private int forwork;
	private int forpause;
	private int sessions;
	
	public Timer(int user_id, int timer_id, String timer_name, int forwork, int forpause, int sessions) {
		this.setUser_id(user_id);
		this.setTimer_id(timer_id);
		this.setTimer_name(timer_name);
		this.setForwork(forwork);
		this.setForpause(forpause);
		this.setSessions(sessions);
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTimer_id() {
		return timer_id;
	}
	public void setTimer_id(int timer_id) {
		this.timer_id = timer_id;
	}
	public String getTimer_name() {
		return timer_name;
	}
	public void setTimer_name(String timer_name) {
		this.timer_name = timer_name;
	}
	public int getForwork() {
		return forwork;
	}
	public void setForwork(int forwork) {
		this.forwork = forwork;
	}
	public int getForpause() {
		return forpause;
	}
	public void setForpause(int forpause) {
		this.forpause = forpause;
	}
	public int getSessions() {
		return sessions;
	}
	public void setSessions(int sessions) {
		this.sessions = sessions;
	}
}
