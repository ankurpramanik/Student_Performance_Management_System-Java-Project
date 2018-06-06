package com.performance.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.CalculateAttendencePercentage;
import com.performance.dao.StudentDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.MarksDto;

/**
 * Servlet implementation class UpdateMarks
 */
@WebServlet("/UpdateMarks")
public class UpdateMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userId") != null) {

			String rollNumber = request.getParameter("rollNumber");
			int sem = Integer.parseInt(request.getParameter("sem"));
			String subjectCode = request.getParameter("subjectCode");

			int internal1 = Integer.parseInt(request.getParameter("internal1"));
			int internal2 = Integer.parseInt(request.getParameter("internal2"));
			int classTest = Integer.parseInt(request.getParameter("classTest"));
			int assignment = Integer.parseInt(request.getParameter("assignment"));
			int mcq = Integer.parseInt(request.getParameter("mcq"));
			int attendedClass = Integer.parseInt(request.getParameter("classAttended"));
			int totalClasses = Integer.parseInt(request.getParameter("totalClasses"));

			double attendencePercentage = CalculateAttendencePercentage.calculatePrcentage(attendedClass, totalClasses);

			MarksDto markList = new MarksDto();

			markList.setRoll(rollNumber);
			markList.setSem(sem);
			markList.setSubjectCode(subjectCode);

			markList.setInternal1(internal1);
			markList.setInternal2(internal2);
			markList.setClassTest(classTest);
			markList.setAssignment(assignment);
			markList.setMcq(mcq);

			markList.setAttendedClass(attendedClass);
			markList.setTotalClasses(totalClasses);
			markList.setAttendence(attendencePercentage);

			boolean result = StudentDao.updateMarks(markList);

			if (result) {
				String errMsg = "Data updated successfully";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("SearchStudentMarksEdit").forward(request, response);

			} else {
				String errMsg = "Data updation failed!";
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
