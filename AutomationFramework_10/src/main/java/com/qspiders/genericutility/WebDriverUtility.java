package com.qspiders.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void selectByIndex(WebElement dropdownEle,int index) {
		Select sel=new Select(dropdownEle);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(WebElement dropdownEle,String value) {
		Select sel=new Select(dropdownEle);
		sel.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement dropdownEle,String visibleText) {
		Select sel=new Select(dropdownEle);
		sel.selectByVisibleText(visibleText);
	}
	
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver,WebElement frameEle) {
		driver.switchTo().frame(frameEle);
	}
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public Timeouts implicitWait(WebDriver driver) {
		return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public WebDriverWait explicitWait(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait;
	}
	
	public void switchToWindow(WebDriver driver,String expUrl) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(expUrl)) {
				break;
			}
		}
	}
	
	public void getPhoto(WebDriver driver) throws IOException {
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+jUtil.getSystemTime()+".png");
		FileHandler.copy(temp, dest);
	}
	
}
