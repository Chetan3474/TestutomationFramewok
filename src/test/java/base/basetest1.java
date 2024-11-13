package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest1 {
	public static WebDriver driver;
	public static Properties pr = new Properties();
	public static Properties loc = new Properties();

	public static FileReader fr;
	public static FileReader fr1;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {

		Thread.sleep(3000);
		if (driver == null) {
//for config file			
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			pr.load(fr);
				
//for locators			
			FileReader frl = new FileReader(System.getProperty(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties"));
			Properties loc = new Properties();
			loc.load(frl);
			
		}
		
		//setup of browsers	
		if (pr.getProperty("browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();		//base
			driver = new EdgeDriver();
			Thread.sleep(3000);
			driver.get(pr.getProperty("testurl"));	//properties
			
		}

		else if (pr.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();		//base
			driver = new ChromeDriver();
			Thread.sleep(3000);
			driver.get(pr.getProperty("testurl"));		//properties	
		}

	}

	@AfterMethod
	public void teardown() {
		//driver.close();
		System.out.println("teardow sucesfull");
	}


}
