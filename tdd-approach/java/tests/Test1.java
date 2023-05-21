package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Test1 {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver", "/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);


        try {
            WebElement popup = driver.findElement(By.cssSelector(".modal-close"));
            System.out.println("Popup var!");
            popup.click();
        } catch (Exception e) {
            System.out.println("Popup yok!");
        }
        int x = 100; // X koordinatı
        int y = 200; // Y koordinatı
        WebElement input =driver.findElement(By.cssSelector(".V8wbcUhU"));
        input.sendKeys("erkek giyim");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        //close suggestion
        actions.moveByOffset(x, y).click().perform();

        //container of all products
        WebElement productContainer = driver.findElement(By.cssSelector(".prdct-cntnr-wrppr"));

        //get these products with an array
        List<WebElement> productElements = productContainer.findElements(By.cssSelector(".p-card-wrppr"));
        //let choose the second product
        WebElement product = productElements.get(1);
        product.click();

        //now switch the screen to product detail
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //choose the add to cart button
        WebElement addToBasketButton = driver.findElement(By.cssSelector(".add-to-basket"));
        addToBasketButton.click();

        Thread.sleep(3000);

        //control the cart is not empty
        WebElement basketItemCountContainer = driver.findElement(By.cssSelector(".basket-item-count-container.visible"));

        WebElement goToCart=driver.findElement(By.cssSelector(".link.account-basket"));
        goToCart.click();

        Thread.sleep(3000);

        WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"pb-container\"]/div/div[2]/div/a"));
        if (confirmButton.isEnabled() && confirmButton.isDisplayed()) {
            System.out.println("Buton tıklanabilir ve görüntüleniyor.");
            confirmButton.click();
        } else {
            System.out.println("Buton tıklanabilir değil veya görüntülenmiyor.");
        }

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"login-email\"]"));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"login-password-input\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button\n"));

        emailInput.sendKeys("omersorgun34@hotmail.com");
        passwordInput.sendKeys("Omeryusuf34");
        loginButton.click();

        Thread.sleep(3000);

        WebElement cart=driver.findElement(By.xpath("//*[@id=\"pb-container\"]/aside/div/div[1]/a"));
        cart.click();

        Thread.sleep(3000);
        currentWindow = driver.getWindowHandle();

        WebElement policyCheckbox= driver.findElement(By.xpath("//*[@id=\"p-layout\"]/aside/div/div[2]/section/div/label"));
        policyCheckbox.click();

        WebElement checkOut=driver.findElement(By.xpath("//*[@id=\"p-layout\"]/aside/div/div[1]/button"));
        checkOut.click();
    }
}