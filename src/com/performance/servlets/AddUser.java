package com.performance.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.UserDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.UserDto;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userId = request.getParameter("userId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		int roleId = Integer.parseInt(request.getParameter("roleId"));

		UserDto userDetails = new UserDto();

		userDetails.setUserId(userId);
		userDetails.setFirstName(firstName);
		userDetails.setLastName(lastName);
		userDetails.setEmail(email);
		userDetails.setPhone(phone);
		userDetails.setPassword(password);
		userDetails.setRoleId(roleId);

		boolean result = UserDao.addUser(userDetails);

		if (result) {
			String errMsg = "Data added. Contact admin for approval";
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setErrorMessage(errMsg);
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("ShowSignUpPage").forward(request, response);

		} else {
			String errMsg = "Data addition failed! Enter vaild details";
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setErrorMessage(errMsg);
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("ShowSignUpPage").forward(request, response);

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
