package com.vogella.maven.Synack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class BaseClass {

	WebDriver driver;
	String usrDir = System.getProperty("user.dir");
	String operating = System.getProperty("os.name");
	String url = "https://the-internet.herokuapp.com/";

	public void setBrowser() {

		if (operating.toLowerCase().contains("mac")) {
			System.setProperty("webdriver.firefox.marionette", usrDir + "/geckodriver");
		} else {
			System.setProperty("webdriver.firefox.marionette", usrDir + "\\geckodriver");
		}
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, myprofile);
		dc.setCapability("marionette", true);
		driver = new FirefoxDriver();
	}

	public WebElement clickAnElementByXpath(String linkText) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((linkText))));
		return element;
	}

	public void setUrl(String page) {
		url = url + page;
		driver.get(url);
	}

	public void exitBrowser() {
		driver.quit();
	}
}