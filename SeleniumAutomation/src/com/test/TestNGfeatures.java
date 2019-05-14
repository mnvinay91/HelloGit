package com.test;

import org.testng.annotations.Test;

public class TestNGfeatures 
{
	@Test
	public void LoginTest()
	{
		System.out.println("Login Test");
		//int i = 9/0;(exception--doesn't executes further remaining test cases)
	}
	
	@Test(dependsOnMethods="LoginTest")
	public void HomePageTest()
	{
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods="LoginTest")
	public void SearchPageTest()
	{
		System.out.println("Search Page Test");
	}
	
	@Test(dependsOnMethods="LoginTest")
	public void RegPageTest()
	{
		System.out.println("Reg Page Test");
	}
}
