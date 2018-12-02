package com.logger.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = -2526526451910464724L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commonfilePath = getServletContext().getInitParameter("CommonPath");
		List<String> filePath = new DownloadFile().listFilesForFolder(commonfilePath);
		for (String path : filePath) {
			if (path.endsWith(".xlsx")) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + path + "\"");
				FileInputStream fileInputStream = new FileInputStream(path);
				int i;
				while ((i = fileInputStream.read()) != -1) {
					out.write(i);
				}
				fileInputStream.close();
				out.close();
			}
		}
	}

	int counter = 0;
	List<String> filesPath = null;

	public List<String> listFilesForFolder(final String path) {
		File folder = new File(path);
		if (filesPath == null) {
			filesPath = new ArrayList<String>();
		}
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory() && (++counter < 3)) {
				listFilesForFolder(fileEntry.toString());
			} else {
				filesPath.add(fileEntry.toString());
			}
		}
		counter = 0;
		return filesPath;
	}
}
