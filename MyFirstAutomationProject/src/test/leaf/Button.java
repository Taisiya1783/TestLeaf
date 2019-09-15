package test.leaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Common;
import driver.Driver;

/**
 * 
 * @author TechCenture
 *
 */
public class Button {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver("chrome");
        driver.get("http://testleaf.herokuapp.com/home.html");
        driver.findElement(By.linkText("Button")).click();
        
        Common.sleep(2);
        
        driver.findElement(By.id("home")).click();
        
        String homePageHeader = driver.findElement(By.tagName("h1")).getText();
        String expectedPageHeader = "Locators and Selenium Interactions";
        
        if ( homePageHeader.equals(expectedPageHeader) ) {
            System.out.println("Header validation status: Pass");
        } else {
            System.out.println("Header validation status: Fail");
        }
        
        Common.sleep(2);
        
        driver.navigate().back();
        
        int x = driver.findElement(By.id("position")).getLocation().getX();
        int y = driver.findElement(By.id("position")).getLocation().getY();
        System.out.println("x = " + x + ", y = " + y);
        
        String color1 = driver.findElement(By.id("color")).getAttribute("style");
        String color2 = driver.findElement(By.id("color")).getCssValue("background-color");
        
        System.out.println(color1);
        System.out.println(color2);
        
        int height = driver.findElement(By.id("size")).getSize().getHeight();
        int width = driver.findElement(By.id("size")).getSize().getWidth();
        
        System.out.println("height = " + height + ", width = " + width);
        
        Common.sleep(3);
        driver.quit();
    }
}


