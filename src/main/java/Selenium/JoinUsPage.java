package Selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class JoinUsPage extends BaseClass {

    public JoinUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }
    public void NavigateToJoinUsPage(){
        Driver().navigate().to("https://www.tsd.com/");
    }
    public void SelectJoinUs(){
       WebElement elementToHover= findElementWithWait(By.id("menu-item-17447"));
        Actions actions = new Actions(Driver());
        actions.moveToElement(elementToHover).perform();
        findElementWithWait(By.xpath("//li[@id='menu-item-16588']/a/span")).click();

        WebElement currentOpenings = findElementWithWait(By.xpath("//strong[contains(text(),'Current Openings')]"));
        actions.moveToElement(currentOpenings).perform();

        List<WebElement> JobTitles = findElementsWithWait(By.xpath("//div[@class='table-2']/table/tbody/tr/td[1]/a"));
        List<WebElement> Location = findElementsWithWait(By.xpath("//div[@class='table-2']/table/tbody/tr/td[2]"));

        for (var element1 : JobTitles){

            for (var element2 : Location){
                System.out.println("Position: "+element1.getText() +"| Location: "+ element2.getText());
            }
        }


    }


}
