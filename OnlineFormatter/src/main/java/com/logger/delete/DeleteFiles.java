package com.logger.delete;

import java.io.File;

import org.joda.time.DateTime;

public class DeleteFiles {

	public void deleteFilesInDirectory(String actualPath) {
		File fileObj = new File(actualPath);
		File[] fileList = fileObj.listFiles();
		for (File file : fileList) {
			if (file.isFile() && file.exists() && !file.isDirectory()) {
				if (!file.getName()
						.substring(file.getName().lastIndexOf('.') + 1)
						.toString().endsWith("xlsx")) {
					file.delete();
				}
			}
		}
	}

	public void deleteAll(String actualPath) {
		File fileObj = new File(actualPath);
		File[] fileList = fileObj.listFiles();
		for (File file : fileList) {
			if (file.exists() && DeleteFiles.isFileEligible(file)) {
				if (file.isDirectory() && file.list().length == 0) {
					file.delete();
				} else if (file.list().length > 0) {
					String[] subFilesArray = file.list();
					for (String subFileString : subFilesArray) {
						File subFile = new File(file, subFileString);
						deleteAll(subFile.toString());
					}
				} else {
					file.delete();
				}
			}
		}
	}
	
	public static boolean isFileEligible(File file){
		DateTime lastModified = new DateTime(file.lastModified());
		DateTime currentDate = new DateTime().minusMinutes(20);
		return currentDate.isAfter(lastModified);
	}
}
