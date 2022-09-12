package controllers;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BaseModel;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		var searchField = request.getParameter("searchField");
		var writer = response.getWriter();
		
		writer.append("<button style=\"background: yellow; font-size: 25px;\"><a href=\'?action=find&field=" + searchField + "'>Показать результаты поиска</a></button>");
	
	}

}
