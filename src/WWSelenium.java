

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//WW - Question 2

//assumes chromedriver in the folder C:\ChromeDriver\ if need to change (go to line 16)
//chromedriver can be downloaded from https://chromedriver.storage.googleapis.com/index.html?path=2.45/

// I will add in more exeception handling later

public class WWSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		String URL = "https://www.weightwatchers.com/us/";
		String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help";
		WebDriver driver;
		driver= URLOpener (URL);
		correctURL(URL,driver);
		correctPageTitle(expectedTitle,driver);
		clickLink("find-a-meeting", driver);
		correctPageTitle("Find a Studio & Meeting Near You | WW USA", driver);
		enterTextByID("meetingSearch", "10011", driver);
		
		String firstLocation = driver.findElement(By.className("location__name")).getText();
		System.out.println(firstLocation);
		String firstDistance = driver.findElement(By.className("location__distance")).getText();
		System.out.println(firstDistance);
		
		driver.findElement(By.cssSelector("a[ui-sref='mf.location({ locationId: location.id, slug: location.slugTitleGeo, predata: location })']")).click();
		
		String todaysOpeningHours =	driver.findElement(By.cssSelector("div[class='hours-list-item-wrapper hours-list--currentday']")).getText();
		System.out.println(todaysOpeningHours);

		driver.close();


	}
	
	
	
	public static WebDriver URLOpener (String URL) {
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		return driver;
				
	}
	
	public static void correctURL (String URL, WebDriver driver) {
		driver.get(URL);
		try{
		  Assert.assertEquals(URL, driver.getCurrentUrl());
		  System.out.println("Navigated to correct webpage");
		}
		catch(Throwable pageNavigationError){
		  System.out.println("Didn't navigate to correct webpage");
		}
	}
	
	public static void correctPageTitle (String expectedTitle, WebDriver driver) {

		try{
			
			Assert.assertEquals(expectedTitle, driver.getTitle());
		  
			System.out.println("Navigated to correct webpage title");
		}
		catch(Throwable pageNavigationError){
			
			System.out.println("Didn't navigate to correct webpage title");
			System.out.println("This is the page title: " + driver.getTitle());
		}
	}
	
	public static void clickLink (String linkClass, WebDriver driver) {

		driver.findElement(By.className(linkClass)).click();
	}
	
	public static void enterTextByID (String textBoxClass, String textEntered, WebDriver driver) {
		driver.findElement(By.id(textBoxClass)).sendKeys(textEntered);
		driver.findElement(By.id(textBoxClass)).sendKeys(Keys.RETURN);
		
	}
	
	public static void divClassName (String divClassName, WebDriver driver) {
		String firstLocation = driver.findElement(By.className(divClassName)).getText();
		System.out.println(firstLocation);
	}

}



