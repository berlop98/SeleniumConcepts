import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://phptravels.net/flights");
		Thread.sleep(5000);
		
		driver.findElement(By.id("round-trip")).click();
		
		WebElement staticDropdown = driver.findElement(By.id("flight_type"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(1);
		dropdown.selectByValue("first");
		dropdown.selectByVisibleText("Business");
		
		
		driver.findElement(By.id("autocomplete")).sendKeys("united states");
		List<WebElement> departures = driver.findElements(By.xpath("//div[@class='autocomplete-result']/div[2]"));
		for(WebElement option: departures) {
			if(option.getText().equalsIgnoreCase("Rutland, United States")) {
				option.click();
				break;
			}
		}
		
		
		driver.findElement(By.xpath("//div[@class='dropdown dropdown-contain']")).click();
		Thread.sleep(2000);
		for(int i=0; i<2; i++) {
			driver.findElement(By.xpath("//input[@id='fchilds']/following-sibling::div")).click();
		}

		Thread.sleep(3000);
		
		driver.quit();

	}

}
