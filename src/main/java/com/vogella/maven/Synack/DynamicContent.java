package com.vogella.maven.Synack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicContent extends BaseClass {
	
	Map<String,String> avatarFilesizes = new HashMap<String,String>();

	private void setImages() throws IOException {
		
		List<WebElement> avatars = driver.findElements(By.xpath("//div[@class='large-2 columns']/img"));	
		for(int i= 0; i< avatars.size(); i++) {
			 String url = avatars.get(i).getAttribute("src").toString(); 
			 System.out.println("please print" + url);
			 URL website = new URL(url);
			 ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			 FileOutputStream fos = new FileOutputStream(i+"information.html");
			 fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			 File f = new File(i+"information.html");
	    	 avatarFilesizes.put(url, Float.toString(f.length()));	 
	    	 
	    	 
		}
		
		
		System.out.println(avatarFilesizes);
	
		
	}

	public boolean isImagePresent(Map<String, String> punisher) throws IOException {
		
			setImages();
			
			Set<String> myUrl = avatarFilesizes.keySet();
			for(String url:myUrl) {
				
				System.out.println(avatarFilesizes.get(url));
				
				if(!avatarFilesizes.get(url).equals(punisher.get(url))){
					
					
					
					System.out.println(avatarFilesizes.get(url) +" Not Maching Values   " + punisher.get(url));
					driver.findElement(By.xpath("//a[contains(text(),'click')]")).click();
					clickAnElementByXpath("//div[@class='large-2 columns']/img");
					avatarFilesizes.clear();
					setImages();
					
				}
				
				else {
					
					System.out.println("Maching Values");
					return true;
					
					
				}
				
				
			}
			return false;
		
	}
}
