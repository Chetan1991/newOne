package com.qa.util;

import java.util.ArrayList;

import com.qa.util.Xls_Reader;

public class getData {
	static Xls_Reader reader;
	public static ArrayList<Object[]> getdatexcel() {
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		 reader = new Xls_Reader("C:\\Users\\CRC\\eclipse-workspace\\020591\\src\\main\\java\\com\\qa\\data\\phpTestData.xlsx");
		 
		 for(int rownum = 2; rownum<=reader.getRowCount("Sheet1");rownum++)
		 {
			String firstName = reader.getCellData("Sheet1", "firstName", rownum);
			String last = reader.getCellData("Sheet1", "lastName", rownum);
			String mobileNumber = reader.getCellData("Sheet1", "mobileNumber", rownum);
			String email = reader.getCellData("Sheet1", "email", rownum);
			String password = reader.getCellData("Sheet1", "password", rownum);
			String confirmPassword = reader.getCellData("Sheet1","confirmPassword", rownum);
			mydata.add(new Object[] {firstName,last,mobileNumber,email,password, confirmPassword}); 
			//reader.setCellData("Sheet1", "Result", rownum, "Pass");
		 }
		return mydata;
		
	}


}
