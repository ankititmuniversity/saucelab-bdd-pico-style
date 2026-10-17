package hooks;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import context.TestContext;
import utils.ConfigReader;
import utils.DriverManager;

public class Hooks {
    public static Logger logger = LogManager.getLogger(Hooks.class);

    private final TestContext testContext;

    // PicoContainer injects TestContext here
    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications", "--incognito");
            driver = new ChromeDriver(options);
        }
        // add Firefox/Edge branches here if needed

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get(ConfigReader.getProperty("url"));

        //set driver into TestContext
        testContext.setDriver(driver);
        DriverManager.setDriver(driver);
        logger.info("Driver initial set up Completed");
    }

    @After
    public void tearDown() {
        WebDriver driver = testContext.getDriver();
        if (driver != null) {
            driver.quit();
            testContext.setDriver(null); // clear reference
        }
        logger.info("All opened windows closed successfully");
    }
}
