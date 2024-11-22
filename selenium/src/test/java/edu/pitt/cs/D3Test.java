package edu.pitt.cs;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
// Generated by Selenium IDE
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class D3Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void TESTFIXTURE() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    }

    @Test
    public void tEST1LINKS() {
        TESTFIXTURE();
        {
            List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@href, \'/reset\')]"));
            assert (elements.size() > 0);
        }
    }

    @Test
    public void tEST2RESET() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
        js.executeScript("document.cookie = \"1=true\";document.cookie = \"2=true\";document.cookie = \"3=true\";");
        driver.findElement(By.xpath("//li[8]/a")).click();
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("ID 1. Jennyanydots"));
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(),
                is("ID 2. Old Deuteronomy"));
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    }

    @Test
    public void tEST3CATALOG() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
        driver.findElement(By.linkText("Catalog")).click();
        {
            WebElement element = driver.findElement(By.xpath("//li[2]/img"));
            String attribute = element.getAttribute("src");
            vars.put("image", attribute);
        }
        assertEquals(vars.get("image").toString(), "http://localhost:8080/images/cat2.jpg");
    }

    @Test
    public void tEST4LISTING() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
        driver.findElement(By.linkText("Catalog")).click();
        {
            List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li[3]"));
            assert (elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li[4]"));
            assert (elements.size() == 0);
        }
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    }

    @Test
    public void tEST5RENTACAT() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
        driver.findElement(By.linkText("Rent-A-Cat")).click();
        {
            List<WebElement> elements = driver.findElements(By.xpath("//button[contains(.,\'Rent\')]"));
            assert (elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.xpath("//button[contains(.,\'Return\')]"));
            assert (elements.size() > 0);
        }
    }

    @Test
    public void tEST6RENT() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
        driver.findElement(By.linkText("Rent-A-Cat")).click();
        driver.findElement(By.id("rentID")).click();
        driver.findElement(By.id("rentID")).sendKeys("1");
        driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("Rented out"));
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(),
                is("ID 2. Old Deuteronomy"));
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
        assertThat(driver.findElement(By.id("rentResult")).getText(), is("Success!"));
    }

    @Test
    public void tEST7RETURN() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=true\";document.cookie = \"3=false\";");
        driver.findElement(By.linkText("Rent-A-Cat")).click();
        driver.findElement(By.id("returnID")).click();
        driver.findElement(By.id("returnID")).sendKeys("2");
        driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).click();
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("ID 1. Jennyanydots"));
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(),
                is("ID 2. Old Deuteronomy"));
        assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
        assertThat(driver.findElement(By.xpath("//div[@id=\'returnResult\']")).getText(), is("Success!"));
    }

    @Test
    public void tEST8FEEDACAT() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
        driver.findElement(By.linkText("Feed-A-Cat")).click();
        {
            List<WebElement> elements = driver.findElements(By.xpath("//button[contains(.,\'Feed\')]"));
            assert (elements.size() > 0);
        }
    }
    @Test
    public void tEST9FEED() {
        TESTFIXTURE();
        driver.findElement(By.linkText("Feed-A-Cat")).click();
        driver.findElement(By.id("catnips")).sendKeys("6");
        driver.findElement(By.cssSelector(".btn")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30)); // Fixed WebDriverWait
                                                                                              // constructor
            wait.until(ExpectedConditions.textToBe(By.id("feedResult"), "Nom, nom, nom."));
        }
        assertThat(driver.findElement(By.id("feedResult")).getText(), is("Nom, nom, nom."));
    }

    @Test
    public void tEST10GREETACAT() {
        driver.get("http://localhost:8080");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
        driver.findElement(By.linkText("Greet-A-Cat")).click();
        assertThat(driver.findElement(By.xpath("//div[@id=\'greeting\']/h4")).getText(), is("Meow!Meow!Meow!"));
    }

    @Test
    public void tEST11GREETACATWITHNAME() {
        driver.get("http://localhost:8080/greet-a-cat/Jennyanydots");
        js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
        assertThat(driver.findElement(By.xpath("//div[@id=\'greeting\']/h4")).getText(),
                is("Meow! from Jennyanydots."));
    }

}