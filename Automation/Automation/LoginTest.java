
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    ChromeDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoblaze.com/");
    }

    @Test
    public void loginTest() {

        WebElement login = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login2"))
        );
        login.click();

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        username.sendKeys("YOUR_USERNAME");

        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))
        );
        password.sendKeys("YOUR_PASSWORD");

        WebElement loginButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
                )
        );
        loginButton.click();
    }
}
