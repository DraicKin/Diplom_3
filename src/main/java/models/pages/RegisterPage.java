package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private By inputName = By.xpath(".//label[text()='Имя']/parent::div/input");
    private By inputEmail = By.xpath(".//label[text()='Email']/parent::div/input");
    private By inputPassword = By.xpath(".//label[text()='Пароль']/parent::div/input");
    private By confirmButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By errorMessage = By.xpath(".//p[@class='input__error text_type_main-default']");
    private By loginButton = By.xpath(".//a[text()='Войти']");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickRegistration(){
        driver.findElement(confirmButton).click();
    }

    public void registration(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegistration();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
}
