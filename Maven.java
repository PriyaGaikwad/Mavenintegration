package com.model.Mavenintegration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Maven {
	
	public WebDriver driver;
  @Test(priority=1)
  public void loginwithvaliddetails() {
	  driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("Suvidyap1");
	  driver.findElement(By.cssSelector("input[name='password']")).sendKeys("P@ssword1");
	  driver.findElement(By.cssSelector("input[name='login']")).click();
	  boolean act_flag1 =driver.findElement(By.cssSelector("img[src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  boolean  exp_flag2=true;
	  Assert.assertEquals(act_flag1,exp_flag2);
  }
  
  
  
  @BeforeMethod
  public void getallcookies() {
	  Set<Cookie>cookies=driver.manage().getCookies();
	  for(Cookie cookies1:cookies)
	  {
		  System.out.println(cookies1.getName());
	  }
  }

  @AfterMethod
  public void screenshot() throws IOException {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src,new File("E:\\priyag java\\Mavenintegration\\src\test\\resources\\Screenshotmaven\\.A.jpeg"));
  }

  @BeforeClass
  public void maximize() {
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void deleteallcookies() {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void url() {
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	 
  }

  @AfterTest
  public void closedbconnection() {
	  System.out.println("close db connection");
  }

  @BeforeSuite
  public void openbrowser() {
	  System.setProperty("webdriver.chrome.driver", "E:\\Selenium Setup\\chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterSuite
  public void close() {
	  driver.close();
  }

}
