package com.performance.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.StudentDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.MarksDtoTotal;
import com.performance.dto.StudentDto;

/**
 * Servlet implementation class ShowProgressGraph
 */
@WebServlet("/ShowProgressGraph")
public class ShowProgressGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userId") != null) {
			String rollNumber = request.getParameter("rollNumber");

			List<MarksDtoTotal> marksList = StudentDao.getMarksInformation(rollNumber);

			if (marksList.isEmpty()) {
				String errMsg = "No record found!! Try Again";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("EnterRollGraph").forward(request, response);

			} else {

				request.setAttribute("marksList", marksList);

				StudentDto student = StudentDao.getInformation(rollNumber);

				request.setAttribute("student", student);

				request.getRequestDispatcher("progressGraph.jsp").forward(request, response);

			}

		} else {
			String errMsg = "Session Expired! login again";
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setErrorMessage(errMsg);
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		}

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
