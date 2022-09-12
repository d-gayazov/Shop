package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BaseModel;


@WebServlet("/Catalog")
public class Catalog extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		var action = request.getParameter("action");

		if(action == null) {
			try {
				request.setAttribute("goods", BaseModel.getGoods(6));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("WEB-INF/views/main.jsp").forward(request, response);
		} else {
			switch (action) {

			case "card":
					request.setAttribute("good", BaseModel.getGood(Integer.parseInt(request.getParameter("id"))));
					request.getRequestDispatcher("WEB-INF/views/goodInfo.jsp").forward(request, response);
				break;
			case "good":
				try {
					request.setAttribute("goods", BaseModel.getGoods(Integer.parseInt(request.getParameter("id"))));
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/good.jsp").forward(request, response);
				break;
			case "aboutUs":
				try {
					request.setAttribute("shop", BaseModel.getShopInfo());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/aboutUs.jsp").forward(request, response);
			break;
			case "ourContacts":
				try {
					request.setAttribute("shop", BaseModel.getShopInfo());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/contacts.jsp").forward(request, response);
			break;
			case "delivery":
				try {
					request.setAttribute("shop", BaseModel.getShopInfo());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/delivery.jsp").forward(request, response);
			break;
			case "returnGood":
				try {
					request.setAttribute("shop", BaseModel.getShopInfo());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/returnGood.jsp").forward(request, response);
			break;
			case "cart":
				try {
					request.setAttribute("cart", BaseModel.getCart());
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request, response);
				break;
			case "find":
				try {
					request.setAttribute("found", BaseModel.getFound(request.getParameter("field")));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/found.jsp").forward(request, response);
				break;
			case "delCart":
				try {
					BaseModel.delCart();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				try {
					request.setAttribute("cart", BaseModel.getCart());
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request, response);
				break;
			case "delFromCart":
				try {
					BaseModel.delFromCart(Integer.parseInt(request.getParameter("id")));
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				try {
					request.setAttribute("cart", BaseModel.getCart());
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request, response);
				break;
			case "order":
				request.getRequestDispatcher("WEB-INF/views/orderOldUser.jsp").forward(request, response);
				break;
			case "reg":
				request.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(request, response);
				break;
			case "forAdmin":
				request.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(request, response);
				break;
			case "done":
				try {
					BaseModel.adminDone(Integer.parseInt(request.getParameter("id")));
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					request.setAttribute("orders", BaseModel.getOrders());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/views/newOrdersForAdminPage.jsp").forward(request, response);
				break;				
			}
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
				
		var id = Integer.parseInt(request.getParameter("id"));
		if(id > 0) {
			var writer = response.getWriter();
			try {
				if(BaseModel.addGood(id)) {
					writer.append("Товар успешно добавлен в корзину!");
				}else {
					writer.append("Возникла ошибка при добавлении товара!");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
