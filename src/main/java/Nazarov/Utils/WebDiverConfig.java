package Nazarov.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.io.File;

/**
 * Created by Sergei_Shatilov on 11/13/2015.
 */
@Component
public class WebDiverConfig {

    public static WebDriver setFirefoxPofile(){

        FirefoxProfile profile = new FirefoxProfile();
        File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);

        profile.setPreference("capability.policy.policynames", "strict");
        profile.setPreference("capability.policy.strict.Window.alert", "noAccess");
        profile.setPreference("capability.policy.strict.Window.confirm", "noAccess");
        profile.setPreference("capability.policy.strict.Window.prompt", "noAccess");
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("javascript.enabled", true);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        capabilities.setCapability(FirefoxDriver.BINARY,ffBinary);
        capabilities.setBrowserName("firefox");
        WebDriver driver = WebDriverFactory.getDriver(capabilities);
        return driver;
    }

}
