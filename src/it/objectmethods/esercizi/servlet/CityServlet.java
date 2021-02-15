package it.objectmethods.esercizi.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethods.esercizi.dao.CityDao;
import it.objectmethods.esercizi.dao.CityImplDao;
import it.objectmethods.esercizi.model.City;


public class CityServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cityName = req.getParameter("citta");
		System.out.println(cityName);
		CityDao cityDao = new CityImplDao();
		City city = cityDao.findCityByName(cityName);
		String err = "";
		if (city == null) {
			
			
			err = "La citta non esiste nel database";
		}
		req.setAttribute("city", city);
		req.setAttribute("err", err);
		
		RequestDispatcher rd = req.getRequestDispatcher("page1.jsp");
		rd.forward(req, resp);
	}

}
