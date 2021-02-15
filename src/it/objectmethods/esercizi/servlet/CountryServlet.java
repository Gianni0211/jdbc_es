package it.objectmethods.esercizi.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethods.esercizi.dao.CountryDao;
import it.objectmethods.esercizi.dao.CountryImplDao;
import it.objectmethods.esercizi.model.Country;

public class CountryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("paese");
		String continent = req.getParameter("continente");
		String err = "";
		CountryDao countryDao = new CountryImplDao();
		Country country = countryDao.findCountryByNameAndContinent(name, continent);
		if (country == null) {
			err = "Il paese non esiste nel database";
			req.setAttribute("err", err);
			
			
		}
		
		req.setAttribute("country", country);
		req.setAttribute("err", err);
		
		RequestDispatcher rd = req.getRequestDispatcher("page2.jsp");
		rd.forward(req, resp);
	}
}
