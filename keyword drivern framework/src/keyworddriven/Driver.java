package keyworddriven;

import java.lang.reflect.Method;

public class Driver {
	public static void main(String[] args) {
		Excel TCExcel = new Excel();
		Excel TSExcel = new Excel();
		ActionKeywords actionKeywords = new ActionKeywords();
		// java reflection method class
		Method[] keywords = actionKeywords.getClass().getMethods();
		
		TCExcel.setExcel("input.xls", "testcases");
		TSExcel.setExcel("input.xls", "teststeps");
		// read data from test case excel
		for (int i = 1; i < TCExcel.rowCount(); i++) {
			String TCTestCaseName = TCExcel.readData(i, Constants.TC_TESTCASENAME);
			String runMode = TCExcel.readData(i, Constants.RUNMODE);
			// verify run mode
			if (runMode.equalsIgnoreCase("yes")) {
				System.out.println("Executing "+TCTestCaseName);
				for (int j = 1; j < TSExcel.rowCount(); j++) {
					String TSTestCaseName = TSExcel.readData(j, Constants.TS_TESTCASENAME);
					// compare test case names in test case document and test step document
					if (TCTestCaseName.equalsIgnoreCase(TSTestCaseName)) {
						String testStepName = TSExcel.readData(j, Constants.TESTSTEPNAME);
						String locType = TSExcel.readData(j, Constants.LOCTYPE);
						String locValue = TSExcel.readData(j, Constants.LOCVALUE);
						String keyword = TSExcel.readData(j, Constants.ACTION);
						String data = TSExcel.readData(j, Constants.INPUT);
						// for loop for methods array
						for (int m = 0; m < keywords.length; m++) {
							if (keywords[m].getName().equals(keyword)) {
								try {
									System.out.println("Executing " + testStepName);
									keywords[m].invoke(actionKeywords, locType, locValue, data);
									System.out.println(testStepName +" completed");
									break;
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
						}
					}
				}
				System.out.println(TCTestCaseName+" completed");
			}
		}
	}

}
