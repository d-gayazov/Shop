package models;

public class Shop {
	private int id;
	private String title;
	private String contacts;
	private String delivery;
	private String returnGood;
	
	
	
	public Shop(int id, String title, String contacts, String delivery, String returnGood) {
		this.id = id;
		this.title = title;
		this.contacts = contacts;
		this.delivery = delivery;
		this.returnGood = returnGood;
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

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getReturnGood() {
		return returnGood;
	}

	public void setReturnGood(String returnGood) {
		this.returnGood = returnGood;
	}


	@Override
	public String toString() {
		return "О магазине: " + title + " . Контакты: " + contacts;
	}
	
	
}
