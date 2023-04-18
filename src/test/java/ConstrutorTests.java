import io.qameta.allure.junit4.DisplayName;
import models.pages.StartingPage;
import org.junit.Assert;
import org.junit.Test;

public class ConstrutorTests extends BaseTest {
    @Test
    @DisplayName("Переход к разделу Соусы")
    public void openSousTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickSous();
        Assert.assertEquals("Didn't open Sous", "Соусы", startingPage.getCurrentHeader());
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void openBulkiTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickNachinki();
        startingPage.clickBulki();
        Assert.assertEquals("Didn't open Bulki", "Булки", startingPage.getCurrentHeader());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void openNachinkiTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickNachinki();
        Assert.assertEquals("Didn't open Nichinki", "Начинки", startingPage.getCurrentHeader());
    }
}
