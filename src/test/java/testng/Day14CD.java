package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14CD {
	
	//Circular dependency
	//A-->B-->C-->A
	
	@Test
	public void login() {
		System.out.println("Executing the login test case");
		Assert.assertEquals(true, true);
	}
	
	@Test(dependsOnMethods = "login")
	public void search() {
		System.out.println("Executing the search test case");
		Assert.assertEquals(false,true);
	}
	
	@Test (dependsOnMethods = {"login","search"})
	public void addToCart() {
		System.out.println("Adding to the cart testcase");
	}
	
}

/******************************************************************************/

//the dependsOnMethods attribute is used in TestNG to specify dependencies 
//between test methods. 
//SKIPPED: testng.Day14CD.addToCart -----If a test method that another method 
//depends on fails, the dependent method won't be executed.
//
