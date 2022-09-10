package POM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TShirtsPage extends BaseClass{
    public TShirtsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(5)));
    }

    public void NavigateToUrl(){
        Driver().navigate().to(environment+ "/index.php");
    }

    public void SelectTshirts(){
        findElementWithWait(By.linkText("T-SHIRTS")).click();
    }

    public void HoverToTheSpecificTShirtAndAddToCart(){
        List<WebElement>element= findElementsWithWait(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"));
        Actions actions = new Actions(Driver());
        actions.moveToElement(element.get(1)).perform();
        findElementWithWait(By.xpath("//a[@title='Add to cart']")).click();
    }

    public void VerifyItemAddedToCart() throws InterruptedException {
        WebElement element= findElementWithWait(By.xpath("//a[@title='Proceed to checkout']/span"));
        Thread.sleep(3000);
//        Assertions.assertEquals("Proceed to checkout", element.getText());
//        Assertions.assertFalse(!element.isDisplayed());
        Assertions.assertTrue(element.isDisplayed());
    }
}
