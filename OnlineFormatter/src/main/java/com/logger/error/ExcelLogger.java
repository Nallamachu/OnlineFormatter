package com.logger.error;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLogger {

	public Set<StringBuffer> readFiles(String directory) throws InterruptedException, IOException {
		HashMap<String, String> validateKeys = new HashMap<String, String>();
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		final String filter1 = cal.get(Calendar.YEAR) + "-";
		final String filter2 = (cal.get(Calendar.YEAR) - 1) + "-";
		final String filter3 = " ERROR ";
		Set<StringBuffer> stackSet = new HashSet<StringBuffer>();
		List<String> filePath = new ExcelLogger().listFilesForFolder(directory);
		for (String path : filePath) {
			Scanner sc = new Scanner(new FileReader(path));
			String line = null;
			StringBuffer sb = null;
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line == null) {

				} else {
					if ((line.contains(filter1) || line.contains(filter2))
							&& (line.contains(filter3) || line.contains(filter3.toLowerCase()))) {
						String key = getKeyValue(line);
						if (key != null && !validateKeys.containsKey(key)) {
							validateKeys.put(key, "");
							if (sb != null) {
								stackSet.add(sb);
								sb = null;
							}
							sb = new StringBuffer().append(line + "\n");
						} else {
							stackSet.add(sb);
							sb = null;
						}
					} else {
						if (sb != null) {
							if (line != null && line != "") {
								sb.append(line + "\n");
							}
						}
					}
				}
			}
			sc.close();
		}
		if (stackSet != null && stackSet.size() > 0) {
			writeToExcel(stackSet, directory);
		}
		return stackSet;
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

	public static void writeToExcel(Set<StringBuffer> stackSet, String path) throws IOException {
		FileOutputStream fos = null;
		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet excelSheet = workBook.createSheet("Error Log");
		int rowCount = 0;
		int colCount = 0;
		for (StringBuffer sb : stackSet) {
			Row row = excelSheet.createRow(rowCount++);
			Cell cell = row.createCell(colCount);
			if (sb instanceof StringBuffer) {
				cell.setCellValue(sb.toString());
			}
		}
		try {
			fos = new FileOutputStream(path + "ExcelLog.xlsx");
			workBook.write(fos);
			Desktop.getDesktop().open(new File(path + "ExcelLog.xlsx"));
		} catch (Exception e) {
			System.out.println("Exception while creating the Excel File: " + e.getMessage());
		} finally {
			fos.close();
		}
	}

	public static String getKeyValue(String line) {
		String lineArray[] = line.split(" ");
		for (int i = 0; i < lineArray.length; i++) {
			if ("ERROR".equals(lineArray[i])) {
				return lineArray[++i];
			}
		}
		return null;
	}
}
