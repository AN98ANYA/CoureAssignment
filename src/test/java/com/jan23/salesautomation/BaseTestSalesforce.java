package com.jan23.salesautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestSalesforce {
	static WebDriver driver=null; 
	
	public static void getUrl(String url) {
		driver.get(url);
}
	
	public static void getDriverInstances(String browserName) {
		switch(browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "safari":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		default: 
			System.out.println("not entered proper browser name");
		}
		
	}
	
	public static void loginCredentials(WebElement element, String text, String name) {
		if(element.isDisplayed()) { 
			element.clear();
			element.sendKeys(text);
		}
		else {
			System.out.println("the "+ name + " web element is not displayed");
		}
		driver.getTitle();
	}
	
	public static void clickMethod(WebElement clickAction) {
		clickAction.click();
	}
	public static void enterText(WebElement element, String textname, String name) {
		String expected = textname;
		String actual = element.getText();
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println(name+" script is passed");
		}
		else {
			System.out.println(name+" script is failed");
		}
	}
	public static String getTextFormWebElement(WebElement element, String name) {
		if(element.isDisplayed()) { 
			return element.getText();
		}
		else {
			System.out.println("the "+ name + " web element is not displayed");
			return null;
		}
	}
	public static void closeMethod(WebDriver obj) {
		obj.close();
	}
	public static void sleepMethod() throws InterruptedException {
		Thread.sleep(5000);
	}
	public static void selectMethod(WebElement element, String text) {
		Select ob = new Select(element);
		ob.selectByVisibleText(text);
	}
	public static void windowPopupHandle() throws InterruptedException {
		for(String winhandle: driver.getWindowHandles()) {
			driver.switchTo().window(winhandle);
			System.out.println("Window Switch");
			Thread.sleep(2000);
			
			driver.findElement(By.id("tryLexDialogX")).click();
		}
	}
	public static void fillformMethod(WebElement element, String name) {
		element.sendKeys(name);
	}

}
