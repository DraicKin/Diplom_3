package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By enterButton = By.xpath(".//a[text()='Войти']");
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
