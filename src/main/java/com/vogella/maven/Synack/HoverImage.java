package com.vogella.maven.Synack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverImage extends BaseClass {

	public String[] getHover() {

		String[] userInfo = new String[3];
		System.out.println(driver.findElement(By.xpath("//img[@alt=\"User Avatar\"]")).getText());
		List<WebElement> imgs = driver.findElements(By.xpath("//div[@class=\"figure\"]"));

		for (int i = 0; i < imgs.size(); i++) {
			Actions imageElement = new Actions(driver);
			imageElement.moveToElement(imgs.get(i)).click().perform();
			String userElement = imgs.get(i).toString();
			int Info = userElement.indexOf("//div");
			String tmp = userElement.substring(Info, userElement.length() - 1);
			List<WebElement> user = driver.findElements(By.xpath(tmp + "//div//h5"));
			userInfo[i] = user.get(i).getText();
		}
		return userInfo;
	}
}