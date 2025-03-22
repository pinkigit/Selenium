package com.test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoBlazeTest {

    private static final Logger LOGGER = Logger.getLogger(DemoBlazeTest.class.getName());
    
    static {
        try {
            // Create a FileHandler that writes log to a file
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            
            // Add the handler to the logger
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Failed to initialize log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
		
	 {
		// Setup WebDriverManager to handle ChromeDriver versioning automatically
		WebDriverManager.chromedriver().setup();

		
		
		// Initialize WebDriver (Chrome)
		WebDriver driver = new ChromeDriver();

		try {
			// Navigate to the DemoBlaze website
			LOGGER.info("Opening browser...");
			driver.get("https://www.demoblaze.com/");
			driver.manage().window().maximize();

			// Verify the page title
			String pageTitle = driver.getTitle();
			if (pageTitle.contains("STORE")) {
				LOGGER.info("Page title is correct: " + pageTitle);
				System.out.println("Page title is correct: " + pageTitle);
			} else {
				LOGGER.info("Page title is incorrect: " + pageTitle);
				System.out.println("Page title is incorrect: " + pageTitle);
			}

			// Wait for the "Sign In" button to be clickable and then click it
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
			signInButton.click();

			// Wait for the login modal to appear
			WebElement usernameField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
			WebElement passwordField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));

			// Scroll to the username and password fields
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", usernameField);

			// Use Actions class to focus on the username field and input text
			Actions actions = new Actions(driver);
			actions.moveToElement(usernameField).click().sendKeys("Psaru").perform(); // Enter your username

			actions.moveToElement(passwordField).click().sendKeys("pinki123").perform(); // Enter your password

			WebElement loginButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Log in')]")));
			loginButton.click();

			// user add product to cart
			Thread.sleep(2000);

			driver.findElement(By.linkText("Laptops")).click();
			Thread.sleep(2000);

			driver.findElement(By.linkText("Sony vaio i7")).click();
			Thread.sleep(2000);

//     for loop-adding same product 5 times
			String alertText = null;
			Alert alert = null;
			for (int i = 1; i <= 1; i++) {
				// Add to cart
				driver.findElement(By.linkText("Add to cart")).click();
				Thread.sleep(2000);

				alert = driver.switchTo().alert();
				alertText = alert.getText();
				alert.accept();
			}

			if (alertText.equals("Product added.")) {
				LOGGER.info("product successfully added to cart");
				System.out.println("product successfully added to cart");
			} else {
				LOGGER.info("Test failed:Unexpected alert message :" + alertText);
				System.out.println("Test failed:Unexpected alert message :" + alertText);
			}

			driver.findElement(By.linkText("Cart")).click();
			Thread.sleep(2000);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Place Order')]")))
					.click();
			
			
			WebElement name = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
			WebElement Country = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));
			
			  WebElement city = wait
			  .until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
			  WebElement card = wait
			  .until(ExpectedConditions.visibilityOfElementLocated(By.id("card")));
			  WebElement month = wait
			 .until(ExpectedConditions.visibilityOfElementLocated(By.id("month")));
			  WebElement year = wait
			 .until(ExpectedConditions.visibilityOfElementLocated(By.id("year")));
			 
			actions.moveToElement(name).click().sendKeys("pinki").perform(); 
			actions.moveToElement(Country).click().sendKeys("USA").perform(); 
			
			  actions.moveToElement(city).click().sendKeys("NW").perform();
			 actions.moveToElement(card).click().sendKeys("41111111111").perform();
			  actions.moveToElement(month).click().sendKeys("12").perform();
			  actions.moveToElement(year).click().sendKeys("2025").perform();
			 

			
			
			 wait.until(ExpectedConditions.elementToBeClickable(By.
			  xpath("//button[contains(text(), 'Purchase')]"))) .click();
			 
			 wait.until(ExpectedConditions.elementToBeClickable(By.
					  xpath("//button[contains(text(), 'OK')]"))) .click(); 
			 
			 wait.until(ExpectedConditions.elementToBeClickable(By.
					  xpath("//button[contains(text(), 'Close')]"))) .click();

		}

		catch (Exception e) {
			LOGGER.info("Test Failed :" + e.getMessage());
			System.out.println("Test Failed :" + e.getMessage());

		} finally {
			//driver.quit();
			//logger.info("Browser closed.");
		}

	}
}
}
