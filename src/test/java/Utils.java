import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static void Scroll(WebDriver driver, int height){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, "+height+")");
    }

    public static int RandomPhnNumber(int max, int min){
        double RandomPhnNumber = Math.random()*(max-min)+min;
        return (int) RandomPhnNumber;
    }
}
