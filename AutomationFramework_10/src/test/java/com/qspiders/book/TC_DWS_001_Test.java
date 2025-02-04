package com.qspiders.book;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListenerUtility;
import com.qspiders.objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_001_Test extends BaseClass{
	@Test
	public void clickOnBooks() {
		hp=new HomePage(driver);
		hp.getBooksLink().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Book","Books page is not displayed");
		test.log(Status.PASS, "Books page is displayed");	
	}
}