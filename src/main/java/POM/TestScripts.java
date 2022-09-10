package POM;

import org.junit.jupiter.api.*;

public class TestScripts extends BaseTestClass{
    @Test
    public void Test1() throws InterruptedException{
        TShirtsPage page = new TShirtsPage(driver, wait);
        page.NavigateToUrl();
        page.SelectTshirts();
        page.HoverToTheSpecificTShirtAndAddToCart();
        page.VerifyItemAddedToCart();
    }
}
