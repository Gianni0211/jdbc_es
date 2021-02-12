package it.jdbc.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDao;
import dao.CityImplDao;
import model.City;


public class CityServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cityName = req.getParameter("citta");
		CityDao cityDao = new CityImplDao();
		City city = cityDao.findCityByName(cityName);
		while (city == null) {
			req.setAttribute("res", "La citta non esiste nel database");
			
			RequestDispatcher rd = req.getRequestDispatcher("page1.jsp");
			rd.forward(req, resp);
		}
		req.setAttribute("city", city);
		
		RequestDispatcher rd = req.getRequestDispatcher("page1.jsp");
		rd.forward(req, resp);
	}

}
