package vTiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AssetFilterModTC1 {

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
		
		WebElement wbFilter = driver.findElement(By.id("viewname"));
		Select s = new Select(wbFilter);
		
		//Get the first selected option
		String actSelectedOption= s.getFirstSelectedOption().getText();
		
		if(actSelectedOption.equals("All"))
		{
			System.out.println("By default All is selected in filter.");
		}
		else
		{
			System.out.println("By default All is not selected in filter.");
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
