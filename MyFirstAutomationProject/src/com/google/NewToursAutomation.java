package com.google;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author Taisiya new tours automation demo
 */
public class NewToursAutomation {

	public static void main(String[] args) throws InterruptedException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter yout first name: ");
		String fName = scan.nextLine();
		System.out.println("Please enter yout last name: ");
		String lName = scan.nextLine();
		System.out.println("Please enter yout phone number: ");
		String phone = scan.nextLine();
		String email = generateEmail(fName, lName);
		System.out.println("Please enter yout address 1: ");
		String address1 = scan.nextLine();
		System.out.println("Please enter yout address 2: ");
		String address2 = scan.nextLine();
		System.out.println("Please enter yout city: ");
		String city = scan.nextLine();
		System.out.println("Please enter yout state: ");
		String state = scan.nextLine();
		System.out.println("Please enter yout postalcode: ");
		String postalcode = scan.nextLine();
		System.out.println("Please enter yout country: ");
		String country = scan.nextLine();
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\taisi\\Desktop\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");
//		driver.findElement(By.name("userName")).sendKeys("Taisiya");//By.name("userName)--> locator
		// driver.findElement(By.name("password")).sendKeys("TD1983");
		// driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys(fName);
		driver.findElement(By.name("lastName")).sendKeys(lName);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(postalcode);
			
		WebElement countryDropdown = driver.findElement(By.name("country"));
		
		/*
		 * findElement method returns WebElement data type,
		 *  thats why we are assigning it to WebElement object "countryDropdown"
		 */
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country.toUpperCase());
        
        driver.findElement(By.name("email")).sendKeys(generateUserName(fName, lName));
		
		String password = generatePassword(fName, lName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(password);
		
		driver.findElement(By.name("register")).click();
		
		Thread.sleep(3000);
		
		String actuaConfirmationText2 = driver.findElement(By.xpath("(//b)[2]")).getText();//getText method return String
		String expectedConfirmationText2 = "Dear " + fName + " " + lName+ ",";

		if(actuaConfirmationText2.contentEquals(expectedConfirmationText2)) {
			//equals-->comparing content/value of two objects of string
			//
			System.out.println("You are regestered as Admin");
		}else {
			System.out.println("Something went wrong with Admin...");

		}
		
		String actuaConfirmationText = driver.findElement(By.tagName("b")).getText();//getText method return String
		String expectedConfirmationText = "Dear " + fName + " " + lName+ ",";

		if(actuaConfirmationText.equals(expectedConfirmationText)) {
			//equals-->comparing content/value of two objects of string
			//
			System.out.println("You are regestered at Mercure");
		}else {
			System.out.println("Something went wrong...");

		}
		driver.quit();
	}

	private static String generateEmail(String fName, String lName) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(fName).append(".").append(lName).append("@gmail.com");
		return stringBuilder.toString();
	}
	private static String generateUserName ( String fName, String lName ) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(fName).append(".").append(lName);
		return stringBuilder.toString().toLowerCase();
	}
	
	private static String generatePassword ( String fName, String lName ) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(fName).append(".").append(lName).append(123);
		return stringBuilder.toString();
	}
}