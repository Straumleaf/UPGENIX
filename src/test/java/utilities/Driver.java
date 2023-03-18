package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    // limiting access to the object
    private Driver(){}
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() throws RuntimeException {

        if(driverPool.get() == null){

            // reading type of browser from config properties
            String browserType = ConfigReader.getProperty("browser");
            String driverPath = ConfigReader.getProperty("driver_path");
            String browserOptions = ConfigReader.getProperty("browser_options");

            // choosing the right driver type as per config settings
            switch (browserType){

                case "chrome":
                    if (!driverPath.equals("")) System.setProperty("webdriver.chrome.driver", driverPath);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    //chromeOptions.addArguments(browserOptions);
                    //chromeOptions.setBinary("C:/Program Files/ChromeDriver/");
                    chromeOptions.addArguments("--headless");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;

                case "edge":
                    if (!driverPath.equals("")) System.setProperty("webdriver.edge.driver", driverPath);
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments(browserOptions);
                    driverPool.set(new EdgeDriver(edgeOptions));
                    break;

                default:
                    throw new RuntimeException("There is no such driver as " + browserType + " or config file error!");
            }

            driverPool.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        return driverPool.get();
    }

    // this method make sure our driver value is always null after using quit() method
    public static void closeDriver(){

        if(driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }

}