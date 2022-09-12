package controllers;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BaseModel;

@WebServlet("/Registr")
public class Registr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		var surname = request.getParameter("surname");
	    var name = request.getParameter("name");
	    var patr = request.getParameter("patr");
	    var phNum = request.getParameter("phNum");
	    var login = request.getParameter("login");
	    var passwrd = request.getParameter("passwrd");
		var writer = response.getWriter();
		
		try {
			BaseModel.addClient(login,passwrd,surname,name,patr,phNum);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(BaseModel.checkClient(login,passwrd)) {
				writer.append("Вы зарегистрированы. Ваш заказ отправлен на обработку!");
				BaseModel.delCart();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
