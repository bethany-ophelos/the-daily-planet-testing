import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePageTest {

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void homepageHasCorrectTitle() {
        driver.get("http://localhost:5173/");
        assertEquals("The Daily Planet", driver.getTitle());
    }

    @Test
    void apodImageIsPresent() {
        driver.get("http://localhost:5173/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.apod-image")));

        assertTrue(image.isDisplayed());
    }

    @Test
    void saveToFavouritesButtonIsPresent() {
        driver.get("http://localhost:5173/");

        WebElement favouriteButton = driver.findElement(By.cssSelector("button[data-testid='favourite-button']"));
        assertTrue(favouriteButton.isDisplayed());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
