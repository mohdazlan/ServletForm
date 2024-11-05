package com.eligibilityform.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EligbilityFormServlet
 */
public class EligbilityFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EligbilityFormServlet() {
		super();
		 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h1>Eligibility Check Form");
		out.println("<form method='POST' action='EligbilityFormServlet'>");
		out.println("Full Name: <input type='text' name='fullName' required><br>");
		out.println("ID Number: <input type='text' name='idNumber' required><br>");
		out.println("Home Address: <input type='text' name='address' required><br>");
		out.println("Age: <input type='number' name='age' min='0' required><br>");
		out.println("<input type='submit' value='Check Eligibility'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setHeader("Accept-Language", "ms-MY");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String fullName = request.getParameter("fullName");
		String idNumber = request.getParameter("idNumber");
		String address = request.getParameter("address");
		String ageParam = request.getParameter("age");

		if (fullName.isEmpty() || idNumber.isEmpty() || address.isEmpty() || ageParam.isEmpty()) {
			out.println("<html><body>");
			out.println("<h3>Error: Age must be a valid number</h3>");
			out.println("<p><a href='EligibilityFormServlet>Back to Form</a></p>");
			out.println("</body></html>");
		}
		
		int age;
		age = Integer.parseInt(ageParam);
		
		out.println("text/html");
		if(age >= 20 && age <= 35) {
			out.println("<h3>Congratulations, " + fullName + "! You are eligible for the manufacturing roles. </h3> ");
		} else {
			out.println("<h3>Sorry, " + fullName + "! You are eligible for the manufacturing roles. </h3> ");
		}
		out.println("</body></html>");

	}

}
