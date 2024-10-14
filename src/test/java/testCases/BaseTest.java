package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
Faker faker = new Faker();
String firstName = faker.name().firstName();
String lastName = faker.name().lastName();
String yopMail = firstName + "." + lastName + "@yopmail.com";
String gMail = firstName + "." + lastName + "@gmail.com";
	Properties prop;
	public WebDriver driver;
	public Logger logger;

	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(@Optional String os, @Optional String browser) throws IOException {
		prop = new Properties();
		FileReader fr = new FileReader("./src//test//resources//Attributes.properties");
		prop.load(fr);
		logger = LogManager.getLogger(this.getClass());
		browser = "chrome";
		
		if(prop.getProperty("execution_env").equals("local")) {
			switch (browser.toLowerCase()) {
			case "chrome": WebDriverManager.chromedriver().setup();	driver = new ChromeDriver(); break;
			case "firefox":	WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); break;
			case "edgedriver": WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); break;
			default:
				System.out.println("Not a valid browser!!!!"); return;
			}
		} else if(prop.get("execution_env").equals("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("NO Matching OS!");
			}
			
			//browser
			switch(browser.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("Not a valid browser!!!");
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tear() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	public String generateRandomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public String generateRandomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String generateRandomAlphaNumric() {
		return RandomStringUtils.randomAlphanumeric(7);
	}
	
	public void takeScreenShot() throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(source, new File("C\\Users\\biniyam\\Downloads\\sample\\sceenshot.jpg"));
		
	}

}
