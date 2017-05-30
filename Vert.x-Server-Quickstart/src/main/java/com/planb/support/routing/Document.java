package com.planb.support.routing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Document {
	private XSSFWorkbook wb;

	public Document(List<RESTResource> resourceList) {
		String fileName = "API Document.xlsx";
		wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("API");
		
		XSSFRow rowHead = sheet.createRow(0);
		rowHead.createCell(0).setCellValue("Function Name");
		rowHead.createCell(1).setCellValue("Summary");
		rowHead.createCell(2).setCellValue("Method");
		rowHead.createCell(3).setCellValue("URI");
		rowHead.createCell(4).setCellValue("Request Header");
		rowHead.createCell(5).setCellValue("Form Attributes");
		rowHead.createCell(6).setCellValue("Success Code");
		rowHead.createCell(8).setCellValue("Response Header");
		rowHead.createCell(9).setCellValue("Response Body");
		rowHead.createCell(10).setCellValue("Failure Code");
		
		int rowCount = 1;
		
		for(RESTResource resource : resourceList) {
			XSSFRow row = sheet.createRow(rowCount++);
			
			row.createCell(0).setCellValue(resource.getName());
			row.createCell(1).setCellValue(resource.getSummary());
			row.createCell(2).setCellValue(resource.getMethod());
			row.createCell(3).setCellValue(resource.getUri());
			row.createCell(4).setCellValue(resource.getRequestHeaders());
			row.createCell(5).setCellValue(resource.getParams());
			row.createCell(6).setCellValue(resource.getResponseBody());
			row.createCell(7).setCellValue(resource.getSuccessCode());
			row.createCell(8).setCellValue(resource.getResponseHeaders());
			row.createCell(9).setCellValue(resource.getResponseBody());
			row.createCell(10).setCellValue(resource.getFailureCode());
		}
		
		try {
			wb.write(new FileOutputStream(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
