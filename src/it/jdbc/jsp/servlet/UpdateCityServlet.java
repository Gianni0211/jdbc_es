package it.jdbc.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityUpdateDao;
import dao.CityUpdateImplDao;

public class UpdateCityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String oldName = (String) req.getSession().getAttribute("oldName");
		String name = req.getParameter("name");
		String countryCode = req.getParameter("countryCode");
		String district = req.getParameter("district");
		while(req.getParameter("population").equals("") || name.equals("") || countryCode.equals("") || district.equals("")) {
			req.setAttribute("res", "Inserisci campi validi");

			RequestDispatcher rd = req.getRequestDispatcher("updateform.jsp");
			rd.forward(req, resp);
		}
		int population = Integer.parseInt(req.getParameter("population"));

		CityUpdateDao updateDao = new CityUpdateImplDao();
		String res = updateDao.updateCity(name, countryCode, district, population, oldName);

		req.setAttribute("res", res);

		RequestDispatcher rd = req.getRequestDispatcher("page1.jsp");
		rd.forward(req, resp);
	}

}
