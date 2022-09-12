package controllers;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BaseModel;


@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		var login = request.getParameter("login");
		var pass = request.getParameter("pass");
		var writer = response.getWriter();
		
		try {
			if(BaseModel.checkClient(login,pass)) {
				writer.append("�� ������������. ��� ����� ��������� �� ���������!");
				BaseModel.delCart();
			} else {
				writer.append("�� �� ������������. �������� �����������.")
				.append("<button style=\"background: yellow; font-size: 20px;\"><a href=\"?action=reg\">�����������</a></button>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}