package UsingLoops;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FaceBook_CreateAnAccount_DropDown_UsingLoops {
	public static WebDriver driver;
	public static ChromeOptions options;
	
	@BeforeTest
	@Parameters({"url"})
	public void launchUrl(String url) {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--Incognito");
		driver =  new ChromeDriver(options);
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	@Test(priority=1)
	public void clickOnCreateANewAccountButton() throws Exception {
		driver.findElement(By.cssSelector("div._8icz+div a")).click();
		Thread.sleep(2000);
		
	}
	@Test(priority=2, dependsOnMethods ="clickOnCreateANewAccountButton")
	@Parameters({"userfirstname", "userlastname", "useremail", "useremailconfirmation", "userpassword"})
	public void userInformation(String userfirstname, String userlastname, String useremail, String useremailconfirmation, String userpassword) {
		driver.findElement(By.name("firstname")).sendKeys(userfirstname);
		driver.findElement(By.name("lastname")).sendKeys(userlastname);
		driver.findElement(By.name("reg_email__")).sendKeys(useremail);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(useremailconfirmation);
		driver.findElement(By.name("reg_passwd__")).sendKeys(userpassword);
		
	}
	@Test(priority=3, dependsOnMethods = {"clickOnCreateANewAccountButton", "userInformation"})
	public void userBirthdayDropdown() {
		WebElement month = driver.findElement(By.id("month"));
		Select monthoptions = new Select(month);
		List<WebElement>alloptions=monthoptions.getOptions();
		for(WebElement option:alloptions)
		{
		if(option.getText().equals("Aug"))
		{
		option.click();
				break;
				
			}
		}
		
		WebElement day = driver.findElement(By.id("day"));
		Select dayOptions = new Select(day);
		List<WebElement>allDayOptions = dayOptions.getOptions();
		for(WebElement option1:allDayOptions)
		{
			if(option1.getText().equals("20"))
			{
				option1.click();
				break;
			}
		}
		
		WebElement year = driver.findElement(By.id("year"));
		Select yearOptions = new Select(year);
		List<WebElement>allYearOptions = yearOptions.getOptions();
		for(WebElement option2:allYearOptions)
		{
			if(option2.getText().equals("1983"))
			{
				option2.click();
				break;
			}
		}
		}
		@Test(priority=4, dependsOnMethods = {"clickOnCreateANewAccountButton", "userInformation", "userBirthdayDropdown"})
		public void selectGenderCustom() {
			List<WebElement> genderRadioButton = driver.findElements(By.name("sex"));
			for(WebElement allRadioButton: genderRadioButton) {
				if(allRadioButton.getAttribute("value").equals("-1")){
					allRadioButton.click();
				}
			}
			}
		@Test(priority=5, dependsOnMethods = {"clickOnCreateANewAccountButton", "userInformation", "userBirthdayDropdown", "selectGenderCustom"})
		public void selectGenderPronoun() throws Exception {
			WebElement genderPronoun = driver.findElement(By.name("preferred_pronoun"));
			Select pronounOptions = new Select(genderPronoun);
			List<WebElement> allPronounOptions = pronounOptions.getOptions();
			for(WebElement option3:allPronounOptions)
			{
				if(option3.getAttribute("value").equals("6"))
				{
					option3.click();
					
					Thread.sleep(2000);
				}
			}
		}
		@Test(priority=6, dependsOnMethods = {"clickOnCreateANewAccountButton", "userInformation", "userBirthdayDropdown", "selectGenderCustom", "selectGenderPronoun"})
		@Parameters({"gender"})
		public void optionalGender(String gender) {
			driver.findElement(By.name("custom_gender")).sendKeys(gender);
		}
		@AfterTest
		public void tearDown() {
			//driver.quit();
			
					
					
			
			
		
		
		
		
	
		
		
			
		
	}
	
	

		
	

}


