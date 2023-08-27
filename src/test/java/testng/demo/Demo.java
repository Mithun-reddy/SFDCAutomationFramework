package testng.demo;

import java.util.NoSuchElementException;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class Demo extends BaseTest {
	
	
//	A-Z a-z

	@Test(dependsOnGroups = {"regression"}, groups = "sanity", alwaysRun = true)
	public void login1() {
		System.out.println("login 1 menu test");
	}
	
	@Test (groups = {"regression", "sanity"}, description = "This for login test nkjnfkjfnjkf")
	public void login2() {
		System.out.println("login 2 test.");
		throw new NoSuchElementException("skip");
	}
	
	@Test(groups = "regression", invocationTimeOut = 30000 )
	public void login3() throws InterruptedException {
		System.out.println("login 3 test.");
		Thread.sleep(1000);
//		throw new NoSuchElementException("skip");
	}
	
	
}
