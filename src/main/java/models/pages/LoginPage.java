package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By inputEmail = By.xpath(".//label[text()='Email']/parent::div/input");
    private By inputPassword = By.xpath(".//label[text()='Пароль']/parent::div/input");
    private By loginButton = By.xpath(".//button[text()='Войти']");
    private By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void clickRestorePassword() {
        driver.findElement(restorePasswordButton).click();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
