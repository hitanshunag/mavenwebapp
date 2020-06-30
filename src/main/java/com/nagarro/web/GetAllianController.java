package com.nagarro.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.web.dao.AlienDao;
import com.nagarro.web.model.Alien;

/**
 * Servlet implementation class GetAllianController
 */
public class GetAllianController extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int aid = Integer.parseInt(request.getParameter("aid"));
		AlienDao aliendao = new AlienDao();
		Alien aliendData = aliendao.getAlien(aid);
		
		request.setAttribute("alien", aliendData);
		RequestDispatcher rd = request.getRequestDispatcher("showalien.jsp");
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
