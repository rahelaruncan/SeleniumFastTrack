import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Locale;

public class SearchTests {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void searchItem() {
        String searchText = "linen blazer";
        driver.findElement(By.id("search")).sendKeys(searchText);
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        String text = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1")).getText();
        Assert.assertEquals("SEARCH RESULTS FOR '" + searchText.toUpperCase() + "'", text);
    }

    @Test
    public void searchTest() {
        String searchText = "neck";
        driver.findElement(By.id("search")).sendKeys(searchText);
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        List<WebElement> list = driver.findElements(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > h2 > a"));
        WebElement element = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > h2 > a"));
        Assert.assertTrue(list.contains(element));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
