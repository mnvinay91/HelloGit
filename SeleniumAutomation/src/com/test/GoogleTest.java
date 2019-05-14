package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("http://www.google.co.in");
	}
	
	@Test(priority=1, groups = "Title")
	public void GoogleTitleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=2, groups = "Logo")
	public void GoogleLogoTest()
	{
		boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println(b);
	}
	
	@Test(priority=3,groups = "Link")
	public void MailLinkTest()
	{
		boolean b1 = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(b1);
	}
	
	@Test(priority=4, groups = "Test")
	public void Test1()
	{
		System.out.println("Test1");
	}
	
	@Test(priority=5, groups = "Test")
	public void Test2()
	{
		System.out.println("Test2");
	}
	
	@Test(priority=6, groups = "Test")
	public void Test3()
	{
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void teardown()
	{
	driver.quit();	
	}
	

}
