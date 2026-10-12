package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {

    public static ExtentReports extent;
    public static ExtentReports getReport() {

        if (extent == null) {
        	ExtentSparkReporter spark =new ExtentSparkReporter("Reports/ExtentReport.html");
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Cucumber Execution");
            extent = new ExtentReports();
            extent.attachReporter(spark);     //Connection is established.
        }
        return extent;
    }
}



