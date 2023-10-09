package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day12a {
	
	@Parameters ({"browser","username","password"})
	
	@Test
	public void TestcaseOne(String bw,String un, String pw) {
		System.out.println("Test case one pass");
		System.out.println(bw);
		System.out.println(un);
		System.out.println(pw);
	}
	
	@Test
	public void TestcaseTwo() {
		System.out.println("Test case two pass");
	}
	
	@Test
	public void TestcaseThree() {
		System.out.println("Test case three pass");
	}

}
