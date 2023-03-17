package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserTools {

    public static void sleep (int seconds) {

        // this method accept int in sec as an argument
        // and execute Thread.sleep for given duration

        try {
            Thread.sleep(seconds * 1000L);
        }catch (InterruptedException e) { }

    }

    public static void awaitingInvisibilityOf(WebElement webElement){

        // creating a utility method for ExplicitWait to avoid lines repeating

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }


}
