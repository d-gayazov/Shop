package models;

public class Orders {
	private int id;
	public String title;
	private int price;
	private int count;
	private String surname;	
	private String name;
	private String patronymic;
	private String phone;
	
	
	public Orders (int id, String title, int price, int count, String surname, String name, String patronymic, String phone) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.count = count;
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.phone = phone;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Пользователь " + surname + name + patronymic + " оформил заказ " + title + " в количестве " + count;
	}	
}
