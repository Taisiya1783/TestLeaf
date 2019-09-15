package test.leaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.Warmup;
/**
 * September 15th of 2019
 * @author taisi
 *
 */
public class Edit {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\taisi\\Desktop\\selenium\\geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\taisi\\Desktop\\selenium\\chromedriver.exe");

		WebDriver chromeDriver = getChromeDriver("chrome");

		chromeDriver.get("http://testleaf.herokuapp.com/");

		chromeDriver.findElement(By.linkText("Edit")).click();
		String header = chromeDriver.findElement(By.tagName("h1")).getText();

		if (header.equals("Work with Edit Fields")) {
			System.out.println("Header validation is passed");
		} else {
			System.out.println("Header validation is failed");
		}

		chromeDriver.findElement(By.id("email")).sendKeys(" world!");
		Warmup.sleep(2);
		chromeDriver.findElement(By.cssSelector("[value='Append ']")).sendKeys(" appending text");
		Warmup.sleep(2);

		String value = chromeDriver.findElement(By.name("username")).getAttribute("value");
		/*
		 * To get text out of text box, you should use getAttribute("value") method
		 */
		System.out.println(value);
		Warmup.sleep(3);
		// input[@name='username'] --> xpath
		/*
		 * // relative xpath input --> tag name name --> attribute of the element
		 * 'username' --> value of an atribute
		 */
		chromeDriver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		Warmup.sleep(2);

		boolean isDisabled = !chromeDriver.findElement(By.cssSelector("[disabled='true']")).isEnabled();
		System.out.println(isDisabled);

		// Warmup.quit();

	}

	private static WebDriver getChromeDriver(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
