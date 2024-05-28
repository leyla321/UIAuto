package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollUtils {
    public ScrollUtils() {
    }

    public static void scrollBy(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")", new Object[]{""});
    }
}
