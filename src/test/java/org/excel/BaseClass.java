package org.excel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseClass extends GetClass {
	public static void main(String[] args) throws InterruptedException, IOException {

		LaunchChrome();
		winmax();
		loadurl("https://www.facebook.com/");
		Thread.sleep(2000);
		printTitle();
		printcurrenturl();
		WebElement txtemail = driver.findElement(By.id("email"));
		fill(txtemail, getData(1, 1));
		rightclick(txtemail);
		WebElement textpass = driver.findElement(By.id("pass"));

		fill(textpass, getData(1, 2));
		WebElement btnlogin = driver.findElement(By.name("login"));

		dclick(btnlogin);

	}
}
