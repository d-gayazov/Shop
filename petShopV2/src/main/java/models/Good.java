package models;

public class Good {
	private int id;
	private String title;	
	private String info;
	private int price;
	private String photo;
	public Good(int id, String title, String info, int price, String photo) {
		this.id = id;
		this.title = title;
		this.info = info;
		this.price = price;		
		this.photo = photo;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Товар " + title + " стоит " + price;
	}	
	
}
