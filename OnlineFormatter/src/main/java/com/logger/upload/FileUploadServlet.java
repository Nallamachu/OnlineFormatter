package com.logger.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.logger.delete.DeleteFiles;
import com.logger.error.ExcelLogger;

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExcelLogger el = new ExcelLogger();
		DeleteFiles dFiles = new DeleteFiles();
		int maxFileSize = 999999 * 1024;
		String filePath="";
		if(System.getProperty("os.name").contains("Windows"))
			filePath = getServletContext().getInitParameter("windows_file-store_path");
		else
			filePath = getServletContext().getInitParameter("other_os_file-store_path");
		String ext = (5 + (int) (Math.random() * ((10 - 5) + 1))) + "\\";
		File f = new File(filePath + ext);
		if (!f.exists() || !f.isDirectory()) {
			f.mkdir();
		}

		File file = null;

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);
			if (fileItems.size() > 0) {
				for (int i = 0; i < fileItems.size(); i++) {
					FileItem fileItem = (FileItem) fileItems.get(i);
					if (!fileItem.isFormField()) {
						String fileName = fileItem.getName();
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(filePath + ext + fileName.substring(fileName.lastIndexOf("\\")));
						} else {
							file = new File(filePath + ext + fileName.substring(fileName.lastIndexOf("\\") + 1));
						}
						fileItem.write(file);
					}
				}
				Set<StringBuffer> stackSet = el.readFiles(filePath + ext);

				if (stackSet.size() > 0) {
					request.setAttribute("results", stackSet);
				}else {
					String errorMessage = "We are not able to generate the Unique log because of these reasons.\n"
							+ "*. Stacktrace might not start with the Year(2017)\n"
							+ "*. The log file might not have ERROR type stack trace";
					request.setAttribute("results", errorMessage);
				}
				RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
				rd.forward(request, response);
				dFiles.deleteFilesInDirectory(filePath + ext);
			}
		} catch (Exception ex) {
			request.setAttribute("results",
					"Request can't be processed.....Please click on Home button to navigate to Home page. "
							+ ex.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}
}