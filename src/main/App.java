package main;

import db.Crud;
import db.DataBase;
import entity.User;

public class App {

	public static void main(String[] args) {
		DataBase database = new DataBase();
		Crud crud = database.startConnerction();
		crud.insertUser(new User("joao", "joao1234@gmail.com", "joao1234"));
		/*
		for(User user : users) {
			System.out.println(user.getUser_id());
			System.out.println(user.getUser_name());
			System.out.println(user.getUser_email());
			System.out.println(user.getUser_password());
			System.out.println(user.getTimers()[0].getTimer_id());
			System.out.println(user.getTimers()[0].getTimer_name());
			System.out.println(user.getTimers()[0].getForwork());
			System.out.println(user.getTimers()[0].getForpause());
			System.out.println(user.getTimers()[0].getSessions());
			System.out.println();
		}*/
		

	}

}
