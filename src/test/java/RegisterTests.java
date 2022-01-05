import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTests {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void registerPageWithValidCredential() {

        String email = (RandomStringUtils.randomAlphabetic(10) + "@gmail.com").toLowerCase();
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rahela");
        driver.findElement(By.id("lastname")).sendKeys("Runcan");
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Parola22");
        driver.findElement(By.id("confirmation")).sendKeys("Parola22");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        String text = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span")).getText();

        Assert.assertEquals("Thank you for registering with Madison Island.", text);
    }

    @Test
    public void registerPageWithInValidCredential() {

        String email = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Rahela");
        driver.findElement(By.id("lastname")).sendKeys("Runcan");
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Parola22");
        driver.findElement(By.id("confirmation")).sendKeys("Parola22");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        String text = driver.findElement(By.cssSelector("#form-validate > div.fieldset > p.required")).getText();

        Assert.assertEquals("* Required Fields", text);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
