import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ISSPageTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    void navigateToISSPageFromHomePage() {
        driver.get("http://localhost:5173");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the ISS link in the navigation bar
        WebElement issLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("ISS"))
        );
        issLink.click();

        // Wait for the Refresh Location button to appear
        WebElement refreshButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[contains(text(), 'Refresh Location')]")

                )
        );

        // Verifies URL changed to the ISS route
        assertEquals("http://localhost:5173/iss", driver.getCurrentUrl());
        assertTrue(refreshButton.isDisplayed());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
