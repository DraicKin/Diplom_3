import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import models.pages.ProfilePage;
import models.pages.StartingPage;
import models.User;
import models.UserGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class TransferTests extends BaseTest{

    private User user;
    @Before
    public void init() {
        user = UserGenerator.getRandom();
        String URI = "https://stellarburgers.nomoreparties.site/api/auth/";
        given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(URI + "register")
                .then()
                .statusCode(HTTP_OK);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        login(user);
    }

    @Test
    @DisplayName("Переход в личный кабинет зарегистрированного пользователя")
    public void transferToLk() {
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickLkButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));
        Assert.assertEquals("Din't get lk page",
                "https://stellarburgers.nomoreparties.site/account/profile",
                driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход на стартовую странице по клику на лого")
    public void transferToStartingPageFromLk() {
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickLkButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickBurgerLogo();
        Assert.assertEquals("Din't get starting page",
                "https://stellarburgers.nomoreparties.site/",
                driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logoutTest() {
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickLkButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogOut();
        new WebDriverWait(driver, 5)
               .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        Assert.assertEquals("Din't log out",
                "https://stellarburgers.nomoreparties.site/login",
                driver.getCurrentUrl());
    }
}
