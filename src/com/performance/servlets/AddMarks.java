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
 * Servlet implementation class AddMarks
 */
@WebServlet("/AddMarks")
public class AddMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("userId") != null) {
			boolean result = false;

			String rollNumber[] = request.getParameterValues("rollNumber");
			String sem[] = request.getParameterValues("sem");
			String subjectCode = request.getParameter("subjectCode");
			String internal1[] = request.getParameterValues("internal1");
			String internal2[] = request.getParameterValues("internal2");
			String classTest[] = request.getParameterValues("classTest");
			String assignment[] = request.getParameterValues("assignment");
			String mcq[] = request.getParameterValues("mcq");
			String attendedClasses[] = request.getParameterValues("attendedClasses");
			String totalClasses = request.getParameter("totalClasses");

			for (int i = 0; i < rollNumber.length; i++) {

				MarksDto marks = new MarksDto();

				String roll = rollNumber[i];
				int semester = Integer.parseInt(sem[i]);
				String subCode = subjectCode;
				int internal_1 = Integer.parseInt(internal1[i]);
				int internal_2 = Integer.parseInt(internal2[i]);
				int classTest1 = Integer.parseInt(classTest[i]);
				int assignment1 = Integer.parseInt(assignment[i]);
				int mcq1 = Integer.parseInt(mcq[i]);
				int classesAttended = Integer.parseInt(attendedClasses[i]);
				int classesTotal = Integer.parseInt(totalClasses);

				double attendencePercentage = CalculateAttendencePercentage.calculatePrcentage(classesAttended,
						classesTotal);

				marks.setRoll(roll);
				marks.setSem(semester);
				marks.setSubjectCode(subCode);
				marks.setInternal1(internal_1);
				marks.setInternal2(internal_2);
				marks.setClassTest(classTest1);
				marks.setAssignment(assignment1);
				marks.setMcq(mcq1);
				marks.setAttendedClass(classesAttended);
				marks.setTotalClasses(classesTotal);
				marks.setAttendence(attendencePercentage);

				result = StudentDao.addMarks(marks);
			}

			if (result == true) {
				String errMsg = "Data added successfully";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("SelectSemesterForMarksEntry").forward(request, response);

			} else {
				String errMsg = "Data addition failed! Check The data Already Added Or not";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("SelectSemesterForMarksEntry").forward(request, response);

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
