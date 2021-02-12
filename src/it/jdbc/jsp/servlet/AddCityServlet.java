package it.jdbc.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityAddDao;
import dao.CityAddImplDao;

public class AddCityServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		while(req.getParameter("population").equals("") || req.getParameter("id").equals("") || req.getParameter("countryCode").equals("") || req.getParameter("district").equals("") || req.getParameter("name").equals("")) {
			req.setAttribute("res", "Inserisci campi validi");

			RequestDispatcher rd = req.getRequestDispatcher("addform.jsp");
			rd.forward(req, resp);
		}
		
		String name = req.getParameter("name");
		String countryCode = req.getParameter("countryCode");
		String district = req.getParameter("district");
		int population = Integer.parseInt(req.getParameter("population"));
		int id = Integer.parseInt(req.getParameter("id"));
		CityAddDao addDao = new CityAddImplDao();
		
		String res = addDao.addCity(name, countryCode, district, population, id);
		
		req.setAttribute("res", res);
		
		RequestDispatcher rd = req.getRequestDispatcher("page1.jsp");
		rd.forward(req, resp);
	}

}
