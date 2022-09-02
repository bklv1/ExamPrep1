package Cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {
    public WebDriver driver;
    public WebDriverWait wait;
    @Before
    public void SetUp(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @After
    public void Quit(){
        driver.quit();
    }

    public WebElement findElementWithWait(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public List<WebElement> findElementsWithWait(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    @Given("user navigates to tsd page")
    public void user_navigates_to_tsd_page() {
        driver.navigate().to("https://www.tsd.com/");
    }
    @When("user clicks on Contact us")
    public void user_clicks_on_contact_us() {
        findElementWithWait(By.id("menu-item-16587")).click();
    }
    @Then("verify offices and addresses")
    public void offices_and_addresses_should_be_printed() {
       List<WebElement> results =findElementsWithWait(By.xpath("//div/div/div/div/div/h3"));
       List<String> actualList = new ArrayList<>();
       for (WebElement element: results){
           actualList.add(element.getText());
       }

       List<String> expectedList = new ArrayList<>();
       expectedList.add("Troyan");
       expectedList.add("Sofia");
       expectedList.add("Plovdiv");


        List<WebElement> addresses =findElementsWithWait(By.xpath("//*[@id=\"post-10887\"]/div/div[2]/div/div/div/ul/li[1]/div/p"));
        List<String> actualListOfAddresses = new ArrayList<>();
        for (WebElement element: addresses){
            actualListOfAddresses.add(element.getText());
        }

        List<String> expectedListForAddresses = new ArrayList<>();
        expectedListForAddresses.add("51 G.S. Rakovski Street, 4th Floor\n" +
                "Troyan 5600\n" +
                "Bulgaria");
        expectedListForAddresses.add("115A Tsarigradsko Shose Boulevard, 7th Floor\n" +
                "Sofia 1784\n" +
                "Bulgaria");
        expectedListForAddresses.add("31 Pobeda Street, 6th Floor\n" +
                "Plovdiv 4150\n" +
                "Bulgaria");

        Assertions.assertEquals(expectedList, actualList);
        Assertions.assertEquals(actualListOfAddresses, expectedListForAddresses);
    }


}
