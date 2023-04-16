import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import models.*;
import models.pages.ForgotPasswordPage;
import models.pages.RegisterPage;
import models.pages.StartingPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class LoginTests extends BaseTest{
    private User user;
    @Before
    public void init() { //PUBLIC?
        user = UserGenerator.getRandom();
        String URI = "https://stellarburgers.nomoreparties.site/api/auth/";
        given()
                    .header("Content-type", "application/json")
                    .body(user)
                    .when()
                    .post(URI + "register")
                    .then()
                .statusCode(HTTP_OK);
    }


    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    public void loginFromStartingPage() {
        driver.get("https://stellarburgers.nomoreparties.site");
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickLoginButton();
        login(user);
        Assert.assertNotNull("Login failed " + user.getEmail() + " " + user.getPassword(), token);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLogin();
        login(user);
        Assert.assertNotNull("Login failed " + user.getEmail() + " " + user.getPassword(), token);
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void loginFromLk() {
        driver.get("https://stellarburgers.nomoreparties.site");
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickLkButton();
        login(user);
        Assert.assertNotNull("Login failed " + user.getEmail() + " " + user.getPassword(), token);
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    public void loginFromForgotPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickEnterButton();
        login(user);
        Assert.assertNotNull("Login failed " + user.getEmail() + " " + user.getPassword(), token);
    }
}
