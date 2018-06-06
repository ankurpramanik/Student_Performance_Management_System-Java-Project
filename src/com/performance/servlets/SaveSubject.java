package com.performance.servlets;

import java.io.IOException;
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
 * Servlet implementation class SaveSubject
 */
@WebServlet("/SaveSubject")
public class SaveSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("userId") != null) {

			String subjectCode = request.getParameter("subjectCode");
			String teacher = request.getParameter("teacher");
			int departmentId = (int) request.getSession().getAttribute("departmentId");
			System.out.println("Department id at allocated>>>>>>>>" + departmentId);

			UserDto userDto = new UserDto();
			SubjectDto subjectDto = new SubjectDto();

			subjectDto.setSubjectCode(subjectCode);
			userDto.setUserId(teacher);

			boolean result = StudentDao.allocateSubject(subjectDto, userDto, departmentId);

			if (result) {
				String errMsg = "Subject Allocated!";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);

				request.getRequestDispatcher("subjectEntry.jsp").forward(request, response);

			} else {
				String errMsg = "Subject Allocation failed! Try Again";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);

				request.getRequestDispatcher("subjectEntry.jsp").forward(request, response);

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
