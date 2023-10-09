package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day3 {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This runs before every method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This runs after every method");
	}
	
	@Test(priority = 1)
	public void test1() {
		System.out.println("This is test case with priority 1");
	}
	
	@Test (priority = 2)
	public void test2() {
		System.out.println("This is test case with priority 2");
	}
	
	@Test (priority = 3)
	public void test3() {
		System.out.println("This is test case with priority 3");
	}
	

}
