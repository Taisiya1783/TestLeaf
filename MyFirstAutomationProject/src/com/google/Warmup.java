package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Warmup {
	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\taisi\\Desktop\\selenium\\chromedriver.exe");

				ChromeDriver chromeDriver= getChromeDriver();

				chromeDriver.get("http://newtours.demoaut.com/");
				chromeDriver .findElement(By.xpath("(//a)[5]")).click();
				sleep (3);
				String actualTitle = chromeDriver.getTitle();
		        String actualURL = chromeDriver.getCurrentUrl();
		        
		        if ( actualTitle.equals("Cruises: Mercury Tours") ) {
		            System.out.println("Title check: pass");
		        } else {
		            System.out.println("Title check: fail");
					
				}
				 if ( actualURL.contains("http://newtours.demoaut.com/mercurycruise.php") ) {
			            System.out.println("URL check: pass");
			        } else {
			            System.out.println("URL check: fail! Actual URL: " + actualURL);
			        }
				sleep (5);
				chromeDriver.quit();
	}
	private static ChromeDriver getChromeDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
}
