/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Александр
 */
public class SeleniumTest {
    WebDriver driver;
    
    @Before
    public void setUp() {
        if (System.getProperty("os.name").contains("Windows"))
            System.setProperty("webdriver.chrome.driver", "ChromeDriver\\chromedriver.exe");
        else
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/ChromeDriver/chromedriver");
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        driver = new ChromeDriver();
    }
    
    @Test
    public void СorrectExpressionInput() throws Exception {
        driver.navigate().to("http://localhost:8080");        
        driver.findElement(By.id("input")).sendKeys("2+(-5)*(7-8)");
        driver.findElement(By.id("btnCalculate")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("output"))
                .getAttribute("value").equals("2+(-5)*(7-8) = 7,000"));
        driver.close();
    }
    
    @Test
    public void UncorrectExpressionInput() throws Exception {
        driver.navigate().to("http://localhost:8080");        
        driver.findElement(By.id("input")).sendKeys("hello");
        driver.findElement(By.id("btnCalculate")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("output"))
                .getAttribute("value").equals("Cинтаксическая ошибка!"));
        driver.close();
    }
    
    @Test
    public void UndoLastAction() throws Exception {
        driver.navigate().to("http://localhost:8080");        
        driver.findElement(By.id("input")).sendKeys("1+2-3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("input")).sendKeys("1*2/3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("input")).sendKeys("1+2*3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("btnCancel")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("input"))
                .getAttribute("value").equals("1+2*3"));
        driver.close();
    }
    
    @Test
    public void UndoManyActions() throws Exception {
        driver.navigate().to("http://localhost:8080");        
        driver.findElement(By.id("input")).sendKeys("1+2-3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("input")).sendKeys("1*2/3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("input")).sendKeys("1+2*3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("btnCancel")).click();
        driver.findElement(By.id("btnCancel")).click();
        driver.findElement(By.id("btnCancel")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("input"))
                .getAttribute("value").equals("1+2-3"));
        driver.close();
    }
    
    @Test
    public void ClearOutput() throws Exception {
        driver.navigate().to("http://localhost:8080");        
        driver.findElement(By.id("input")).sendKeys("1+2-3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("input")).sendKeys("1*2/3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("input")).sendKeys("1+2*3");
        driver.findElement(By.id("btnCalculate")).click();
        driver.findElement(By.id("btnClear")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("output"))
                .getAttribute("value").equals(""));
        driver.close();
    }
}
