package com.performance.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.UserDao;

/**
 * Servlet implementation class DeleteAllocated
 */
@WebServlet("/DeleteAllocated")
public class DeleteAllocated extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subCode = request.getParameter("subCode");
		String deptId = request.getParameter("deptId");
		String techerId = request.getParameter("techerId");

		System.out.println("IN DELETE ALLOCATED>>> " + subCode + " " + deptId + " " + techerId);
		
		UserDao.deleteAllocatedSubject(subCode,deptId,techerId);
		
		
		request.getRequestDispatcher("ViewAllocatedSubjects").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
