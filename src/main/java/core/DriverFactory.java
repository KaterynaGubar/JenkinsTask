package core;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://10.23.14.235:4445/grid/register/"), getBrowserName(browser));
    }

    private static DesiredCapabilities getBrowserName(String browserType) {
        switch (browserType) {
            case "firefox":
                System.out.println("Opening firefox driver");
                return DesiredCapabilities.firefox();
            case "chrome":
                System.out.println("Opening chrome driver");
                return DesiredCapabilities.chrome();
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
                return DesiredCapabilities.firefox();
        }
    }
}
