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
import com.performance.dto.UserDto;

/**
 * Servlet implementation class SubjectAllocation
 */
@WebServlet("/SubjectAllocation")
public class SubjectAllocation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sem = Integer.parseInt(request.getParameter("sem"));
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		if (request.getSession().getAttribute("userId") != null) {

			request.getSession().setAttribute("departmentId", departmentId);
			List<SubjectDto> subjectList = StudentDao.getSubject(sem, departmentId);

			List<UserDto> facultyList = StudentDao.getFaculty();

			request.getSession().setAttribute("subjectList", subjectList);
			request.getSession().setAttribute("facultyList", facultyList);

			request.getRequestDispatcher("subjectEntry.jsp").forward(request, response);
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
