package com.format.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

public class FormatXML extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputData = request.getParameter("input");
		if(inputData==null || inputData=="") {
			String formattedString = "Sorry.........Request can't be processed, please Click on Home button to move Homepage.";
			request.setAttribute("results", formattedString);
			RequestDispatcher rd = request.getRequestDispatcher("formattedXML.jsp");
			rd.forward(request, response);
		}else {
			String formattedString = formatXML(inputData);
			request.setAttribute("results", formattedString);
			RequestDispatcher rd = request.getRequestDispatcher("formattedXML.jsp");
			rd.forward(request, response);
		}
	}

	private static String formatXML(String input) {
		try {
			final InputSource src = new InputSource(new StringReader(input));
			final Element document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src)
					.getDocumentElement();
			final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			final LSSerializer writer = impl.createLSSerializer();
			writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
			writer.getDomConfig().setParameter("xml-declaration", true);

			return writer.writeToString(document);
		} catch (Exception e) {
			e.printStackTrace();
			return input;
		}
	}
}
