package com.performance.servlets;

import java.io.IOException;
import java.util.List;
import static java.util.stream.Collectors.summingInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.CalculateAttendencePercentage;
import com.performance.dao.StudentDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.MarksDto;
import com.performance.dto.MarksDtoSubjectwise;
import com.performance.dto.MarksDtoTotal;
import com.performance.dto.StudentDto;

/**
 * Servlet implementation class ShowResult
 */
@WebServlet("/ShowResult")
public class ShowResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userId") != null) {

			String rollNumber = request.getParameter("rollNumber");
			int semester = Integer.parseInt(request.getParameter("semester"));

			List<MarksDtoSubjectwise> subjectWiseMarkList = StudentDao.getSubjectWiseMark(rollNumber, semester);
			List<MarksDto> internalMarkList = StudentDao.getInternalMarks(rollNumber, semester);

			if (subjectWiseMarkList.isEmpty()) {
				String errMsg = "No record Found";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("SearchStudentPerformance").forward(request, response);
			} else {
				request.setAttribute("subjectWiseMarkList", subjectWiseMarkList);

				request.setAttribute("internalMarkList", internalMarkList);

				StudentDto studentDto = StudentDao.getInformation(rollNumber);
				request.setAttribute("studentDto", studentDto);

				request.setAttribute("semester", semester);

				MarksDtoTotal total = StudentDao.getTotalMarks(rollNumber, semester);

				request.setAttribute("total", total);

				int totalAttendedClass = internalMarkList.stream().collect(summingInt(MarksDto::getAttendedClass));
				int totalClasses = internalMarkList.stream().collect(summingInt(MarksDto::getTotalClasses));

				float totalAttendencePercentage = (float) CalculateAttendencePercentage
						.calculatePrcentage(totalAttendedClass, totalClasses);

				request.setAttribute("totalAttendedClass", totalAttendedClass);
				request.setAttribute("totalClasses", totalClasses);
				request.setAttribute("totalAttendencePercentage", totalAttendencePercentage);

				request.getRequestDispatcher("viewResult.jsp").forward(request, response);
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
