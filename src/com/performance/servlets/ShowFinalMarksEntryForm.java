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
import com.performance.dto.StudentDto;
import com.performance.dto.SubjectDto;

/**
 * Servlet implementation class ShowFinalMarksEntryForm
 */
@WebServlet("/ShowFinalMarksEntryForm")
public class ShowFinalMarksEntryForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int semester = Integer.parseInt(request.getParameter("semester"));
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));

		if (request.getSession().getAttribute("userId") != null) {

			List<StudentDto> studentsList = StudentDao.getStudents(semester, departmentId);

			List<SubjectDto> subjectList = StudentDao.getSubjects(semester, departmentId);
			request.getSession().setAttribute("subjectList", subjectList);

			if (studentsList.isEmpty()) {
				String errMsg = "No record found";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("SearchStudentForSemMarksEntry").forward(request, response);
			} else {

				request.setAttribute("studentsList", studentsList);
				request.getRequestDispatcher("finalMarksEntry.jsp").forward(request, response);

			}

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
