package com.vogella.maven.Synack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MessageNotification extends BaseClass {
// Note should have abstracted the locator out, so no duplicate locators are used
	public String getMessage() {
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Click')]"));
		link.click();
		WebElement element = clickAnElementByXpath("//div[@id='flash']");
		int index = element.getText().indexOf("l");
		String result = element.getText().substring(0, index + 1);
		boolean flag = false;

		while (!flag) {

			if (result.contains("Action unsuccesful")) {
				clickAnElementByXpath("//a[contains(text(),'Click')]");
				link = driver.findElement(By.xpath("//a[contains(text(),'Click')]"));
				link.click();
				WebElement element2 = driver.findElement(By.xpath("//div[@id='flash']"));
				result = element2.getText().substring(0, index + 1);
				if (result.equals("Action successful")) {
					result = element2.getText().substring(0, index + 1);
					break;
				}
			} else {
				flag = true;
			}
		}

		return result;
	}
}