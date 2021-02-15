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

public class AddCityServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jsp = "page1.jsp";
		if(req.getParameter("population").equals("") || req.getParameter("id").equals("") || req.getParameter("countryCode").equals("") || req.getParameter("district").equals("") || req.getParameter("name").equals("")) {
			req.setAttribute("res", "Inserisci campi validi");

			jsp = "addform.jsp";
			
		}
		
		String name = req.getParameter("name");
		String countryCode = req.getParameter("countryCode");
		String district = req.getParameter("district");
		int population = Integer.parseInt(req.getParameter("population"));
		City city = new City();
		city.setName(name);
		city.setCountry(countryCode);
		city.setDistrict(district);
		city.setPopulation(population);
		CityDao dao = new CityImplDao();
		
		int res = dao.addCity(city);
		
		req.setAttribute("res", res);
		
		RequestDispatcher rd = req.getRequestDispatcher(jsp);
		rd.forward(req, resp);
	}

}
