package com.vogella.maven.SynackTestCases;

import org.junit.Assert;
import org.junit.Test;
import com.vogella.maven.Synack.DisappearingElement;

public class DisappearingElementTest extends BaseClassTest {

	@Test
	public void disappearTest() {

		String page = "disappearing_elements";
		DisappearingElement disappear = new DisappearingElement();
		disappear.setBrowser();
		disappear.setUrl(page);
		String message = disappear.getDisappearElemnt();
		Assert.assertEquals("Gallery", message);
		disappear.exitBrowser();
	}
}