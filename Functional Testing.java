
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Test1Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test1() {
    driver.get("https://demo.dealsdray.com/");
    driver.manage().window().setSize(new Dimension(1552, 832));
    driver.findElement(By.id("mui-1")).click();
    driver.findElement(By.id("mui-1")).sendKeys("prexo.mis@dealsdray.com");
    driver.findElement(By.cssSelector(".css-1cj59kc")).click();
    driver.findElement(By.id("mui-2")).click();
    driver.findElement(By.id("mui-2")).sendKeys("prexo.mis@dealsdray.com");
    driver.findElement(By.cssSelector(".MuiButton-root")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".css-1s178v5"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".css-1s178v5")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".MuiBox-root:nth-child(1) > .false .sidenavHoverShow:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".MuiButton-root")).click();
    driver.findElement(By.id("mui-7")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".css-6aomwy"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".css-6aomwy"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".css-6aomwy"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".css-6aomwy")).click();
    driver.findElement(By.cssSelector(".css-6aomwy")).click();
    driver.findElement(By.cssSelector(".css-6aomwy")).click();
    driver.findElement(By.cssSelector(".MuiAvatar-fallback")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".MuiMenuItem-root > a"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector("div:nth-child(2) > .MuiMenuItem-root")).click();
    driver.close();
  }
}
