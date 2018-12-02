package com.format.sql;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

public class SQLFormatter extends HttpServlet {
	private static final long serialVersionUID = -7311041753072343710L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputData = request.getParameter("input");
		if (inputData == null || inputData == "") {
			String formattedSQL = "Sorry.........Request can't be processed, please Click on Home button to move Homepage.";
			request.setAttribute("results", formattedSQL);
			RequestDispatcher rd = request.getRequestDispatcher("formattedSQL.jsp");
			rd.forward(request, response);
		} else {
			String formattedSQL = formatSQL(inputData);
			request.setAttribute("results", formattedSQL);
			RequestDispatcher rd = request.getRequestDispatcher("formattedSQL.jsp");
			rd.forward(request, response);
		}
	}

	private static String formatSQL(String inputSQL) {
		return (inputSQL == null || inputSQL == "") ? "" : new BasicFormatterImpl().format(inputSQL);
	}

}
