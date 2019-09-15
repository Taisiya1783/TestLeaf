package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author taisi
 *Simple Google search
 */
public class GoogleSearch {

	public static void main(String[] args) {
 System.setProperty("webdriver.chrome.driver","C:\\Users\\taisi\\Desktop\\selenium\\chromedriver.exe");
		ChromeDriver chromeDriver= new ChromeDriver();
		chromeDriver.get("https://www.google.com/");
		chromeDriver.findElement(By.name("q")).sendKeys("Java tutorials" );
		chromeDriver.findElement(By.name("btnI")).click();
		chromeDriver.findElement(By.name("")).click();


	}
	

}
