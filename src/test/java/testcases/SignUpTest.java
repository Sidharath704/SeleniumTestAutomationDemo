package testcases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;
import utilities.ReadXLSdata;

public class SignUpTest extends BaseTest {
	
	@Test(dataProvider="testdata")
	public static void LoginTest(String username , String password) throws InterruptedException, IOException {
		//signup 
		
		
		//screenshot code here
		 Date currentdate = new Date();
		 System.out.println(currentdate);
		String screenshotFileName =  currentdate.toString().replace(" ","-").replace(":","-");
		System.out.println(screenshotFileName);
		 
		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile,new File(".//screenshot//"+screenshotFileName+".png"));

		    driver.findElement(By.name(loc.getProperty("Email"))).clear();
	    driver.findElement(By.name(loc.getProperty("Email"))).sendKeys(username);
	    driver.findElement(By.name(loc.getProperty("Password"))).clear();
	    driver.findElement(By.name(loc.getProperty("Password"))).sendKeys(password);
	    Thread.sleep(4000);
	    driver.findElement(By.id(loc.getProperty("RememberMe"))).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath(loc.getProperty("login"))).click();

	    Thread.sleep(4000);
	
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] tdata()
	{
		return new Object[][] 
	    {
			{"admin@yourstoredf.com","adminefe"},
			{"admin@yourstoredfef.com","adminff"},
			{"admin@yourstorefef.com","adminff"},
			{"admin@yourstore.com","admin"}
		};
		
		
	}

}
