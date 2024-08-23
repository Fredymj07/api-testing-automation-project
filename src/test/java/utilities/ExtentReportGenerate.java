package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportGenerate {

    static ExtentReports extent = new ExtentReports();
    static ExtentSparkReporter reporter;
    static ExtentTest test;

    private static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @BeforeTest
    public void generateReport(String apiName) {
        String path = "./sparkreporter/extent-report" + " " + getDateTime() + ".html";
        reporter = new ExtentSparkReporter(path);
        extent.attachReporter(reporter);
        test = extent.createTest("Prueba de api " + apiName);
    }

    @AfterTest
    public void closeConnectionExtent(int apiStatus) {
        if (apiStatus == 200) {
            test.log(Status.PASS, "El test resultó Exitoso!");
        } else {
            test.log(Status.FAIL, "El test resultó Fallido!");
        }
        extent.flush();
    }

    public void logMessages (String message) {
        test.log(Status.INFO, message);
    }
}
