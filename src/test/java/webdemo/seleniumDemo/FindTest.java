package webdemo.seleniumDemo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class FindTest {
	
	//Przykłady znajdowania elementów na stronie www bez elementów xpath
	
	private static WebDriver driver;

	@BeforeAll
	public static void setUpDriver(){
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setHeadless(true);
		edgeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/msedgedriver");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(edgeOptions);
		// Implicity wait -> max czas na znalezienie elementu na stronie
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeEach
	public void setUp() throws Exception {
    	driver.get("https://www.google.pl");
	}

	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void findByName() {
		WebElement element = driver.findElement(By.name("q"));
		assertNotNull(element);
	}

	@Test
	public void findByClass() {
		WebElement element = driver.findElement(By.className("RNNXgb"));
		assertNotNull(element);
	}

	@Test
	public void findBylinkText() {
		WebElement element = driver.findElement(By.linkText("Gmail"));
		assertNotNull(element);
	}

	@Test
	public void findByPartiallinkText() {
		WebElement element = driver.findElement(By.partialLinkText("mail"));
		assertNotNull(element);
	}

	@Test
	public void findByTagName() {
		WebElement element = driver.findElement(By.tagName("div"));
		assertNotNull(element);
	}

	@Test
	public void findByCssSelector() {
		WebElement element = driver.findElement(By.cssSelector("input.gLFyf"));
		assertNotNull(element);
	}


}
