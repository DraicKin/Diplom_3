import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
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
        Assert.assertTrue("Didn't open Sous", driver.findElement(startingPage.getSousHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void openBulkiTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickNachinki();
        startingPage.clickBulki();
        Assert.assertTrue("Didn't open Bulki", driver.findElement(startingPage.getBulkiHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void openNachinkiTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickNachinki();
        Assert.assertTrue("Didn't open Nachinki", driver.findElement(startingPage.getNachinkiHeader()).isDisplayed());
    }
}
