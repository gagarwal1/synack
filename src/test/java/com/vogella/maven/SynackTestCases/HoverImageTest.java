package com.vogella.maven.SynackTestCases;

import org.junit.Assert;
import org.junit.Test;
import com.vogella.maven.Synack.HoverImage;

public class HoverImageTest extends BaseClassTest {

	@Test
	public void hoverTest() throws InterruptedException {
		String page = "hovers";
		String[] actualUsers = { "name: user1", "name: user2", "name: user3" };
		HoverImage hover = new HoverImage();
		hover.setBrowser();
		hover.setUrl(page);
		String[] info = hover.getHover();
		for (int i = 0; i < info.length; i++) {

			System.out.println(info[i]);
		}
		hover.exitBrowser();
		Assert.assertArrayEquals("equal", actualUsers, info);
	}
}