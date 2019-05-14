package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	//pre-requisite annotations -- starting with @Before
	@BeforeSuite
	public void setUp()
	{
     System.out.println("@BeforeSuite--setup system property for chrome");
	}
	
	@BeforeTest
	public void login()
	{
	System.out.println("@BeforeTest--login to app");
    }
	
	@BeforeClass
	public void launchBrowser()
	{
	System.out.println("@BeforeClass--launch chrome browser");
	}
	
	@BeforeMethod
	public void enterURL()
	{
	System.out.println("@BeforeMethod--enter URL");
    }
	
	//test case -- starting with @Test
	@Test
	public void googleTitleTest()
	{
	System.out.println("@Test--Google Title Test");
	}
	
	@Test
	public void googleLogoTest()
	{
	System.out.println("@Test--Google logo Test");
	}
	
	@Test
	public void SearchTest()
	{
	System.out.println("@Test--Google search Test");
	}
	
	@AfterMethod
	public void logOut()
	{
	System.out.println("@AfterMethod--logout from app");
	}
	
	@AfterClass
	public void closeBrowser()
	{
	System.out.println("@AfterClass--close browser");
	}
	
	//post conditions -- starting with @After
	@AfterTest
	public void deleteAllCookies()
	{
	System.out.println("@AfterTest--delete All Cookies");
	}

	@AfterSuite
	public void generateTestReport()
	{
     System.out.println("@AfterSuite--generate Test Report");
	}
}

//@BeforeSuite--setup system property for chrome--I
//@BeforeTest--login to app -- II
//@BeforeClass--launch chrome browser -- III

//@BeforeMethod--enter URL
//@Test--Google search Test
//@AfterMethod--logout from app

//@BeforeMethod--enter URL
//@Test--Google logo Test
//@AfterMethod--logout from app

//@BeforeMethod--enter URL
//@Test--Google Title Test
//@AfterMethod--logout from app

//@AfterClass--close browser
//@AfterTest--delete All Cookies
//PASSED: SearchTest
//PASSED: googleLogoTest
//PASSED: googleTitleTest
