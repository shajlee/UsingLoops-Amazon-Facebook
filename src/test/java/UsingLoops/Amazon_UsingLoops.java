package UsingLoops;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amazon_UsingLoops {
	public static WebDriver driver;
	public static ChromeOptions options;
	
	@BeforeTest
	@Parameters({"url"})
	public void launchUrl(String url) {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--Incognito");
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	@Test(priority=1)
	public void openSignTab() {
		driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1")).click();
	}
	@Test(priority =2, dependsOnMethods = "openSignTab")
	@Parameters({"username"})
	public void userName(String username) {
		driver.findElement(By.cssSelector("input#ap_email")).sendKeys(username);
		driver.findElement(By.cssSelector("input#continue")).click();
	}
	@Test(priority = 3, dependsOnMethods = {"openSignTab", "userName"})
	@Parameters({"password"})
	public void passWord(String password) {
		driver.findElement(By.cssSelector("input#ap_password")).sendKeys(password);
		driver.findElement(By.cssSelector("input#signInSubmit")).click();
	}
	@Test(priority = 4, dependsOnMethods = {"openSignTab", "userName", "passWord"})
	@Parameters({"item"})
	public void searchItem(String item) {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys(item);
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
	}
	@Test(priority = 5, dependsOnMethods = {"openSignTab", "userName", "passWord","searchItem"})
	public void chooseItem1() {
		List<WebElement>drumSticks = driver.findElements(By.cssSelector("div.a-section.aok-relative.s-image-square-aspect img"));
		System.out.println("No. of options: " + drumSticks.size());
		for(WebElement drumStick:drumSticks)
		{
		if(drumStick.getAttribute("data-image-index").equals("1"))
		{
			drumStick.click();
			break;
			
			
		}
		}
	}
	@Test(priority = 6, dependsOnMethods = {"openSignTab", "userName", "passWord","searchItem", "chooseItem1"})
	public void itemSize() {
		List<WebElement>radioButton= driver.findElements(By.id("a-autoid-12-announce"));
		System.out.println("No of options: " + radioButton.size());
		for(WebElement stickSize:radioButton)
		{
			if(stickSize.getAttribute("class").equals("a-text-left a-size-base"))
			{
				stickSize.click();
				break;
			}
		}
	}
	@Test(priority = 7, dependsOnMethods = {"openSignTab", "userName", "passWord","searchItem", "chooseItem1", "itemSize"})
	public void addToCart() throws Exception {
		driver.findElement(By.cssSelector("input#add-to-cart-button")).click();
		Thread.sleep(2000);
		
	}
	@Test(priority = 8, dependsOnMethods = {"openSignTab", "userName", "passWord","searchItem", "chooseItem1", "itemSize", "addToCart"})
	public void clickOnHomeButton() {
		driver.findElement(By.cssSelector("a#nav-logo-sprites")).click();

	}
	@Test(priority = 9, dependsOnMethods = {"openSignTab", "userName", "passWord","searchItem", "chooseItem1", "itemSize", "addToCart", "clickOnHomeButton"})
	public void signOut() throws Exception {
	WebElement e = driver.findElement(By.xpath("//span[text()='Hello, Shajlee']"));
	Actions act = new Actions(driver);
	act.moveToElement(e).perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text() = 'Sign Out']")).click();
	Thread.sleep(2000);
	
	
	
	
		
		
		
		
		

		
		
		
				
					
				

	
}

			
		
		
		

		
		
	
		
	
		
		
	}






