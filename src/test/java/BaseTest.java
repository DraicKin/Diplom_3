import io.qameta.allure.Step;
import models.pages.LoginPage;
import models.User;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;

public class BaseTest {
    private final static String URI = "https://stellarburgers.nomoreparties.site/api/auth/";
    protected WebDriver driver = new ChromeDriver();
    protected String token;
    @After
    public void closeDriver(){
        if (token != null) {
            given()
                    .header("Authorization", token)
                    .when()
                    .delete(URI + "user")
                    .then()
                    .statusCode(HTTP_ACCEPTED);
        }
        driver.quit();
    }

    @Step("Авторизация пользователя")
    public void login(User user){
        ((WebStorage) driver).getLocalStorage().clear();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
        token = ((WebStorage) driver).getLocalStorage().getItem("accessToken");
    }

}
