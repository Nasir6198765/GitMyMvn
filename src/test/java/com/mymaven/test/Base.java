package com.mymaven.test;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;
	Logger log;
	Properties prop;

	@BeforeSuite
	public void configureStart() {
		log = LogManager.getLogger(Base.class.getName());
	}

	@BeforeMethod
	public void setupBrowser() throws IOException {
		log.info("setupBrowser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Chrome launched");
		driver.manage().window().maximize();
		log.info("Maximized window");
		driver.get("http://tutorialsninja.com/demo/");
		log.info("Navigated on URL");

	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
		log.info("quitBrowser");

	}

}
