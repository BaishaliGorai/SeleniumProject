package vTiger;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateCampaignHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,  TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin", Keys.ENTER);
		
		WebElement wb = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(wb).perform();
		
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.cssSelector("img[alt='Create Campaign...']")).click();
		
		driver.findElement(By.name("campaignname")).sendKeys("TestCampaign");
		driver.findElement(By.cssSelector("img[alt='Select'")).click();
		
		String mainID = driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();
		
		for(String s: allID)
		{
			if(!mainID.equals(allID))
			{
				driver.switchTo().window(s);
			}
		}
		
		driver.findElement(By.linkText("Vtiger Single User Pack")).click();
		driver.switchTo().window(mainID);
		
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();
		String actSuccessMsg = driver.findElement(By.xpath("//span[contains(text(), 'Campaign Information')]")).getText();
		
		if(actSuccessMsg.contains("Campaign Information"))
		{
			System.out.println("Campaign created successfully.");
		}
		else
		{
			System.out.println("Campaign creation failed.");
		}
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.name("search_text")).sendKeys("TestCampaign");
		WebElement wbSearchField = driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select"));
		Select s = new Select(wbSearchField);
		s.selectByValue("campaignname");
		
		driver.findElement(By.cssSelector("input[value=' Search Now ']")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.findElement(By.cssSelector("input[value='Delete']")).click();
		
		/*driver.switchTo().alert().accept();
		
		String actDeleteSuccessMsg = driver.findElement(By.xpath("//span[contains(text(),'No Campaign Found')]")).getText();
		
		if(actDeleteSuccessMsg.contains("No Campaign Found"))
		{
			System.out.println("Campaign deleted successfully.");
		}
		
		else
		{
			System.out.println("Campaign deletion failed.");
		}*/
			
	}

}
