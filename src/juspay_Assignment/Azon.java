package juspay_Assignment;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Azon {
	public static void main(String[] args) {
		//launch browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		WebElement searchTextfield=driver.findElement(By.id("twotabsearchtextbox"));
		//Searching shoes 
		searchTextfield.sendKeys("shoes");
		WebElement searchSubmitButton=driver.findElement(By.id("nav-search-submit-button"));
		//Clicking on search button
		searchSubmitButton.click();
		//scroll down the webpage to click on shoes image
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,500)");
		WebElement jqr=driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-tall-aspect']/img[1]"));
		jqr.click();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		//scroll down the webpage for the visibility of the Buy Button
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollTo(0,500)");
		WebElement buy=driver.findElement(By.id("buy-now-button"));
		buy.click();
		WebElement mobile = driver.findElement(By.id("ap_email"));
		mobile.sendKeys("8722129882");
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();
		WebElement pwd = driver.findElement(By.id("ap_password"));
		pwd.sendKeys("9901374262");
		driver.findElement(By.id("signInSubmit")).click();
		driver.manage().window().minimize();
		driver.close();
		driver.quit();

	}
}

