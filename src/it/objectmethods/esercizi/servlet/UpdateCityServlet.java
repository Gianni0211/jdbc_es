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

public class UpdateCityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jsp = "page1.jsp";
		String err = "";
		String oldName = (String) req.getSession().getAttribute("oldName");
		String name = req.getParameter("name");
		String countryCode = req.getParameter("countryCode");
		String district = req.getParameter("district");
		if (req.getParameter("population").equals("") || name.equals("") || countryCode.equals("")
				|| district.equals("")) {
			err = "Inserisci campi validi";

		}
		int population = Integer.parseInt(req.getParameter("population"));

		CityDao dao = new CityImplDao();
		City city = new City();
		city.setCountry(countryCode);
		city.setDistrict(district);
		city.setName(name);
		city.setPopulation(population);
		int res = dao.updateCity(city, oldName);

		req.setAttribute("res", res);
		req.setAttribute("err", err);

		RequestDispatcher rd = req.getRequestDispatcher(jsp);
		rd.forward(req, resp);
	}

}
