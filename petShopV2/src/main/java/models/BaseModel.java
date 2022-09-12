package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseModel {
	static ArrayList<Good>goods = new ArrayList<Good>();
	static ArrayList<Cart> cart = new ArrayList<Cart>();
	static ArrayList<Orders> orders = new ArrayList<Orders>();
	static ArrayList<Shop> shop = new ArrayList<Shop>();
	static ArrayList<Good>found = new ArrayList<Good>();
	
	static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(Config.DRIVER);
		var url = "jdbc:mysql://localhost/" + Config.DB;
		return DriverManager.getConnection(url,Config.LOGIN,Config.PASS);
	}
	
	public static ArrayList<Good> getGoods(int catId) throws ClassNotFoundException, SQLException{
		var connect = getConnection();
		var sql = "select * from goods where catalog_id="+catId;
		var ps = connect.prepareStatement(sql);
		var rs = ps.executeQuery();
		goods.clear();
		while(rs.next()) {
			var id = rs.getInt("id");
			var title = rs.getString("title");
			var info = rs.getString("info");
			var price = rs.getInt("price");			
			var photo = rs.getString("photo");
			goods.add(new Good(id, title, info, price, photo));
		}
		return goods;
	}
	
	
//	public static Good getGood(int id) {
//		for(Good good : goods) {
//			if(good.getId() == id) {
//				return good;
//			}
//		}
//		return null;
//	}
	
	
	public static Good getGood(int id) {
		if(goods != null) {
			for(Good good : goods) {
			if(good.getId() == id) {
				return good;
			}
		}
		}
		if(found != null) {
			for(Good good : found) {
			if(good.getId() == id) {
				return good;
			}
		}
		}
		return null;
	}
	
	
	public static ArrayList<Cart> getCart() throws ClassNotFoundException, SQLException{
		var connect = getConnection();
		var sql = "SELECT title,price,good_id,user_id,count FROM goods INNER JOIN cart ON cart.good_id = goods.id";
		var ps = connect.prepareStatement(sql);
		var rs = ps.executeQuery();
		cart.clear();
		while(rs.next()) {
			var id = rs.getInt("good_id");
			var title = rs.getString("title");
			var price = rs.getInt("price");
			var count = rs.getInt("count");
			var userId = rs.getInt("user_id");
			cart.add(new Cart(id,title,price,userId,count));
		}
		return cart;
	}
	
	public static boolean addGood(int id) throws ClassNotFoundException, SQLException{
		var connection = getConnection();
		var sql = "select * from cart where good_id="+id;
		var ps = connection.prepareStatement(sql);
		var rs = ps.executeQuery();
		if(rs.next()) {
			var update = connection.prepareStatement("update cart set count=count+1 where good_id="+id);
			if(update.executeUpdate() > 0) {
				return true;
			}
		}else {
			var insertSql =  connection.prepareStatement("insert into cart(good_id,count) values("+id+",1)");			
			if(insertSql.executeUpdate() > 0) {
				return true;
			}
		}
		return false;
	}

	public static void delCart() throws ClassNotFoundException, SQLException {
		var connection = getConnection();
		var del = "delete from cart";
		var ps = connection.prepareStatement(del);
		ps.executeUpdate(del);
	}

	public static void delFromCart(int id) throws ClassNotFoundException, SQLException {
		if (id > 0) {
		var connection = getConnection();
		var del = "delete from cart where good_id = " + id;
		var ps = connection.prepareStatement(del);
		ps.executeUpdate(del);
		}
	}
	
	public static ArrayList<Orders> getOrders() throws ClassNotFoundException, SQLException{
		var connect = getConnection();
		var sql = "select * from testorder where order_status=0";
		var ps = connect.prepareStatement(sql);
		var rs = ps.executeQuery();
		orders.clear();
		while(rs.next()) {
			var id = rs.getInt("id");
			var title = rs.getString("title");
			var price = rs.getInt("price");
			var count = rs.getInt("count");
			var surname = rs.getString("surname");
			var name = rs.getString("name");
			var patronymic = rs.getString("patronymic");
			var phone = rs.getString("phone");
			orders.add(new Orders(id,title,price,count,surname,name,patronymic,phone));
		}
		return orders;
	}
	
	public static ArrayList<Shop> getShopInfo() throws ClassNotFoundException, SQLException{
		var connect = getConnection();
		var sql = "select * from shopinfo";
		var ps = connect.prepareStatement(sql);
		var rs = ps.executeQuery();
		shop.clear();
		while(rs.next()) {
			var id = rs.getInt("id");
			var title = rs.getString("title");
			var contacts = rs.getString("contacts");
			var delivery = rs.getString("delivery");
			var returnGood = rs.getString("returnGood");
			shop.add(new Shop(id,title,contacts,delivery,returnGood));
		}
		return shop;
	}

	public static boolean checkClient(String login, String pass) throws ClassNotFoundException, SQLException {
		var connect = getConnection();
		var sql = "select * from users where login='" + login + "' AND pass='" + pass + "'";
		var ps = connect.prepareStatement(sql);
		var rs = ps.executeQuery();
		if(rs.next()) {			
			var insertSql =  connect.prepareStatement("insert into testorder(good_id,title,price,count,surname,name,patronymic,phone) select c.good_id, g.title, g.price, c.count, u.surname, u.name, u.patronymic, u.phoneNumber from cart c inner join goods g on c.good_id=g.id inner join users u where login='" + login + "'");
			insertSql.executeUpdate();
			return true;
		}
		return false;
	}

	public static void addClient(String login, String passwrd, String surname, String name, String patr, String phNum) throws ClassNotFoundException, SQLException {
		var connect = getConnection();
		var insertSql =  connect.prepareStatement("insert into users (login,pass,surname,name,patronymic,phoneNumber) values ('" + login + "','" + passwrd + "','" + surname + "','" + name + "','" + patr + "','" + phNum + "')");
		insertSql.executeUpdate();
	}

	public static boolean checkAdmin(String loginAdm, String passAdm) throws ClassNotFoundException, SQLException {
		var connect = getConnection();
		var sql = "select * from users where login='" + loginAdm + "' AND pass='" + passAdm + "' AND role_id=1";
		var ps = connect.prepareStatement(sql);
		var rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}

	public static void adminDone(int id) throws ClassNotFoundException, SQLException {
		var connection = getConnection();
		var updateSql = "update testorder set order_status=1 where id="+id;		
		var ps = connection.prepareStatement(updateSql);
		ps.executeUpdate();
	}

	public static ArrayList<Good> getFound(String field) throws ClassNotFoundException, SQLException{
		var connect = getConnection();
		var sql = "SELECT * FROM `goods` WHERE `title` LIKE '%" + field + "%'";
		var ps = connect.prepareStatement(sql);
		var rs = ps.executeQuery();
		found.clear();
		while(rs.next()) {
			var id = rs.getInt("id");
			var title = rs.getString("title");
			var info = rs.getString("info");
			var price = rs.getInt("price");			
			var photo = rs.getString("photo");
			found.add(new Good(id, title, info, price, photo));
		}
		return found;
	}
}
