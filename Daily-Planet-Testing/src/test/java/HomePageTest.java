import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void homepageHasCorrectTitle() {
        driver.get("http://localhost:5173"); // your frontend's local URL
        assertEquals("The Daily Planet", driver.getTitle());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
