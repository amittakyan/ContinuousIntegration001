package com.continuous.integration;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGSeleniumSimpleSearchExample {
	private WebDriver driver;

	@BeforeSuite
	public void initDriver() throws Exception {
		//DesiredCapabilities cap = DesiredCapabilities.firefox();
		//cap.setBrowserName("firefox");
		//cap.setCapability("marionette", true);
		
		System.out.println("You are testing in firefox");
		if(System.getProperty("os.name").contains("Windows")){
		System.out.println("You are testing in window machine");
		System.setProperty("webdriver.gecko.driver","C:\\FirFoxDriver\\geckodriver.exe");
		}else if (System.getProperty("os.name").contains("Linux")){
			System.out.println("You are testing in linux machine");
			//cap.setCapability("firefox_binary",
				       //new File("/usr/bin/firefox").
				        //      getAbsolutePath());
			//String marionetteDriverLocation = "/home/amit/bin/geckodriver"; 
			//System.out.println("Path---->"+new File("/home/amit/bin/geckodriver").getAbsolutePath());
			System.setProperty("webdriver.gecko.driver",new File("/home/amit/bin/geckodriver").getAbsolutePath());
		
		}
		  driver = new FirefoxDriver();
	}

	@Test
	public void searchTestNGInGoogle() {
		final String searchKey = "Miracle Software Systems";
		System.out.println("Search " + searchKey + " in google");
		driver.navigate().to("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		System.out.println("Enter " + searchKey);
		element.sendKeys(searchKey);
		System.out.println("submit");
		element.submit();
		(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase()
						.startsWith(searchKey.toLowerCase());
			}
		});
		System.out.println("Got " + searchKey + " results");
	}

	@AfterSuite
	public void quitDriver() throws Exception {
		driver.quit();
	}
}