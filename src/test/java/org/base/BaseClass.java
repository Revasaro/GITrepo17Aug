package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions mouse;
	public static Alert webPageAlert;
	public static FluentWait<WebDriver> wait;
	private static Select dropDown;
	private static Alert eachElement;

	// WebDriver Methods
	public static void launchChrome() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void winmax() {
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void getTitle() {
		System.out.println(driver.getTitle());
	}
	public static void getcurrenturl() {
		System.out.println(driver.getCurrentUrl());
	}
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	public static void btnclick(WebElement ele) {
		ele.click();
	}
	public static void closeBrowser() {
		driver.close();
	}

	public static void browserclose() {
		driver.quit();
	}

//Action
	public static void rightclick(WebElement a) {
		Actions b = new Actions(driver);
		b.contextClick(a).perform();
	}
	public static void dclick(WebElement ele) {
		Actions b = new Actions(driver);
		b.doubleClick(ele).perform();
	}
	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions b = new Actions(driver);
		b.dragAndDrop(src, des).perform();
	}
	public static void down() throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < 3; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	// Alert

	public static void alertAccept() {
		webPageAlert = driver.switchTo().alert();
		webPageAlert.accept();
		
	}
	public static void alertDismiss() {
		webPageAlert = driver.switchTo().alert();
		webPageAlert.dismiss();
	}
	public static void alertGettext() {
		webPageAlert = driver.switchTo().alert();
		webPageAlert.getText();
		webPageAlert.accept();
	}
	public static void alertSendKeys(String value) {
		webPageAlert = driver.switchTo().alert();
		webPageAlert.sendKeys(value);
		webPageAlert.accept();
	}
	// screenshot
	public static void screenshot(String ref) throws IOException {
		TakesScreenshot s = (TakesScreenshot) driver;
		File sre = s.getScreenshotAs(OutputType.FILE);
		File dec = new File("C:\\Users\\USER\\Downloads");
		FileUtils.copyFile(sre, dec);
	}

//Javascript
	public static void javascript(String ele, WebElement ref) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(ele, ref);
	}
	// Frame
	public static void SwitchToFrame(WebElement ref) {
		driver.switchTo().frame(ref);
	}

	public static void switchToparentFrame() {
		driver.switchTo().parentFrame();
	}
	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// Dropdown
	public static void dropDownselect(WebElement ref, String visibleText) {
		dropDown = new Select(ref);
		dropDown.deselectByVisibleText(visibleText);
	}

	public static void dropDownselect(WebElement ref) {
		dropDown = new Select(ref);
		List<WebElement> allOptions = dropDown.getOptions();
		for (WebElement eachElement : allOptions)
			;
		System.out.println(eachElement.getText());
	}

	public static void dropDownDeselect(WebElement ref, String visibletext) {
		dropDown = new Select(ref);
		dropDown.deselectByVisibleText(visibletext);

	}

	public static void dropDownSelectAll(WebElement ref) {
		dropDown = new Select(ref);
		dropDown.deselectAll();
	}

//windows handling
	public static void windowHandle(Integer a) {
		Set<String> allwindow = driver.getWindowHandles();
		List<String> b = new LinkedList<String>();
		b.addAll(allwindow);
		driver.switchTo().window(b.get(a));

	}

}