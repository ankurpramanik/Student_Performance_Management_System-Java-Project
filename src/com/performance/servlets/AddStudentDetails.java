package com.performance.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.StudentDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.StudentDto;

/**
 * Servlet implementation class AddStudentDetails
 */
@WebServlet("/AddStudentDetails")
public class AddStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userId") != null) {
			String rollNumber = request.getParameter("rollNumber");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String guardianName = request.getParameter("guardianName");
			String addLine1 = request.getParameter("addLine1");
			String addLine2 = request.getParameter("addLine2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipcode = request.getParameter("zipcode");
			String country = request.getParameter("country");
			String phoneNumber = request.getParameter("phoneNumber");
			String guardianPhoneNumber = request.getParameter("guardianPhoneNumber");
			String email = request.getParameter("email");
			int department = Integer.parseInt(request.getParameter("department"));
			String extraCurricular = request.getParameter("extraCurricular");
			int sem = Integer.parseInt(request.getParameter("sem"));

			StudentDto studentDetails = new StudentDto();
			studentDetails.setRollNumber(rollNumber);
			studentDetails.setFirstName(firstName);
			studentDetails.setLastName(lastName);
			studentDetails.setGuardianName(guardianName);
			studentDetails.setAddLine1(addLine1);
			studentDetails.setAddLine2(addLine2);
			studentDetails.setCity(city);
			studentDetails.setState(state);
			studentDetails.setZipcode(zipcode);
			studentDetails.setCountry(country);
			studentDetails.setPhoneNumber(phoneNumber);
			studentDetails.setGuardianPhoneNumber(guardianPhoneNumber);
			studentDetails.setEmail(email);
			studentDetails.setDepartment(department);
			studentDetails.setSem(sem);
			studentDetails.setExtraCurricular(extraCurricular);

			boolean result = StudentDao.addStudent(studentDetails);

			if (result) {
				String errMsg = "Data added successfully";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("ShowRegistrationPage").forward(request, response);

			} else {
				String errMsg = "Data addition failed! Enter vaild details";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("ShowRegistrationPage").forward(request, response);

			}

		} else {
			String errMsg = "Session Expired! login again";
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setErrorMessage(errMsg);
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
