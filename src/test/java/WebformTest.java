import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebformTest {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headed");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("Check if submission is done")
    public void SubmitForm() throws InterruptedException {
        Faker faker = new Faker();

        String Name = faker.name().firstName();
        String Number = "0172" + Utils.RandomPhnNumber(1000000, 999999);
        String Email = Name.toLowerCase() + "@gmail.com";

        driver.get("https://www.digitalunite.com/practice-webform-learners");

        driver.findElement(By.id("ccc-notify-accept")).click();
        driver.findElement(By.id("edit-name")).sendKeys(Name);
        driver.findElement(By.id("edit-number")).sendKeys(Number);
        driver.findElement(By.id("edit-date")).sendKeys("01/02/2026");
        driver.findElement(By.id("edit-email")).sendKeys(Email);
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I am" + Name);

        Utils.Scroll(driver, 500);

        WebElement UploadImg = driver.findElement(By.id("edit-uploadocument-upload"));
        UploadImg.sendKeys(System.getProperty("user.dir") + "/src/test/resources/images.jpg");
        Thread.sleep(4000);

        driver.findElement(By.id("edit-age")).click();

        Utils.Scroll(driver, 300);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.attributeContains(By.id("recaptcha-anchor"), "aria-checked", "true"));
        System.out.println("Captcha solved! Continue Test");

        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        driver.findElement(By.id("edit-submit")).click();

        WebElement confirmationMsg = driver.findElement(By.tagName("h1"));
        String actualMsg = confirmationMsg.getText();
        String expectedMsg = "Thank you for your submission!";
        Assertions.assertTrue(actualMsg.contains(expectedMsg));
    }

    @AfterAll
    public void closeDriver() {
        driver.quit();
    }
}
