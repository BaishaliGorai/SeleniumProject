package vTiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssetFilterModTC2 {

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
			System.out.println("Asset filter create page displayed.");
		}
		else
		{
			System.out.println("Asset filter create page not displayed.");
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
