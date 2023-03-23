package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    // limiting access to the object
    private Driver(){}
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() throws RuntimeException {

        if(driverPool.get() == null){

            // reading type of browser from config properties
            String browserType = ConfigReader.getProperty("browser");
            String driverLocalPath = ConfigReader.getProperty("local_driver_path");
            String driverRemotePath = ConfigReader.getProperty("remote_driver_path");

            if(Objects.nonNull(System.getProperty("BROWSER"))) {
                browserType = System.getProperty("BROWSER");
                System.out.println("Chosen system default browser.");
            }

            // choosing the right driver type as per config settings
            switch (browserType){

                case "chrome":
                    if (!driverLocalPath.equals("")) System.setProperty("webdriver.chrome.driver", driverLocalPath);
                    driverPool.set(new ChromeDriver(new ChromeOptions().addArguments("--incognito --remote-allow-origins=*")));
                    System.out.println("Successfully start Chrome Web Driver in incognito mode ...");
                    break;

                case "chrome-headless":
                    if (!driverLocalPath.equals("")) System.setProperty("webdriver.chrome.driver", driverLocalPath);
                    driverPool.set(new ChromeDriver(new ChromeOptions().addArguments("--headless --incognito --remote-allow-origins=*")));
                    System.out.println("Successfully start Chrome Web Driver in headless mode ...");
                    break;

                case "edge":
                    if (!driverLocalPath.equals("")) System.setProperty("webdriver.edge.driver", driverLocalPath);
                    driverPool.set(new EdgeDriver(new EdgeOptions().addArguments("--inprivate")));
                    System.out.println("Successfully start Edge Web Driver in private mode ...");
                    break;

                case "edge-headless":
                    if (!driverLocalPath.equals("")) System.setProperty("webdriver.edge.driver", driverLocalPath);
                    driverPool.set(new EdgeDriver(new EdgeOptions().addArguments("--inprivate --headless")));
                    System.out.println("Successfully start Edge Web Driver in headless mode ...");
                    break;

                case "chrome-remote":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    // removed due to deprecation in Selenium 4.0 and higher
                    // chromeOptions.setCapability("platform", Platform.ANY);
                    try {
                        driverPool.set(new RemoteWebDriver(new URL(driverRemotePath),chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to create remote session.");
                    }
                    System.out.println("Successfully start Chrome remote Web Driver ...");
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
            System.out.println("Web Driver successfully stopped.");
        }

    }

}