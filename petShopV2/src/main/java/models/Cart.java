package models;

public class Cart {
	private int id;
	private String title;
	private int price;
	private int userId;
	private int count;
	
	
	
	public Cart(int id, String title, int price, int userId, int count) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.userId = userId;
		this.count = count;
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



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "Товар " + title + " стоит " + price;
	}
	
	
}
