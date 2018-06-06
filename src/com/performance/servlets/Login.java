package com.performance.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.UserDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.MenuDto;
import com.performance.dto.UserDto;
import static com.performance.dao.UserDao.validateUser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean validated = false;

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		validated = validateUser(userId, password);

		if (validated) {

			UserDto dto = UserDao.getUser(userId);
			List<MenuDto> menuList = UserDao.getMenus(userId);

			request.getSession().setAttribute("user", dto);
			request.getSession().setAttribute("userId", userId);
			request.getSession().setAttribute("password", password);
			request.getSession().setAttribute("menuList", menuList);

			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} else {
			String errMsg = "Incorrect username or password";
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setErrorMessage(errMsg);
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("signin.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
