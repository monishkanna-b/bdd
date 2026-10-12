package utilities;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtility {

    public static Recordset readDataFromExcel(String sheetName, String scenarioName) throws Exception {

       System.out.println("Sheet Name -> " + sheetName+ " Scenario -> " + scenarioName);
       Recordset objRS = null;
       Connection objConnection = null;

        try {
        	Fillo objFillo = new Fillo();
        	objConnection = objFillo.getConnection(GlobalVariable.AUT_TESTDATASHEET);

            String strQuery =
                    "Select * from "
                    + sheetName
                    + " where RunMode='Y'"
                    + " and TestCaseId='"
                    + scenarioName
                    + "'";

            System.out.println("ReadDataFromExcel -> " + strQuery);
            objRS = objConnection.executeQuery(strQuery);
            if (!objRS.next()) {
            	throw new RuntimeException("No Excel data found for scenario: " + scenarioName);
            }

            System.out.println("Excel data fetched successfully");
            return objRS;
        	} 
        
        catch (Exception exception) {
        	System.out.println("Error occurred while reading Excel: "+ exception.getMessage());
        	throw exception;
        }
    }
}