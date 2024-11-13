package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.basetest1;
import utilities.ReadExcelData;

public class myfirstetstFW extends basetest1 {

	@Test(dataProviderClass=ReadExcelData.class ,dataProvider="amzdata")
	public static void loginTest(String username,String password) throws InterruptedException {

		Thread.sleep(5000);
	
		driver.findElement(By.xpath(loc.getProperty("Dismiss_popup"))).click();
		driver.findElement(By.xpath(loc.getProperty("sign_in_click"))).click();
		driver.findElement(By.id(loc.getProperty("email"))).sendKeys(username);		//username just for dataprovider	
		driver.findElement(By.id(loc.getProperty("continue_button"))).click();
		driver.findElement(By.id(loc.getProperty("pswd"))).sendKeys(password);		//password just for data provider
		driver.findElement(By.id(loc.getProperty("submit"))).click();

		
	/*	driver.findElement(By.xpath("//span[@class=\"a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Hello, sign in\"]")).click();
		driver.findElement(By.id("ap_email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.id("auth-signin-button")).click();
		*/
	}
	
	/*@DataProvider(name="amzdata")		//we dont need any dataprovider here as we provide data by excel sheet , here it was just for testing purpose
	public Object[][] tdata()
	{
		
		Object[][]test={ { "sdbWJEDGdug@gmail.com" ,"78676464" },{"chetanpatil93pc@gmail.com","7887603474"}};
		
		return test;
		
	}*/  
	
	//failed screnshot

    @Test
    public void getScreenshot() throws IOException {
  
     try {        
            Assert.assertEquals(driver.getTitle(), "fsssWEFWRWEhrsWEgtWR"); // Example assertion
       }
       catch(AssertionError e)
        {captureScreenshot("testMethod");
       throw e;
       }
    }

    private void captureScreenshot(String testName) throws IOException {
    	
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);      
                FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\eclipse-workspace\\TestutomationFramewok\\src\\test\\java\\utilities\\failed44" + testName + ".png"));    
   
    }

}
