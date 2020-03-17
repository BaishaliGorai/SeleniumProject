package vTiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AssetFilterModTC5 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(40,  TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String actLoginPageTitle = driver.findElement(By.linkText("vtiger")).getText();
		
		if(actLoginPageTitle.equals("vtiger"))
		{
			System.out.println("Login Page displayed.");
		}
		else
		{
			System.out.println("Login Page not displayed.");
		}
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		String actHomePageTitle = driver.findElement(By.className("hdrLink")).getText();
		
		if(actHomePageTitle.equals("Home"))
		{
			System.out.println("Home Page should display.");
		}
		else
		{
			System.out.println("Home Page not displayed.");
		}
		
		WebElement wb = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(wb).perform();
		
		driver.findElement(By.linkText("Assets")).click();
		
		String actAssetPageTitle = driver.findElement(By.className("hdrLink")).getText();
		
		if(actAssetPageTitle.equals("Assets"))
		{
			System.out.println("Assets Page should display.");
		}
		else
		{
			System.out.println("Assets Page not displayed.");
		}
		
		
		driver.findElement(By.linkText("Create Filter")).click();
		
		String actualTitle = driver.findElement(By.className("lvtHeaderText")).getText();
		
		String expectedTitle = "Assets > New Custom view";
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Asset filter create page opened.");
		}
		else
		{
			System.out.println("Asset filter create page not opened.");
		}
		
		driver.findElement(By.name("viewName")).sendKeys("cust_filter1");
		
		WebElement wbColumn1 = driver.findElement(By.id("column1"));
		Select sColumn1 = new Select(wbColumn1);
		sColumn1.selectByVisibleText("None");		
		
		WebElement wbColumn2 = driver.findElement(By.id("column2"));
		Select sColumn2 = new Select(wbColumn2);
		sColumn2.selectByVisibleText("None");
		
		WebElement wbColumn3 = driver.findElement(By.id("column3"));
		Select sColumn3 = new Select(wbColumn3);
		sColumn3.selectByVisibleText("None");
		
		WebElement wbColumn4 = driver.findElement(By.id("column4"));
		Select sColumn4 = new Select(wbColumn4);
		sColumn4.selectByVisibleText("None");
		
		WebElement wbColumn5 = driver.findElement(By.id("column5"));
		Select sColumn5 = new Select(wbColumn5);
		sColumn5.selectByVisibleText("None");
		
		WebElement wbColumn6 = driver.findElement(By.id("column6"));
		Select sColumn6 = new Select(wbColumn6);
		sColumn6.selectByVisibleText("None");
		
		WebElement wbColumn7 = driver.findElement(By.id("column7"));
		Select sColumn7 = new Select(wbColumn7);
		sColumn7.selectByVisibleText("None");
		
		WebElement wbColumn8 = driver.findElement(By.id("column8"));
		Select sColumn8 = new Select(wbColumn8);
		sColumn8.selectByVisibleText("None");
		
		WebElement wbColumn9 = driver.findElement(By.id("column9"));
		Select sColumn9 = new Select(wbColumn9);
		sColumn9.selectByVisibleText("None");
		
		WebElement wbColumn1Asset = driver.findElement(By.id("column1"));
		Select sColumn1Asset = new Select(wbColumn1Asset);
		sColumn1Asset.selectByValue("vtiger_assets:assetname:assetname:Assets_Asset_Name:V");
				
		WebElement wbColumn2Asset = driver.findElement(By.id("column2"));
		Select sColumn2Asset = new Select(wbColumn2Asset);
		sColumn2Asset.selectByValue("vtiger_assets:assetname:assetname:Assets_Asset_Name:V");			
					
		TargetLocator tl = driver.switchTo();
		Alert alt = tl.alert();
		String duplicateErrMsg = alt.getText();	
		
		//System.out.println(duplicateErrMsg);
		if(duplicateErrMsg.contains("cannot be duplicated"))
		{
			System.out.println("Columns cannot be duplicate message should display");
		}
		else
		{
			System.out.println("Columns cannot be duplicate message not displayed");
		}
		
		alt.accept();
				
		WebElement wbLogout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actLogout = new Actions(driver);
		actLogout.moveToElement(wbLogout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		if(actLoginPageTitle.equals("vtiger"))
		{
			System.out.println("Logged out successfully.");
		}
		else
		{
			System.out.println("Log out failed.");
		}
		
	}

}
