package utilities;

import java.io.IOException;

import org.testng.ITestListener;

import testcases.myfirstetstFW;

public class Listeners extends myfirstetstFW implements  ITestListener {
	
	
	
	public void OnTestFailure(ITestListener result) throws IOException
	{
		System.out.println("test case failed screenshot");
	
		getScreenshot();
	}
}
