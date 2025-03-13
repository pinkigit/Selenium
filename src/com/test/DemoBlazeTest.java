package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.internal.com.google.protobuf.Duration;
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

            // Wait for the "Sign In" button to be clickable and then click it
            WebDriverWait wait = new WebDriverWait(driver,10);
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
            signInButton.click();

            // Wait for the login modal to appear
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));

            // Scroll to the username and password fields
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", usernameField);

            // Use Actions class to focus on the username field and input text
            Actions actions = new Actions(driver);
            actions.moveToElement(usernameField).click().sendKeys("Psaru").perform();  // Enter your username

            actions.moveToElement(passwordField).click().sendKeys("pinki123").perform(); // Enter your password


           
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
