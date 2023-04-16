import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import models.User;
import models.UserGenerator;
import models.pages.RegisterPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationTests extends BaseTest{

    User user = UserGenerator.getRandom();
    @Before
    public void init() { //PUBLIC?
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Регистрация уникального пользователя")
    /* В отчёте тест падает, потому что хром не вернул токен. Раньше возвращал.
    Без токена тест не тест. Удаление не сработает.
    Токен нужен. Так что считаю это багом. */
    public void successfullRegistrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registration(user.getName(), user.getEmail(), user.getPassword());
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        token = ((WebStorage) driver).getLocalStorage().getItem("keyItem");
        Assert.assertNotNull("Registration failed", token);
    }

    @Test
    @DisplayName("Неуспешная регистрация пользователя: слишком короткий пароль")
    public void failsToRegisterWithShortPassword() {
        user.setPassword("1234");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registration(user.getName(), user.getEmail(), user.getPassword());
        token = ((WebStorage) driver).getLocalStorage().getItem("keyItem");
        Assert.assertNull("Registration failed", token);
        Assert.assertEquals("Not valid error message","Некорректный пароль", registerPage.getErrorMessage());
    }
}
