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

    private By currentHeader = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
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

    public String getCurrentHeader() {
        return driver.findElement(currentHeader).getText();
    }

}
