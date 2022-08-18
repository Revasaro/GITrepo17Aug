package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetClass {

	public static WebDriver driver;

	public static void LaunchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void winmax() {
		driver.manage().window().maximize();
	}
	public static void loadurl(String url) {
		driver.get(url);
	}
	public static void printTitle() {
		System.out.println(driver.getTitle());
	}
	public static void printcurrenturl() {
		System.out.println(driver.getCurrentUrl());
	}
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	public static void fill(WebElement ele) {
		ele.click();
	}
	public static void closeBrowser() {
		driver.close();
	}
	public static void rightclick(WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
	}
	public static void dclick(WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele);
	}
	public static String getData(int rowNumber, int cellNumber) throws IOException {

		File f = new File("E:\\workspace\\framwork\\src\\test\\resources\\TextEX.xlsx");

		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
		Row row = s.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		}

		else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd MM YYYYN z");
			value = sim.format(d);
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}

		return value;

	}

}
