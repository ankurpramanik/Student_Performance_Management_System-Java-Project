package com.performance.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performance.dao.EmailDao;
import com.performance.dto.EmailDto;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String messege = request.getParameter("messege");

		EmailDto emailList = new EmailDto();

		emailList.setFirstName(firstName);
		emailList.setLastName(lastName);
		emailList.setEmail(email);
		emailList.setSubject(subject);
		emailList.setMessege(messege);

		boolean result = EmailDao.sendMail(emailList);

		System.out.println("mail send==" + result);

		request.getRequestDispatcher("index.jsp").forward(request, response);
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
		processRequest(request, response);

	}

}
