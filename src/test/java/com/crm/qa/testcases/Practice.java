package com.crm.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravin\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.ca/");	
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		List <WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		
//		for (WebElement element : linkList) {
//			System.out.println(element.getText());
//		}

//		1.
//		linkList.forEach(ele ->System.out.println(ele.getText()));
		
//		2.
		List <String> collectList = linkList.
		stream().
		filter(ele-> !ele.getText().equals("")).
		map(ele->ele.getText()).
		collect(Collectors.toList());  
		
		collectList.forEach(ele ->System.out.println(ele));
		
		driver.quit();
		
	}

}
