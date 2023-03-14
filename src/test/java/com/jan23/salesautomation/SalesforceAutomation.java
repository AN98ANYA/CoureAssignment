package com.jan23.salesautomation;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceAutomation extends BaseTestSalesforce{
	
	public static void TC01_errorLoginSalesforceOne() throws InterruptedException {
		String expected = "Please enter your password.";
		
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@gtekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement textElement = driver.findElement(By.id("error"));
		String actual = getTextFormWebElement(textElement, "Please enter your password.");
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Error_Login_Salesforce_One script is passed");
		}
		else {
			System.out.println("Error_Login_Salesforce_One script is failed");
		}
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC02_successLoginSalesforce() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	
	public static void TC03_rememberMeLoginSalesforce() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement rememberme = driver.findElement(By.id("rememberUn"));
		clickMethod(rememberme);
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC04_A_forgotYourPasswordLoginSalesforce() throws InterruptedException {    //pending
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@gmail.com", "usernameEle");
		
		WebElement forgotPassword = driver.findElement(By.id("forgot_password_link"));
		clickMethod(forgotPassword);
		
		WebElement forgotUsername = driver.findElement(By.id("un"));
		forgotUsername.sendKeys("zarajoshi@tekarch.com");
		
		WebElement forgotContinue = driver.findElement(By.id("continue"));
		clickMethod(forgotContinue);
		
		driver.get("https://gmail.com/");
		
		WebElement email = driver.findElement(By.id("identifierId"));
		email.sendKeys("ananya.iyer1106@gmail.com");
		
		WebElement nextemail = driver.findElement(By.id("identifierNext"));
		nextemail.click();
		
		WebElement passwrd = driver.findElement(By.xpath("password"));
		passwrd.sendKeys("ananya98");
		
		WebElement nextpasswrd = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button"));
		nextpasswrd.click();
		
		List<WebElement> unreademail = driver.findElements(By.className("J-N-Jz"));
		System.out.println("Total No. of Unread Mails: " + unreademail.size());
		
		for(int i=0;i<unreademail.size();i++) {

			System.out.println(unreademail.get(i).getText());

			}

			unreademail.get(0).click();

			Thread.sleep(3000);

			driver.close();

	}
	public static void TC04_B_errorLoginSalesforceTwo() {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "123", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement textElement = driver.findElement(By.id("error"));
		String actual = getTextFormWebElement(textElement, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("errorLoginSalesforceTwo script is passed");
		}
		else {
			System.out.println("errorLoginSalesforceTwo script is failed");
		}
		closeMethod(driver);
	}
	public static void TC05_User_Menu_Dropdown() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement usernameBut = driver.findElement(By.id("userNavButton"));
		clickMethod(usernameBut);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC06_User_Menu_Dropdown_My_Profile() throws InterruptedException {     //doubt
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement usernameBut = driver.findElement(By.id("userNavButton"));
		clickMethod(usernameBut);
		
		WebElement myProfile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		clickMethod(myProfile);
		
		sleepMethod();
		
		WebElement editProfile = driver.findElement(By.xpath("//a[@href='javascript:void(0);' and @class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		clickMethod(editProfile);
		
		sleepMethod();
		
		WebElement frame1 = driver.findElement(By.id("contactInfoContentId"));
		driver.switchTo().frame(frame1);
		
		WebElement about = driver.findElement(By.partialLinkText("About"));
		about.click();
		
		
		WebElement lastname = driver.findElement(By.id("lastName"));
		if(lastname.isDisplayed()) { 
			lastname.clear();
			lastname.sendKeys("josh");
		}
		else {
			System.out.println("web element is not displayed");
		}
		
		WebElement saveAll = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		clickMethod(saveAll);
		
		sleepMethod();
		
		WebElement postLink = driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]"));
		clickMethod(postLink);
		
//		WebElement frame2 = driver.findElement(By.xpath("//*[@id=\"cke_43_contents\"]/iframe"));
//		driver.switchTo().frame(frame2);
		
		WebElement textarea = driver.findElement(By.xpath("//[@class='chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders placeholder' and @contenteditable='true']"));
		fillformMethod(textarea, "text");
		
		WebElement shareBut = driver.findElement(By.id("publishersharebutton"));
		clickMethod(shareBut);
		
		sleepMethod();
		
		closeMethod(driver);
	}

	public static void TC07_User_Menu_Dropdown_My_Settings() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement usernameBut = driver.findElement(By.id("userNavButton"));
		clickMethod(usernameBut);
		
		WebElement mySetttings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		clickMethod(mySetttings);
		
		sleepMethod();
		
		WebElement personal = driver.findElement(By.linkText("Personal"));
		clickMethod(personal);
		
		WebElement loginHistory = driver.findElement(By.id("LoginHistory_font"));
		clickMethod(loginHistory);
		
//		WebElement download = driver.findElement(By.linkText("Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »"));
//		clickMethod(download)
		
		WebElement displayAndlayout = driver.findElement(By.id("DisplayAndLayout_font"));
		clickMethod(displayAndlayout);
		
		WebElement customizeMyTabs = driver.findElement(By.id("CustomizeTabs_font"));
		clickMethod(customizeMyTabs);
		
		WebElement customAppDropdown = driver.findElement(By.id("p4"));
		selectMethod(customAppDropdown, "Salesforce Chatter");
		
		//every time change in UI:
		WebElement AvailableTabsDropdown = driver.findElement(By.id("duel_select_0"));
		selectMethod(AvailableTabsDropdown, "Reports");
		
		WebElement add = driver.findElement(By.id("duel_select_0_right"));
		clickMethod(add);
		
		WebElement email = driver.findElement(By.id("EmailSetup_font"));
		clickMethod(email);
		
		WebElement myEmailSetting = driver.findElement(By.id("EmailSettings_font"));
		clickMethod(myEmailSetting);
		
		WebElement emailNameLabel = driver.findElement(By.id("sender_name"));
		loginCredentials(emailNameLabel, "zara joshi", "emailNameLabelEle");
		
		WebElement emailAddress = driver.findElement(By.id("sender_email"));
		loginCredentials(emailAddress, "ananya.iyer98@gmail.com", "emailAddressEle");
		
		WebElement autoBccYes = driver.findElement(By.id("auto_bcc1"));
		clickMethod(autoBccYes);
		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		clickMethod(save);
		
		WebElement calAndRem = driver.findElement(By.id("CalendarAndReminders_font"));
		clickMethod(calAndRem);
		
		WebElement activityRem = driver.findElement(By.id("Reminders_font"));
		clickMethod(activityRem);
		
		WebElement testRem = driver.findElement(By.id("testbtn"));
		clickMethod(testRem);
		
		sleepMethod();
		
		driver.quit();
	}
	public static void TC08_User_Menu_Dropdown_Developers_Connsole() throws InterruptedException {     
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");;
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement usernameBut = driver.findElement(By.id("userNavButton"));
		clickMethod(usernameBut);
		
		WebElement developerConsole = driver.findElement(By.xpath("//div[@id=\"userNav-menuItems\"]/a[3]"));   
		clickMethod(developerConsole);
		
		String baseHandle = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles();
		for(String handle: handles) {
			if(!baseHandle.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		sleepMethod();
		String expected = "Developer Console";
		if(driver.getTitle().equalsIgnoreCase(expected)) {
			System.out.println("testcase passed");
		}
		else {
			System.out.println("testcase failed");
		}
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC09_User_Menu_Dropdown_Logout() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "paswordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement usernameBut = driver.findElement(By.id("userNavButton"));
		clickMethod(usernameBut);
		
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		clickMethod(logout);
		
		sleepMethod();
		
		driver.close();
	}
	public static void TC10_Account_Tab() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement accountTab = driver.findElement(By.id("Account_Tab"));
		clickMethod(accountTab);
		
		windowPopupHandle();
		
		WebElement newKey = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		clickMethod(newKey);
		
		WebElement accName = driver.findElement(By.id("acc2"));
		fillformMethod(accName, "sahana");
		
		WebElement typeDropdown = driver.findElement(By.id("acc6"));
		selectMethod(typeDropdown, "Technology Partner");
		
		WebElement customerPriorityDropdown = driver.findElement(By.id("00NDn00000SkWBF"));
		selectMethod(customerPriorityDropdown, "High");
		
		WebElement saveAcc = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		clickMethod(saveAcc);
		
		sleepMethod();
		
		closeMethod(driver);
		
	}
	public static void TC11_Create_New_View() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement accountTab = driver.findElement(By.id("Account_Tab"));
		clickMethod(accountTab);
		
		windowPopupHandle();
		
		WebElement createNewView = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a"));
		clickMethod(createNewView);
		
		WebElement viewName = driver.findElement(By.id("fname"));
		fillformMethod(viewName, "viewing");
		
		sleepMethod();
		
		WebElement saveView = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		clickMethod(saveView);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC12_Edit_View() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement accountTab = driver.findElement(By.id("Account_Tab"));
		clickMethod(accountTab);
		
		windowPopupHandle();
		
		WebElement viewSubTab = driver.findElement(By.id("fcf"));
		selectMethod(viewSubTab, "viewing");
		
		WebElement viewGo = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		clickMethod(viewGo);
		
		WebElement editView = driver.findElement(By.linkText("Edit"));
		clickMethod(editView);
		
		WebElement editViewName = driver.findElement(By.id("fname"));
		fillformMethod(editViewName, "new viewing");
		
		sleepMethod();
		
		WebElement editSave = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		clickMethod(editSave);
		
		sleepMethod();
		
		closeMethod(driver);
		
	}
	public static void TC13_Merge_Accounts() throws InterruptedException {   //create few account
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement accountTab = driver.findElement(By.id("Account_Tab"));
		clickMethod(accountTab);
		
		windowPopupHandle();
		
		WebElement mergeAccountsLink = driver.findElement(By.linkText("Merge Accounts"));
		clickMethod(mergeAccountsLink);
		
		WebElement searchTab = driver.findElement(By.id("srch"));
		fillformMethod(searchTab, "sh");
		
		WebElement findAccountsBut = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
		clickMethod(findAccountsBut);
		
		WebElement nextAccountBut = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]"));
		clickMethod(nextAccountBut);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,260)", "");
		
		WebElement alertMergerAccoutTab = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[2]"));
		clickMethod(alertMergerAccoutTab);
		
		Alert alert = driver.switchTo().alert();
		sleepMethod();
		alert.accept();
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC14_Create_Account_Report() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement accountTab = driver.findElement(By.id("Account_Tab"));
		clickMethod(accountTab);
		
		windowPopupHandle();
		
		WebElement accountsWithLast30Days = driver.findElement(By.linkText("Accounts with last activity > 30 days"));
		clickMethod(accountsWithLast30Days);
		
		//from date
		WebElement fromDatePicker = driver.findElement(By.id("ext-gen152"));
		clickMethod(fromDatePicker);
		System.out.println("fromDatePickercheck");
		Thread.sleep(3000);
		
	    WebElement fdate = driver.findElement(By.xpath("//*[@id=\"ext-comp-1111\"]/tbody/tr[2]/td[2]/em/button"));
	    clickMethod(fdate);
	    System.out.println("fdatecheck");
	    Thread.sleep(3000);
	    
	    //to date
	    WebElement toDatePicker = driver.findElement(By.id("ext-gen154"));
	    clickMethod(toDatePicker);
		System.out.println("toDatePickercheck");
		Thread.sleep(3000);
	    
	    WebElement todate = driver.findElement(By.xpath("//*[@id=\"ext-comp-1113\"]/tbody/tr[2]/td[2]/em/button"));
	    clickMethod(todate);
	    System.out.println("todatecheck");
	    Thread.sleep(3000);
	    
	    WebElement saveReport = driver.findElement(By.id("ext-gen49"));
	    clickMethod(saveReport);
	    Thread.sleep(2000);
	    
	    WebElement reportName = driver.findElement(By.id("saveReportDlg_reportNameField"));
	    fillformMethod(reportName, "welcome");
	    sleepMethod();
	    
	    new Actions(driver).sendKeys(Keys.TAB).perform();
	    
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    WebElement saveAndReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dlgSaveAndRun\"]/tbody/tr[2]/td[2]/em/button")));
	    clickMethod(saveAndReport);
	    System.out.println("saveAndReportcheck");
	    
	    sleepMethod();
	    
		closeMethod(driver);
	}
	public static void TC15_Opportunities_Dropdown() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		clickMethod(opportunities);
		
		windowPopupHandle();
		
		WebElement viewDropdown = driver.findElement(By.id("fcf"));
		clickMethod(viewDropdown);
		
		String viewMenuDropdown = driver.findElement(By.id("fcf")).getText();
		System.out.println("View opptions: "+'\n'+viewMenuDropdown);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC16_Create_New_Opty() throws InterruptedException {     
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameELe");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		clickMethod(opportunities);
		
		windowPopupHandle();
		
		WebElement newOpp = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		clickMethod(newOpp);
		
		WebElement oppName = driver.findElement(By.id("opp3"));
		fillformMethod(oppName, "sara");
		
		WebElement accName = driver.findElement(By.id("opp4"));
		fillformMethod(accName, "Global Media");
		
		sleepMethod();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
	    WebElement accNameFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='shaha']")));
	    accNameFrame.click();
		System.out.println("accNameframecheck");
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC17_Test_Opportunity_Pinpeline_Report() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		clickMethod(opportunities);
		
		windowPopupHandle();
		
		WebElement oppPipeline = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
		clickMethod(oppPipeline);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC18_Test_Struck_Opportunities_Report() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		clickMethod(opportunities);
		
		windowPopupHandle();
		
		WebElement struckOpp = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		clickMethod(struckOpp);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC19_Test_Quarterly_Summary_Report() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		clickMethod(opportunities);
		
		windowPopupHandle();
		
		WebElement quarterlySummaryIntervalDropdown = driver.findElement(By.id("quarter_q"));
		selectMethod(quarterlySummaryIntervalDropdown, "Current and Next FQ");
		
		WebElement quarterlySummaryIncludeDropdown = driver.findElement(By.id("open"));
		selectMethod(quarterlySummaryIncludeDropdown, "Open Opportunities");
		
		WebElement runReportBut = driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
		clickMethod(runReportBut);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC20_Check_Leads_Tab_Link() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement leadsTab = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		clickMethod(leadsTab);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC21_Validate_View_Dropdown_List_Contents() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement leadsTab = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		clickMethod(leadsTab);
		
		windowPopupHandle();
		
		WebElement viewLead = driver.findElement(By.id("fcf"));
		clickMethod(viewLead);
		
		String viewL = driver.findElement(By.id("fcf")).getText();
		System.out.println("View options:"+'\n' +viewL);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC22_Functionality_Of_The_Go_Button() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement leadsTab = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		clickMethod(leadsTab);
		
		windowPopupHandle();
		
		WebElement viewOppDropdown = driver.findElement(By.id("fcf"));
		selectMethod(viewOppDropdown, "Today's Leads");
		sleepMethod();
		
		WebElement usernameLead = driver.findElement(By.id("userNavButton"));
		clickMethod(usernameLead);
		
		WebElement logoutLead = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		clickMethod(logoutLead);
		sleepMethod();
		
		WebElement unameAgain = driver.findElement(By.id("username"));
		loginCredentials(unameAgain, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement passAgain = driver.findElement(By.id("password"));
		loginCredentials(passAgain, "Welcome@321", "passwordEle");
		
		WebElement loginAgain = driver.findElement(By.id("Login"));
		clickMethod(loginAgain);
		
		WebElement leadsTabAgain = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		clickMethod(leadsTabAgain);
		
		WebElement goLead = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		clickMethod(goLead);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC23_List_Item_Todays_Leads_Work() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement leadsTab = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		clickMethod(leadsTab);
		
		windowPopupHandle();
		
		WebElement viewOppDropdown = driver.findElement(By.id("fcf"));
		selectMethod(viewOppDropdown, "Today's Leads");
		sleepMethod();
		
		WebElement goLead = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		clickMethod(goLead);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC24_Check_New_Button_On_Leads_Home() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement leadsTab = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		clickMethod(leadsTab);
		
		windowPopupHandle();
		
		WebElement newLead = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		clickMethod(newLead);
		
		WebElement lastnameLead = driver.findElement(By.id("name_lastlea2"));
		fillformMethod(lastnameLead, "ABCD");
		
		WebElement companyLead = driver.findElement(By.id("lea3"));
		fillformMethod(companyLead, "ABCD");
		
		WebElement saveLead = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		clickMethod(saveLead);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC25_Create_New_Contact() throws InterruptedException {   //frame???
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement contactTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		clickMethod(contactTab);
		
		windowPopupHandle();
		
		WebElement newContactBut = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		clickMethod(newContactBut);
		
		WebElement lastnameContact = driver.findElement(By.id("name_lastcon2"));
		fillformMethod(lastnameContact, "james");
		
		WebElement accNameContactMag = driver.findElement(By.id("con4_lkwgt"));
		clickMethod(accNameContactMag);
		
		WebElement frame2 = driver.findElement(By.id("resultsFrame"));          // frame????
		driver.switchTo().frame(frame2);
		System.out.println("frame1check");
		Thread.sleep(5000);
		
		WebElement accNameContact = driver.findElement(By.xpath("//*[@id=\"new\"]/div/div[2]/div/div[2]/table/tbody/tr[3]/th/a"));
		clickMethod(accNameContact);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC26_Create_New_View_In_The_Contact_Page() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement contactTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		clickMethod(contactTab);
		
		windowPopupHandle();
		
		WebElement createNewViewLink = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createNewViewLink.click();
		
		WebElement viewNameLabel = driver.findElement(By.id("fname"));
		fillformMethod(viewNameLabel, "kyle");
		
		sleepMethod();
		
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		new Actions(driver).sendKeys(Keys.TAB).perform();
		
		sleepMethod();
		
		WebElement saveContactBut = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		clickMethod(saveContactBut);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC27_Check_Recently_Created_Contact_In_The_Contact_Page() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement contactTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		clickMethod(contactTab);
		
		windowPopupHandle();
		
		WebElement recentlyCreatedDropdown = driver.findElement(By.id("hotlist_mode"));
		selectMethod(recentlyCreatedDropdown, "Recently Created");
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC28_Check_My_Contacts_View_In_The_Contact_Page() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement contactTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		clickMethod(contactTab);
		
		windowPopupHandle();
		
		WebElement viewDropdown = driver.findElement(By.id("fcf"));
		selectMethod(viewDropdown, "All Contacts");
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC29_View_A_Contact_In_The_Contact_Page() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement contactTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		clickMethod(contactTab);
		
		windowPopupHandle();
		
		WebElement nameSelect = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
		clickMethod(nameSelect);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC30_Check_The_Error_Message_If_The_Required_Info_Is_Not_Entered_While_Creating_A_New_View_In_Contacts() throws InterruptedException {
		String expected = "Error: You must enter a value";
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement contactTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		clickMethod(contactTab);
		
		windowPopupHandle();
		
		WebElement createNewViewLink = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createNewViewLink.click();
		
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		fillformMethod(viewUniqueName, "EFGH");
		
		WebElement saveContactBut = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		clickMethod(saveContactBut);
		
		WebElement textElement = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]"));
		String actual = getTextFormWebElement(textElement, "Error: You must enter a value");
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Script is passed");
		}
		else {
			System.out.println("Script is failed");
		}
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC31_Check_The_Cancel_Button_Works_Fine_In_Create_New_View() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement contactTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		clickMethod(contactTab);
		
		windowPopupHandle();
		
		WebElement createNewViewLink = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createNewViewLink.click();
		
		WebElement viewNameLabel = driver.findElement(By.id("fname"));
		fillformMethod(viewNameLabel, "kyle");
		
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		fillformMethod(viewUniqueName, "EFGH");
		
		WebElement cancelBut = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[2]"));
		clickMethod(cancelBut);
		
		sleepMethod();
		
		closeMethod(driver);
		
	}
	public static void TC32_Check_The_Save_And_New_Button_Works_In_New_Contact_Page() throws InterruptedException {    
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement contactTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		clickMethod(contactTab);
		
		windowPopupHandle();
		
		WebElement newBut = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		clickMethod(newBut);
		
		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		fillformMethod(lastName, "shanaya");
		
		WebElement accName = driver.findElement(By.id("con4"));
		fillformMethod(accName, "Global Media");
		
		WebElement saveAndNew = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[2]"));
		clickMethod(saveAndNew);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC33_Verify_If_The_Firstname_And_Lastname_Of_The_Loggedin_User_Is() throws InterruptedException {
		String expected = "Zara Joshi";
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement homeTab = driver.findElement(By.id("home_Tab"));
		clickMethod(homeTab);
		
		windowPopupHandle();
		
		WebElement textElement = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		String actual = getTextFormWebElement(textElement, "Zara Joshi");
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("script is passed");
		}
		else {
			System.out.println("script is failed");
		}
		WebElement lastfirstLink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		clickMethod(lastfirstLink);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC34_Verify_The_Edited_Lastname_Is_Updated_At_Various_Places() throws InterruptedException {    
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement homeTab = driver.findElement(By.id("home_Tab"));
		clickMethod(homeTab);
		
		sleepMethod();
		
		windowPopupHandle();
		
		WebElement lastfirstLink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		System.out.println("lastfirstcheck");
		clickMethod(lastfirstLink);
		
		sleepMethod();
		
		WebElement editImg = driver.findElement(By.xpath("//a[@href='javascript:void(0);' and @class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		clickMethod(editImg);
		
		sleepMethod();
		
		//frame
		WebElement frame1 = driver.findElement(By.id("contactInfoContentId"));
		driver.switchTo().frame(frame1);
		
		WebElement about = driver.findElement(By.partialLinkText("About"));
		about.click();
		
		WebElement firstname = driver.findElement(By.id("firstName"));
		if(firstname.isDisplayed()) { 
			firstname.clear();
			firstname.sendKeys("zaru");
		}
		else {
			System.out.println("web element is not displayed");
		}
		
		WebElement lastname = driver.findElement(By.id("lastName"));
		if(lastname.isDisplayed()) { 
			lastname.clear();
			lastname.sendKeys("josh");
		}
		else {
			System.out.println("web element is not displayed");
		}
		WebElement saveAll = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		clickMethod(saveAll);
		
		sleepMethod();
		
		closeMethod(driver);
		
	}
	public static void TC35_Verify_The_Tab_Customization() throws InterruptedException {
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement allTabs = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		clickMethod(allTabs);
		
		sleepMethod();
		
		WebElement customizeMyTabs = driver.findElement(By.className("btnImportant"));
		clickMethod(customizeMyTabs);
		
		//every time change in UI
		WebElement selectedTabs = driver.findElement(By.id("duel_select_1"));
		selectMethod(selectedTabs, "Subscriptions");
		
		WebElement remove = driver.findElement(By.xpath("//*[@id=\"duel_select_0_left\"]/img"));
		clickMethod(remove);
		
		WebElement saveBut = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		clickMethod(saveBut);
		
		sleepMethod();
		
		WebElement userNameBut = driver.findElement(By.id("userNavLabel"));
		clickMethod(userNameBut);
		
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		clickMethod(logout);
		
		sleepMethod();
		
		WebElement unameAgain = driver.findElement(By.id("username"));
		loginCredentials(unameAgain, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement passAgain = driver.findElement(By.id("password"));
		loginCredentials(passAgain, "Welcome@321", "passwordEle");
		
		WebElement loginAgain = driver.findElement(By.id("Login"));
		clickMethod(loginAgain);
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC36_Blocking_An_Event_In_The_Calender() throws InterruptedException {
		String expected = "Thursday February 9, 2023";
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement homeTab = driver.findElement(By.id("home_Tab"));
		clickMethod(homeTab);
		
		sleepMethod();
		
		windowPopupHandle();
		
		WebElement textElement = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		String actual = getTextFormWebElement(textElement, "Thursday February 9, 2023");
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("script is passed");
		}
		else {
			System.out.println("script is failed");
		}
		WebElement dateLink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		clickMethod(dateLink);
		
		WebElement timeLink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"));
		clickMethod(timeLink);
		
		WebElement subjectCombo = driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		clickMethod(subjectCombo);
		
		sleepMethod();
		
		for(String winhandle: driver.getWindowHandles()) {     //not working
			driver.switchTo().window(winhandle);
			System.out.println("Window Switch");
			sleepMethod();
			
			WebElement other = driver.findElement(By.linkText("Other"));
			clickMethod(other);
		}
		
		sleepMethod();
		
		closeMethod(driver);
	}
	public static void TC37_Blocking_An_Event_In_The_Calender_With_Weekly_Reccurrence() throws InterruptedException {
		String expected = "Thursday February 9, 2023";
		getDriverInstances("chrome");
		getUrl("https://login.salesforce.com/");
		
		WebElement uname = driver.findElement(By.id("username"));
		loginCredentials(uname, "zarajoshi@tekarch.com", "usernameEle");
		
		WebElement pass = driver.findElement(By.id("password"));
		loginCredentials(pass, "Welcome@321", "passwordEle");
		
		WebElement login = driver.findElement(By.id("Login"));
		clickMethod(login);
		
		WebElement homeTab = driver.findElement(By.id("home_Tab"));
		clickMethod(homeTab);
		
		sleepMethod();
		
		windowPopupHandle();
		
		WebElement dateLink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		clickMethod(dateLink);
		
		WebElement timeLink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"));
		clickMethod(timeLink);
		
		sleepMethod();
		
		WebElement endTime = driver.findElement(By.id("EndDateTime_time"));
		System.out.println("endTimecheck");
		clickMethod(endTime);
	
		//selected with div 
		WebElement dropdownContainer = driver.findElement(By.cssSelector("#simpleTimePicker"));
		WebElement selectedOption = dropdownContainer.findElement(By.cssSelector("#timePickerItem_38"));
		selectedOption.click();

		WebElement rec = driver.findElement(By.id("IsRecurrence"));
		System.out.println("reccheck");
		clickMethod(rec);
		
		WebElement rWeekly = driver.findElement(By.id("rectypeftw"));
		System.out.println("rWeeklycheck");
		clickMethod(rWeekly);
		
		WebElement endRec = driver.findElement(By.id("RecurrenceEndDateOnly"));
		System.out.println("endReccheck");
		clickMethod(endRec);
		
		WebElement subjectCombo = driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		System.out.println("subjectCombocheck");
		clickMethod(subjectCombo);
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		String targetWindowHandle = null;
		for (String handle : allWindowHandles) {
		  if (!handle.equals(driver.getWindowHandle())) {
		    targetWindowHandle = handle;
		    break;
		  }
		}
		
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement other = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/ul/li[5]/a")));
		clickMethod(other);
		
		WebElement saveBut = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		clickMethod(saveBut);
		
//		sleepMethod();
//		
//		closeMethod(driver);
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		TC01_errorLoginSalesforceOne();
//		TC02_successLoginSalesforce();
//		TC03_rememberMeLoginSalesforce();
//		TC04_A_forgotYourPasswordLoginSalesforce();
//		TC04_B_errorLoginSalesforceTwo();
//		TC05_User_Menu_Dropdown();
//		TC06_User_Menu_Dropdown_My_Profile();
//		TC07_User_Menu_Dropdown_My_Settings();
//		TC08_User_Menu_Dropdown_Developers_Connsole();
//		TC09_User_Menu_Dropdown_Logout();
//		TC10_Account_Tab();
//		TC11_Create_New_View();
//		TC12_Edit_View();
//		TC13_Merge_Accounts();
//		TC14_Create_Account_Report();
//		TC15_Opportunities_Dropdown();
//		TC16_Create_New_Opty();
//		TC17_Test_Opportunity_Pinpeline_Report();
//		TC18_Test_Struck_Opportunities_Report();
//		TC19_Test_Quarterly_Summary_Report();
//		TC20_Check_Leads_Tab_Link();
//		TC21_Validate_View_Dropdown_List_Contents();
//		TC22_Functionality_Of_The_Go_Button();
//		TC23_List_Item_Todays_Leads_Work();
//		TC24_Check_New_Button_On_Leads_Home();
//		TC25_Create_New_Contact();
//		TC26_Create_New_View_In_The_Contact_Page();
//		TC27_Check_Recently_Created_Contact_In_The_Contact_Page();
//		TC28_Check_My_Contacts_View_In_The_Contact_Page();
//		TC29_View_A_Contact_In_The_Contact_Page();
//		TC30_Check_The_Error_Message_If_The_Required_Info_Is_Not_Entered_While_Creating_A_New_View_In_Contacts();
//		TC31_Check_The_Cancel_Button_Works_Fine_In_Create_New_View();
//		TC32_Check_The_Save_And_New_Button_Works_In_New_Contact_Page();
//		TC33_Verify_If_The_Firstname_And_Lastname_Of_The_Loggedin_User_Is();
		TC34_Verify_The_Edited_Lastname_Is_Updated_At_Various_Places();
//		TC35_Verify_The_Tab_Customization();
//		TC36_Blocking_An_Event_In_The_Calender();
//		TC37_Blocking_An_Event_In_The_Calender_With_Weekly_Reccurrence();
	}

}
