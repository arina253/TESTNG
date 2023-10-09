package testng;

import org.testng.annotations.Test;

public class Day13b {
	
	@Test(groups = {"login"})
	public void testCase4() {
		System.out.println("login test case one ");
	}
	
	@Test(groups = {"regression"})
	public void testCase5() {
		System.out.println("regression 2");
	}
	
	@Test (groups = {"login"})
	public void testCase6() {
		System.out.println("login test case two");
	}

}
