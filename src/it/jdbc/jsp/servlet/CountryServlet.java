package it.jdbc.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CountryDao;
import dao.CountryImplDao;
import model.Country;

public class CountryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("paese");
		String continent = req.getParameter("continente");
		CountryDao countryDao = new CountryImplDao();
		Country country = countryDao.findCountryByNameAndContinent(name, continent);
		while (country == null) {
			req.setAttribute("res", "Il paese non esiste nel database");
			
			RequestDispatcher rd = req.getRequestDispatcher("page2.jsp");
			rd.forward(req, resp);
		}
		
		req.setAttribute("country", country);
		
		RequestDispatcher rd = req.getRequestDispatcher("page2.jsp");
		rd.forward(req, resp);
	}
}
