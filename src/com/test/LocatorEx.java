package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorEx {
	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().clearResolutionCache().setup();

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		try {
		driver.navigate().to("https://www.demoblaze.com/");
		String pageTitle = driver.getTitle();
        if (pageTitle.contains("STORE")) {
            System.out.println("Page title is correct: " + pageTitle);
        } else {
            System.out.println("Page title is incorrect: " + pageTitle);
        }
        
        WebElement laptopsCategory = driver.findElement(By.linkText("Laptops"));
        laptopsCategory.click();
        Thread.sleep(2000);
        
        WebElement laptop = driver.findElement(By.linkText("Sony vaio i5"));
        laptop.click();
         
        Thread.sleep(2000);
        
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
        addToCartButton.click();
        
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        WebElement cartButton = driver.findElement(By.id("cartur"));
        cartButton.click();
        
        Thread.sleep(2000);
        
     // Verify that the laptop is in the cart
        WebElement cartItem = driver.findElement(By.xpath("//td[contains(text(), 'Sony vaio i5')]"));
        if (cartItem.isDisplayed()) {
            System.out.println("Item is present in the cart.");
        } else {
            System.out.println("Item is not present in the cart.");
        }

        // Take a screenshot of the cart (optional)
        // File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(screenshot, new File("cart_screenshot.png"));

		} catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        	driver.quit();
        }

}
}
