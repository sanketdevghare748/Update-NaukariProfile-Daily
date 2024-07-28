package Reports;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
	public  static ExtentReports extent;
	public  static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "//Reports//report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sanket Devghare");


		return extent;
	}

}
