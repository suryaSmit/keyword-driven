package keyworddriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class ActionKeywords {
	public WebDriver driver;

	// open browser
	public void openBrowser(String locType, String locValue, String data) {
		if (data.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/surya/Documents/selenium/softwares/geckodriver");
			driver = new FirefoxDriver();
		} else if (data.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/surya/Documents/selenium/softwares/chromedriver");
			driver = new ChromeDriver();
		} else if (data.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please enter valid browser name");
		}
	}

	// navigate
	public void navigate(String locType, String locValue, String data) {
		driver.navigate().to(data);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// write
	public void write(String locType, String locValue, String data) {
		driver.findElement(Locator.locateElement(locType, locValue)).sendKeys(data);
	}

	// click
	public void click(String locType, String locValue, String data) {
		driver.findElement(Locator.locateElement(locType, locValue)).click();
	}

	// wait
	public void wait(String locType, String locValue, String data) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// select
	public void select(String locType, String locValue, String data) {
		new Select(driver.findElement(Locator.locateElement(locType, locValue))).selectByVisibleText(data);
	}

	// accept alert
	public void acceptAlert(String locType, String locValue, String data) {
		System.out.println("alert came: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	//close broser
	public void closeBrowser(String locType, String locValue, String data) {
		driver.close();
	}

}
