package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class StartingPage {
    private WebDriver driver;
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By lkButton = By.xpath(".//p[text()='Личный Кабинет']");

    private By bulkiButton = By.xpath(".//span[text()='Булки']/parent::div");
    private By sousButton = By.xpath(".//span[text()='Соусы']/parent::div");
    private By nachinkiButton = By.xpath(".//span[text()='Начинки']/parent::div");

    private By bulkiHeader = By.xpath(".//h2[text()='Булки']");
    private By sousHeader = By.xpath(".//h2[text()='Соусы']");
    private By nachinkiHeader = By.xpath(".//h2[text()='Начинки']");
    public StartingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickLkButton(){
        driver.findElement(lkButton).click();
    }

    public void clickBulki(){
        driver.findElement(bulkiButton).click();
    }

    public void clickSous(){
        driver.findElement(sousButton).click();
    }

    public void clickNachinki(){
        driver.findElement(nachinkiButton).click();
    }

    public By getBulkiHeader() {
        return bulkiHeader;
    }

    public By getSousHeader() {
        return sousHeader;
    }

    public By getNachinkiHeader() {
        return nachinkiHeader;
    }
}
