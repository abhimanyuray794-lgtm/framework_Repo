package abhi.vtiger.createorganization;

import org.testng.annotations.Test;

import abhi.generic.baseclassutility.BaseClassForAbhiTek;

public class CreateOrgTest extends BaseClassForAbhiTek{
 
	@Test(groups = "smokeTest")
	public void createOrganization() {
		System.out.println("method executed successfully!");
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println("hello");
	}
 
}
