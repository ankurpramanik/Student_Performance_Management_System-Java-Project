package com.performance.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.StudentDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.SubjectDto;

/**
 * Servlet implementation class SearchStudentMarksEdit
 */
@WebServlet("/SearchStudentMarksEdit")
public class SearchStudentMarksEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userId") != null) {
			String userId = (String) request.getSession().getAttribute("userId");
			List<SubjectDto> subjectAllocated = StudentDao.getAllocatedSubjectForEditMarks(userId);
			request.getSession().setAttribute("subjectAllocated", subjectAllocated);
			request.getRequestDispatcher("marksEditSearch.jsp").forward(request, response);
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
