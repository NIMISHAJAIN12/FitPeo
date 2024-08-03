package StepDefinitions;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.an.E;


public class fitpeo{
	WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("Webdriver.chromeDriver","C:\\\\Users\\\\jainn\\\\OneDrive\\\\Documents\\\\chromeDriver\\\\chromedriver-win64\\\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.fitpeo.com/");
	driver.navigate().to("https://fitpeo.com/revenue-calculator");
	WebElement headline = driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']"));
	  WebElement slider1 = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-track')]"));
	  WebElement slider2 = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
	WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
	WebElement slider5 = driver.findElement(By.xpath("//input[@aria-valuenow='200']"));
	  WebElement field=driver.findElement(By.xpath("//input[@type='number']"));
	double minValue = Integer.parseInt(slider.getAttribute("aria-valuemin"));
	  double targetValue = 820.20;
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView(true);", headline);
	  js.executeScript("arguments[0].value = arguments[1];", slider, targetValue);
	 js.executeScript("var event = new Event('input', { bubbles: true }); arguments[0].dispatchEvent(event);", slider);
	 String fieldValue=field.getAttribute("value");
	 Assert.assertEquals(fieldValue, "820","Something is wrong");
js.executeScript("arguments[0].focus(); arguments[0].select();", field);
field.sendKeys(Keys.BACK_SPACE);
	field.sendKeys("560");
	String sliderValue=field.getAttribute("value");
	Assert.assertEquals(sliderValue, "560","Something is wrong");
	WebElement cpt=driver.findElement(By.xpath("//div[contains(@class,'MuiBox-root css-4o8pys')]"));
	 js.executeScript("arguments[0].scrollIntoView(true);", cpt);
	WebElement cpt1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
	WebElement cpt2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
	WebElement cpt3=driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
	WebElement cpt4=driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
	cpt1.click();
	cpt2.click();
	cpt3.click();
	cpt4.click();
	WebElement total=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19'])[3]"));
	js.executeScript("arguments[0].scrollIntoView(true);", headline);
	String a=total.getText();
	System.out.println("Validated Total Recurring Reimbursement is :"+a);
	driver.manage().window().maximize();
	js.executeScript("arguments[0].scrollIntoView(true);", cpt);
	Thread.sleep(2000);
	WebElement header=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]"));
	String b=header.getText();
	System.out.println(b);
	Assert.assertEquals(b, "$75600","Something is wrong");
	driver.quit();
	  } 
}