package retry;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import context.TestContext;
import io.qameta.allure.Allure;
import utils.DriverManager;
import utils.ExtentReportsManager;
import utils.ExtentTestManager;
import utils.Takescreenshot;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    
    @Override
    public void onStart(ITestContext context) {
        ExtentReportsManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportsManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentReportsManager.getInstance()
                .createTest(result.getMethod().getMethodName());
        ExtentTestManager.setExtentTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getExtentTest()
                .pass("Name of Test Passed successfully is : " + result.getMethod().getMethodName());
        ExtentTestManager.removeExtentTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver(); // fetch driver from PicoContainer context
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        ExtentTestManager.getExtentTest().fail(result.getThrowable());

        String dest = System.getProperty("user.dir") + "/screenshots/"
                + result.getMethod().getMethodName() + "_" + timeStamp + ".png";
        try {
            Takescreenshot.takeShot(dest, driver);
            ExtentTestManager.getExtentTest().addScreenCaptureFromPath(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Attach screenshot to Allure
        byte[] screenshotBytes = Takescreenshot.takeShotAsBytes(driver);
        Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshotBytes));

        ExtentTestManager.removeExtentTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getExtentTest()
                .skip("Test skipped: " + result.getMethod().getMethodName());
        ExtentTestManager.removeExtentTest();
    }
}
