package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorEx {
	public static void main(String[] args) {
		//WebDriverManager.chromedriver().clearResolutionCache().setup();

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://www.demoblaze.com/");
		/*
		 * driver.findElement(By.name("txtUserName")).sendKeys("pinki");
		 * driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("pinki"
		 * ); driver.findElement(By.name("sign Up")).click();
		 */
		System.out.println("Sign up completed");
		//driver.quit();
			
	}

}
