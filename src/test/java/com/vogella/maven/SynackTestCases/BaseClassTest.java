package com.vogella.maven.SynackTestCases;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import junit.framework.Assert;

public class BaseClassTest {
	WebDriver driver;
	String usrDir = System.getProperty("user.dir");
	String operating = System.getProperty("os.name");

	@Before
	public void setUp() throws InterruptedException {

	}

	@After
	public void tearDown() {

	}
}