import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AstronomyPageTest {

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void astronomyPageLocationRefresh() {
        driver.get("http://localhost:5173/");
        WebElement astronomyLink = driver.findElement(By.cssSelector("a.navbar-link[href='/astronomy']"));
        astronomyLink.click();

        assertEquals("http://localhost:5173/astronomy", driver.getCurrentUrl());
    }

    @Test
    void refreshLocationButtonIsPresent() {
        driver.get("http://localhost:5173/astronomy");

        WebElement refreshButton = driver.findElement(By.xpath("//button[contains(text(), 'Refresh Location')]"));
        assertTrue(refreshButton.isDisplayed());
    }

    @Test
    void exploreMoonPhaseButtonIsPresent() {
        driver.get("http://localhost:5173/astronomy");

        WebElement moonPhaseButton = driver.findElement(By.xpath("//button[text()='Explore Moon Phase']"));
        assertTrue(moonPhaseButton.isDisplayed());
    }

    @Test
    void generateStarChartButtonIsPresent() {
        driver.get("http://localhost:5173/astronomy");

        WebElement starChartButton = driver.findElement(By.xpath("//button[text()='Generate Star Chart']"));
        assertTrue(starChartButton.isDisplayed());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}