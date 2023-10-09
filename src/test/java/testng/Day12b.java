package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day12b {
	
	@Parameters ({"browser","username","password","dbadmin"})
	
	@Test
	public void TestcaseFour(String bw,String un, String pwd,String db) {
		System.out.println("Test case four pass");
		System.out.println(bw);
		System.out.println(un);
		System.out.println(pwd);
		System.out.println(db);
		
	}

	
	@Test
	public void TestcaseFive() {
		System.out.println("Test case five pass");
	}
	
	@Test
	public void TestcaseSix() {
		System.out.println("Test case six pass");
	}
	
	
	
}
