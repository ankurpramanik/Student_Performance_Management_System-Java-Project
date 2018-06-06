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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
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

			String firstName[] = request.getParameterValues("firstName");
			String lastName[] = request.getParameterValues("lastName");
			String guardianName[] = request.getParameterValues("guardianName");
			String addLine1[] = request.getParameterValues("addLine1");
			String addLine2[] = request.getParameterValues("addLine2");
			String city[] = request.getParameterValues("city");
			String state[] = request.getParameterValues("state");
			String zipcode[] = request.getParameterValues("zipcode");
			String country[] = request.getParameterValues("country");
			String phoneNumber[] = request.getParameterValues("phoneNumber");
			String guardianPhoneNumber[] = request.getParameterValues("guardianPhoneNumber");
			String email[] = request.getParameterValues("email");
			String department[] = request.getParameterValues("department");
			String sem[] = request.getParameterValues("sem");
			String extraCurricular[] = request.getParameterValues("extraCurricular");

			System.out.println("rollnumber length ius>>?>" + rollNumber.length);

			for (int i = 0; i < rollNumber.length; i++) {

				StudentDto studentDetails = new StudentDto();

				String roll = rollNumber[i];
				String fName = firstName[i];
				String lName = lastName[i];
				String gurardName = guardianName[i];
				String addressLine1 = addLine1[i];
				String addressLine2 = addLine2[i];
				String city1 = city[i];
				String state1 = state[i];
				String pinCode = zipcode[i];
				String country1 = country[i];
				String phone = phoneNumber[i];
				String gPhone = guardianPhoneNumber[i];
				String mail = email[i];
				int departmentId = Integer.parseInt(department[i]);
				int semester = Integer.parseInt(sem[i]);

				String extra = extraCurricular[i];

				studentDetails.setRollNumber(roll);
				studentDetails.setFirstName(fName);
				studentDetails.setLastName(lName);
				studentDetails.setGuardianName(gurardName);
				studentDetails.setAddLine1(addressLine1);
				studentDetails.setAddLine2(addressLine2);
				studentDetails.setCity(city1);
				studentDetails.setState(state1);
				studentDetails.setZipcode(pinCode);
				studentDetails.setCountry(country1);
				studentDetails.setPhoneNumber(phone);
				studentDetails.setGuardianPhoneNumber(gPhone);
				studentDetails.setEmail(mail);
				studentDetails.setDepartment(departmentId);
				studentDetails.setSem(semester);
				studentDetails.setExtraCurricular(extra);

				result = StudentDao.updateStudent(studentDetails);
			}

			if (result) {
				String errMsg = "Data updated successfully";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("ShowSearchStudentPage").forward(request, response);

			} else {
				String errMsg = "Data updation failed! Enter vaild details";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("ShowSearchStudentPage").forward(request, response);

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
