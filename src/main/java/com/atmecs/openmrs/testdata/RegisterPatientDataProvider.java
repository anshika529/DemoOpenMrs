package com.atmecs.openmrs.testdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.openmrs.constants.Constants;

public class RegisterPatientDataProvider {
	@DataProvider(name = "Register")
	public static Object[][] getData() throws IOException {
		ExcelData xls = new ExcelData(Constants.EXCEL_DATA_PATH);
		Object[][] data = xls.readExcelData("RegisterData");
		return data;

	}
}
