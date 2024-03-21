package Testing;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test1 {
	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter extentRep;
	ExtentTest testCase;
	String ExpectedText ="Hello vasu.vespag!";
	
	@Test
	private void verifyUrl() {
		testCase = extent.createTest("Validate Greeting");
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys("vasuvespag");
		driver.findElement(By.id("password")).sendKeys("vasu1234");
		driver.findElement(By.id("login")).click();
		String greeting = driver.findElement(By.id("username_show")).getAttribute("value");
		System.out.println("I am going to check the greeting message");
		if(greeting.equalsIgnoreCase(ExpectedText)) {
			testCase.log(Status.PASS,"Actual Greeting!");
		}
		else {
			testCase.log(Status.FAIL,"Not Actual Greeting!");
		}
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:\\Users\\PATNAN\\Desktop\\sdoc\\extScreenshot.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		@BeforeSuite
		public void extentLaunch() {

		extent = new ExtentReports();
		extentRep = new ExtentSparkReporter("target/extHtml.html");
		extent.attachReporter(extentRep);
		
	}
		@AfterSuite
		public void finOper() {
			testCase.addScreenCaptureFromPath("C:\\Users\\PATNAN\\Desktop\\sdoc\\extScreenshot.png");
			driver.quit();
			extent.flush();
			
		}

}















