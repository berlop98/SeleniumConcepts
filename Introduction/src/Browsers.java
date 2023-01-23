import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Invoking Browser

		//Chrome - ChromeDriver exten->Methods close get

		//Firefox- FirefoxDriver ->methods close get

		// WebDriver  close  get

		//WebDriver methods + class methods

		// Chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		

		driver.quit();



	}

}
