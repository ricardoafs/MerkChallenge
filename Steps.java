
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;


public class Steps {
    public static void main(String [] args){

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        FirefoxDriver driver_FF = new FirefoxDriver();

        driver_FF.get("https://shop.mercedes-benz.com/en-gb/collection/");


        //close cookies warning
        driver_FF.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver_FF.findElement(By.className("close"));
        driver_FF.findElement(By.className("close")).click();




        //steps na loja ate chegar ao produto
        driver_FF.findElement(By.xpath("//a[@class='dcp-nav__link ng-binding']")).click();

        driver_FF.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //steps do produto
        driver_FF.findElement(By.xpath("//a[contains(text(),'Watches')]")).click();
        driver_FF.findElement(By.xpath("//a[contains(text(),'Men')]")).click();
        driver_FF.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver_FF, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Automatic chronograph, men, Motorsports')]")));

        driver_FF.findElement(By.xpath("//h3[contains(text(),'Automatic chronograph, men, Motorsports')]")).click();

        //cart steps
        driver_FF.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver_FF.findElement(By.xpath("//button[contains(@class,'add-to-basket')]")).click();
        driver_FF.findElement(By.xpath("//button[contains(@href,'cart')]")).click();

        //1.shopping basket
        driver_FF.findElement(By.xpath("//button[@data-testid='co-func-header-forward']")).click();

        driver_FF.findElement(By.xpath("//input[@id='dcp-login-guest-user-email']")).sendKeys("ricardo.santos_tst@sapo.pt");
        driver_FF.findElement(By.xpath("//button[@data-testid='co-order-process-login-guest-user-cta']")).click();

        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Mr')]")));

        //dados do cliente steps
        driver_FF.findElement(By.xpath("//label[contains(text(),'Mr')]")).click();
        driver_FF.findElement(By.xpath("//input[@id='co_payment_address-firstName']")).sendKeys("Ricardo");
        driver_FF.findElement(By.xpath("//input[@id='co_payment_address-lastName']")).sendKeys("Santos");
        driver_FF.findElement(By.xpath("//input[@id='co_payment_address-line2']")).sendKeys("30");
        driver_FF.findElement(By.xpath("//input[@id='co_payment_address-line1']")).sendKeys("Mercedes Test");
        driver_FF.findElement(By.xpath("//input[@id='co_payment_address-town']")).sendKeys("Lisboa");
        driver_FF.findElement(By.xpath("//input[@id='co_payment_address-postalCode']")).sendKeys("SP2 0FL");


        JavascriptExecutor jse = driver_FF;
        //jse.executeScript("window.scrollBy(0,250)");
        jse.executeScript("scroll(0, -250);");

        Actions actions = new Actions(driver_FF);
        WebElement elementLocator = driver_FF.findElement(By.xpath("//button[@data-testid='co-func-footer-forward']"));
        actions.doubleClick(elementLocator).perform();

        //driver_FF.findElement(By.xpath("//button[@data-testid='co-func-footer-forward']")).click();






    }

}
