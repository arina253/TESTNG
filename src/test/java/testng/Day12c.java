package testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day12c {
	
	//If we are not sending parameter via xml but still test case is expecting
	//parameter,then we use optional parameter.
	
	@Parameters({"browser"})

	@Test
	public void TestcaseFour(@Optional("chromeC")String bw) {
		System.out.println(bw);
	}
	
}
