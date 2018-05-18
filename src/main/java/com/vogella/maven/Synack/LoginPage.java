package com.vogella.maven.Synack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page for user login
 *
 */
public class LoginPage extends BaseClass {

	public boolean getMessage(String username, String password) {

		WebElement user = driver.findElement(By.id("username"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement Login = driver.findElement(By.className("radius"));
		user.sendKeys(username);
		pass.sendKeys(password);
		Login.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));
		int index = element.getText().indexOf("!");
		if (element.getText().substring(0, index + 1).equals("Your username is invalid!")) {

			return true;
		}
		return false;
	}
}