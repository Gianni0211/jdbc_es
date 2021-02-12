package it.jdbc.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDeleteDao;
import dao.CityDeleteImplDao;

public class DeleteCityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cityName = req.getParameter("citta");
		CityDeleteDao deleteDao = new CityDeleteImplDao();
		String result = deleteDao.deleteCityByName(cityName);

		req.setAttribute("res", result);

		RequestDispatcher rd = req.getRequestDispatcher("page1.jsp");
		rd.forward(req, resp);
	}

}
