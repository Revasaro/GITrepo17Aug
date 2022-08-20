package org.excel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseClass1 extends DemoQa{
	public static void main(String[] args) throws InterruptedException, IOException {
	LaunchChrome();
	winmax();
	 loadurl("https://www.toolsqa.com/selenium-training/#enroll-form");
	Thread.sleep(2000);
	printTitle();
	printcurrenturl();
	WebElement fstnm = driver.findElement(By.id("first-name"));
	fill(fstnm, getData(0, 1));
	//rightclick(fstnm);
	WebElement textemail = driver.findElement(By.id("email"));

	fill(textemail, getData(1, 1));
	WebElement mobilenm = driver.findElement(By.id("mobile"));

	fill(mobilenm, getData(1, 2));

	
	WebElement entcity = driver.findElement(By.id("city"));

	fill(entcity, getData(1, 2));

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
