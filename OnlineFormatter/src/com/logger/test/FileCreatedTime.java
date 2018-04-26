package com.logger.test;

import java.io.File;

import org.joda.time.DateTime;

public class FileCreatedTime {

	public static void main(String[] args) {
		String filePath = "D:\\Application\\Logger\\input\\data\\8\\";
		File file = new File(filePath);
		DateTime lastModified = new DateTime(file.lastModified());
		DateTime currentDate = new DateTime().minusMinutes(20);
		System.out.println(currentDate.isAfter(lastModified));	
		
	}

}
