package com.vogella.maven.SynackTestCases;

import org.junit.Test;
import com.vogella.maven.Synack.LoginPage;
import junit.framework.Assert;

public class LoginTest extends BaseClassTest {

	@SuppressWarnings("deprecation")
	@Test
	public void LoginTest() {
		String page = "login ";
		String username = "gaurav";
		String password = "test1";
		LoginPage login = new LoginPage();
		login.setBrowser();
		login.setUrl(page);
		boolean message = login.getMessage(username, password);
		Assert.assertTrue("the user is invalid", message);
		login.exitBrowser();
	}
}