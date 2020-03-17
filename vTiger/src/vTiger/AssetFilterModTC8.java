package vTiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AssetFilterModTC8 {

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
			System.out.println("Asset filter create page should display.");
		}
		else
		{
			System.out.println("Asset filter create page not displayed.");
		}
		
		driver.findElement(By.name("viewName")).sendKeys("cust_filter1");
				
		WebElement wbColumn1 = driver.findElement(By.id("column1"));
		Select sColumn1 = new Select(wbColumn1);
		sColumn1.selectByValue("vtiger_assets:product:product:Assets_Product_Name:V");
		
		WebElement wbColumn2 = driver.findElement(By.id("column2"));
		Select sColumn2 = new Select(wbColumn2);
		sColumn2.selectByValue("vtiger_assets:serialnumber:serialnumber:Assets_Serial_Number:V");		
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Filter created successfully.");
		}
		else
		{
			System.out.println("Filter not created.");
		}
		
		WebElement wbViewName = driver.findElement(By.id("viewname"));
		
		Select s = new Select(wbViewName);
		 
		String selectedFilter = s.getFirstSelectedOption().getText();
		
		if(selectedFilter.equals("cust_filter1"))
		{
			System.out.println("Filter present in the list.");
		}
		else
		{
			System.out.println("Filter not present in the list.");
		}
		
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
