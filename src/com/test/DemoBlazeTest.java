package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoBlazeTest {

    public static void main(String[] args) {
        // Setup WebDriverManager to handle ChromeDriver versioning automatically
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to the DemoBlaze website
            driver.get("https://www.demoblaze.com/");

            // Verify the page title
            String pageTitle = driver.getTitle();
            if (pageTitle.contains("STORE")) {
                System.out.println("Page title is correct: " + pageTitle);
            } else {
                System.out.println("Page title is incorrect: " + pageTitle);
            }

           
            WebElement signInButton = driver.findElement(By.id("signin2"));
            signInButton.click();
            
            WebElement usernameField = driver.findElement(By.id("loginusername"));
            System.out.println("user-------------");
            usernameField.click(); 
            usernameField.sendKeys("Psaru");

           
			/*
			 * Thread.sleep(2000);
			 * 
			 * 
			 * WebElement usernameField = driver.findElement(By.id("loginusername"));
			 * WebElement passwordField = driver.findElement(By.id("loginpassword"));
			 * 
			 * usernameField.click(); usernameField.sendKeys("Psaru");
			 * 
			 * passwordField.click(); passwordField.sendKeys("pinki123");
			 * 
			 * 
			 * WebElement loginButton =
			 * driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
			 * loginButton.click();
			 * 
			 * 
			 * Thread.sleep(2000);
			 * 
			 * 
			 * WebElement logoutButton = driver.findElement(By.id("logout2")); if
			 * (logoutButton.isDisplayed()) { System.out.println("Login successful!"); }
			 * else { System.out.println("Login failed."); }
			 */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
           // driver.quit();
        }
    }
}
