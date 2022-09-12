package models;

public class User {
	private int user_id;
	public String login;
	public String pass;
	private String surname;	
	private String name;
	private String patronymic;
	private String phoneNumber;
	
	
	public User(int user_id, String login, String pass, String surname, String name, String patronymic, String phoneNumber) {
		this.user_id = user_id;
		this.login = login;
		this.pass = pass;
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.phoneNumber = phoneNumber;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	@Override
	public String toString() {
		return "Пользователь " + surname + name + patronymic + " имеет логин " + login + " и пароль " + pass;
	}
	
	
}
