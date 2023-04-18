package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProfilePage {
    private WebDriver driver;
    private By burgerLogo = By.className("AppHeader_header__logo__2D0X2");
    private By logOutButton = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBurgerLogo() {
        driver.findElement(burgerLogo).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void clickLogOut() {
        driver.findElement(logOutButton).click();
    }
}
