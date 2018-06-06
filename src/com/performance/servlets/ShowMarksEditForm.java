package com.performance.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.StudentDao;
import com.performance.dto.EditMarksDto;
import com.performance.dto.ErrorMsg;

/**
 * Servlet implementation class ShowMarksEditForm
 */
@WebServlet("/ShowMarksEditForm")
public class ShowMarksEditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userId") != null) {
			String rollNumber = request.getParameter("rollNumber");
			String subjectCode = request.getParameter("subjectCode");

			EditMarksDto editMarksDto = StudentDao.getMark(rollNumber, subjectCode);

			if (editMarksDto.getRollNumber() != null && editMarksDto.getSubjectCode() != null) {

				request.setAttribute("editMarksDto", editMarksDto);

				request.getRequestDispatcher("marksedit.jsp").forward(request, response);
			} else {
				String errMsg = "No record found! try Again";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("SearchStudentMarksEdit").forward(request, response);
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
