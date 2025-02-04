package com.qspiders.computers;

import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListenerUtility;
import com.qspiders.objectrepository.HomePage;
@Listeners(ListenerUtility.class)
public class TC_DWS_010_Test extends BaseClass{
	@Test
	public void clickOnComputers() {
		test.log(Status.INFO, "User logged in successfully");
		
		hp=new HomePage(driver);
		hp.getComputersLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers","Computers page is not displayed");
		test.log(Status.PASS, "Computers page is displayed");
	}
}
