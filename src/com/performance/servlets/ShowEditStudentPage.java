package com.performance.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.StudentDao;
import com.performance.dao.UserDao;
import com.performance.dto.DepartmentDto;
import com.performance.dto.ErrorMsg;
import com.performance.dto.StudentDto;

/**
 * Servlet implementation class ShowEditStudentPage
 */
@WebServlet("/ShowEditStudentPage")
public class ShowEditStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getSession().getAttribute("userId") != null) {

			int department = Integer.parseInt(request.getParameter("department"));
			int sem = Integer.parseInt(request.getParameter("sem"));

			List<StudentDto> studentList = StudentDao.getInformations(department, sem);

			if (studentList.isEmpty()) {
				System.out.println("No record found");

				String errMsg = "No record found! try Again";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("ShowSearchStudentPage").forward(request, response);
			} else {
				System.out.println("record found");

				request.setAttribute("studentList", studentList);

				List<DepartmentDto> departmentList = UserDao.getDepartments();
				request.getSession().setAttribute("departmentList", departmentList);
				request.getRequestDispatcher("editStudent.jsp").forward(request, response);
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
