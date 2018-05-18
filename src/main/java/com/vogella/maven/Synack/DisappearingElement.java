package com.vogella.maven.Synack;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DisappearingElement extends BaseClass {

	public String getDisappearElemnt() {
		List<WebElement> tabs = driver.findElements(By.tagName("li"));
		while (tabs.size() != 5) {
			driver.navigate().refresh();
			tabs = driver.findElements(By.tagName("li"));
		}
		return tabs.get(4).getText();
	}
}