package com.vogella.maven.SynackTestCases;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vogella.maven.Synack.DynamicContent;

public class DynamicContentTest extends BaseClassTest {
	
	DynamicContent dynamic = new DynamicContent();
	
	@Before
	public void setUp() {
		String page = "dynamic_content";
		dynamic.setBrowser();
		dynamic.setUrl(page);	
		
	}
	
	@Test
	public void dynamicImageTest() throws IOException, InterruptedException {
		
		File Psize = new File("//Users/gauravagarwal/workspace/Synack/pimage.jpg");
		String url ="https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-3.jpg";	
		Map<String,String> punisher = new HashMap<String,String>();
		punisher.put(url, Float.toString(Psize.length()));
		System.out.println("pun" + punisher);
		dynamic.setImages();
	     boolean result = dynamic.isImagePresent(punisher);
	     System.out.println("result" + result);
		 Assert.assertTrue(result);	
	}
	
	
	
	@After
	public void tearDown() {
		dynamic.exitBrowser();
	}
}
