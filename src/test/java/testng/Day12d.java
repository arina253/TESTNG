package testng;

import org.testng.annotations.Test;

public class Day12d {
	
	@Test(priority = 1)
    public void TestOne() {
		System.out.println("Test case one pass");
	}
	
	@Test (priority = 2)
	public void TestTwo() {
		System.out.println("Test case two pass");
	}
	
	@Test (priority =3, enabled = false)
	public void TestThree() {
		System.out.println("Test case three pass");
	}
}
