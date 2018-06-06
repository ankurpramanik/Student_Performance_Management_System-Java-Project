package com.performance.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.RoleIdDao;
import com.performance.dao.UserDao;
import com.performance.dto.ErrorMsg;
import com.performance.dto.RoleDto;
import com.performance.dto.UserDto;

/**
 * Servlet implementation class ShowEditUserPage
 */
@WebServlet("/ShowEditUserPage")
public class ShowEditUserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userId") != null) {

			String userId = request.getParameter("userId");

			System.out.println("userid >>" + userId);

			UserDto userDto = UserDao.getUserInformation(userId);
			if (userDto.getUserId() == null) {
				String errMsg = "no record found! try again";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errMsg);
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("ShowSearchUserPage").forward(request, response);
			} else {
				request.setAttribute("userDto", userDto);

				List<RoleDto> roleList = RoleIdDao.getRole();
				request.getSession().setAttribute("roleList", roleList);

				request.getRequestDispatcher("editUser.jsp").forward(request, response);
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
