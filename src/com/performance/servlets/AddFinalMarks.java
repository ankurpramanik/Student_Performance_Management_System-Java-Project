package com.performance.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.CalculateSemesterMarks;
import com.performance.dao.StudentDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.MarksDtoSubjectwise;
import com.performance.dto.MarksDtoTotal;

/**
 * Servlet implementation class AddFinalMarks
 */
@WebServlet("/AddFinalMarks")
public class AddFinalMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userId") != null) {
			boolean result = false;

			String rollNumber[] = request.getParameterValues("rollNumber");
			String sem[] = request.getParameterValues("sem");
			String subjectCode = request.getParameter("subjectCode");
			String pointsGot[] = request.getParameterValues("pointsGot");

			System.out.println("Final Marks");

			for (int i = 0; i < rollNumber.length; i++) {
				MarksDtoSubjectwise subjectwiseMarks = new MarksDtoSubjectwise();

				String roll = rollNumber[i];
				int semester = Integer.parseInt(sem[i]);
				String subCode = subjectCode;
				int points = Integer.parseInt(pointsGot[i]);
				int subjectCredit = StudentDao.getCredit(subCode);
				int creditPoint = CalculateSemesterMarks.calculateCreditPoint(points, subjectCredit);
				String letterGrade = CalculateSemesterMarks.getLetterGrade(points);

				System.out.println(roll + " " + semester + " " + subCode + " " + points + " " + subjectCredit + " "
						+ creditPoint + " " + letterGrade);

				subjectwiseMarks.setRoll(roll);
				subjectwiseMarks.setSem(semester);
				subjectwiseMarks.setSubjectCode(subCode);
				subjectwiseMarks.setPoints(points);
				subjectwiseMarks.setSubjectCredit(subjectCredit);
				subjectwiseMarks.setCreditPoints(creditPoint);
				subjectwiseMarks.setLetterGrade(letterGrade);

				int totalCreditPoint = CalculateSemesterMarks.calculateCreditPoint(points, subjectCredit);

				result = StudentDao.addFinalMarksSubjectWise(subjectwiseMarks);

				boolean finalMark = StudentDao.getTotalMarkList(roll, semester);

				if (finalMark == false && result == true) {
					System.out.println("no record found");

					MarksDtoTotal totalMarks = new MarksDtoTotal();

					totalMarks.setRoll(roll);
					totalMarks.setSem(semester);
					totalMarks.setTotalCredit(subjectCredit);

					totalMarks.setTotalCreditPoints(totalCreditPoint);

					double sgpa = CalculateSemesterMarks.calculateSgpa(subjectCredit, totalCreditPoint);

					totalMarks.setSgpa(sgpa);

					StudentDao.insertTotalMarks(totalMarks);

				} else if (result == true && finalMark == true) {
					System.out.println("record found in final marks++++****");

					MarksDtoTotal marksDtoTotal = StudentDao.getTotalMarks(roll, semester);

					int updatedTotalCredit = (marksDtoTotal.getTotalCredit()) + subjectCredit;
					int updatedCreditPoint = (marksDtoTotal.getTotalCreditPoints()) + totalCreditPoint;

					double updatedSGPA = CalculateSemesterMarks.calculateSgpa(updatedTotalCredit, updatedCreditPoint);

					System.out.println(updatedTotalCredit + " " + updatedCreditPoint + " " + updatedSGPA);
					MarksDtoTotal totalMarks = new MarksDtoTotal();

					totalMarks.setRoll(roll);
					totalMarks.setSem(semester);
					totalMarks.setTotalCredit(updatedTotalCredit);
					totalMarks.setTotalCreditPoints(updatedCreditPoint);
					totalMarks.setSgpa(updatedSGPA);

					StudentDao.updateFinalMarks(totalMarks);
				}

			}
			if (result == true) {
				String errMsg = "Data added successfully";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("SearchStudentForSemMarksEntry").forward(request, response);

			} else {
				String errMsg = "Data addition failed! Check The data Already Added Or not";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("SearchStudentForSemMarksEntry").forward(request, response);

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
