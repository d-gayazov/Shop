package controllers;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BaseModel;


@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		var loginAdm = request.getParameter("loginAdm");
		var passAdm = request.getParameter("passAdm");
		var writer = response.getWriter();
		
		try {
			if(BaseModel.checkAdmin(loginAdm,passAdm)) {
//				request.setAttribute("orders", BaseModel.getOrders());
//				request.getRequestDispatcher("WEB-INF/views/newOrdersForAdmin.jsp").forward(request, response);
				writer.append("�� �������������� ��� �������������!")
//				.append("<button style=\"background: yellow; font-size: 20px;\"><a href=\"?action=showOrders\">�������� ����� ������</a></button>");
				.append("<button style=\"background: yellow; font-size: 20px;\" onclick=\"showOrders()\">�������� ����� ������</button>");
			} else {
				writer.append("�� ����� �������� ������!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
