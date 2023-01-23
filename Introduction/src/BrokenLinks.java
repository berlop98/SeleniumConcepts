import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		 //broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium
		//  Java methods will call URL's and gets you the status code
		//if status code >200 then that url is not working-> link which tied to url is broken
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		//soft assert that does not stop the execution in the moment it fails
		SoftAssert a =new SoftAssert();
		
		for(WebElement link : links){
			String url= link.getAttribute("href");
			HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
			}
		
		a.assertAll();
		
		driver.quit();


	}

}
