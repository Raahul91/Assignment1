package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class QA_Assignment1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\SELENIUM\\Softwares\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		Select option = new Select(driver.findElement(By.id("selenium_commands")));
		 option.selectByVisibleText("Navigation Commands");
		
		 Select continent = new Select(driver.findElement(By.id("continents")));
		 continent.selectByVisibleText("Australia");
		 
		 WebElement checkbox1 = driver.findElement(By.cssSelector("#tool-1"));
		 checkbox1.click();
        
		 WebElement checkbox2 = driver.findElement(By.cssSelector("#tool-2"));
		 checkbox2.click();
        
		 driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click();
		 driver.findElement(By.linkText("Test File to Download")).click();
        
        driver.findElement(By.cssSelector("#photo")).sendKeys("E:\\Tarkarlii Trip\\IMG_20180302_141255.jpg");
        
        driver.findElement(By.cssSelector("#profession-0")).click();
        driver.findElement(By.cssSelector("#profession-1")).click();
        
        WebElement textbox = driver.findElement(By.id("datepicker"));
        textbox.sendKeys("15th May 1991");
        
        driver.findElement(By.id("exp-2")).click();
        driver.findElement(By.cssSelector("#sex-0")).click();
        
        WebElement name = driver.findElement(By.name("firstname"));
        name.sendKeys("Rahul");
        
        WebElement surname = driver.findElement(By.name("lastname"));
        surname.sendKeys("Mali");      
        
        
                
	}
}