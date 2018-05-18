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
    // should have abstracted the locators in seperate file to avoid duplicate
public class DynamicContent extends BaseClass {

	Map<String, String> avatarFilesizes = new HashMap<String, String>();

	public void setImages() throws IOException {
		clickAnElementByXpath("//div[@class='large-2 columns']/img");
		List<WebElement> avatars = driver.findElements(By.xpath("//div[@class='large-2 columns']/img"));
		for (int i = 0; i < avatars.size(); i++) {
			String url = avatars.get(i).getAttribute("src").toString();
			System.out.println("set images" + url);
			URL website = new URL(url);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(i + "information.html");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			File f = new File(i + "information.html");
			avatarFilesizes.put(url, Float.toString(f.length()));
		}
	}

	public boolean isImagePresent(Map<String, String> punish) throws IOException, InterruptedException {
		System.out.println("punish me" + punish);
		Set<String> myUrl = avatarFilesizes.keySet();
		for (String url : myUrl) {

			if (!avatarFilesizes.get(url).equals(punish.get(url))) {
				System.out.println("Not matching");
				continue;
			}

			else {

				System.out.println("Maching Values");
				return true;
			}
		}
		clickAnElementByXpath("//a[contains(text(),'click')]");
		driver.findElement(By.xpath("//a[contains(text(),'click')]")).click();
		clickAnElementByXpath("//div[@class='large-2 columns']/img");
		this.setImages();
		return this.isImagePresent(punish);
	}
}