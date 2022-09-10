package Selenium;

import org.junit.jupiter.api.Test;

public class TestScripts extends BaseTestClass{

    @Test
    public void TestExample1(){
        JoinUsPage page = new JoinUsPage(driver, wait);
        page.NavigateToJoinUsPage();
        page.SelectJoinUs();
    }

}
