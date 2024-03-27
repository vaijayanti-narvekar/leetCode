package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    // public void testCase01(){
    // System.out.println("Start Test case: testCase01");
    // driver.get("https://www.google.com");
    // System.out.println("end Test case: testCase02");
    // }

    public static void logStatus(String type, String message, String status) {

        System.out.println(String.format("%s |  %s  |  %s | %s", String.valueOf(java.time.LocalDateTime.now()), type,
                message, status));
    }

    // TestCase01: Verify the Leetcode Homepage URL
    public void TestCase01() {
        boolean status = true;
        System.out.println("Start Test case: TestCase01");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://leetcode.com/");
        if (driver.getCurrentUrl().contains("leetcode")) {
            logStatus("End TestCase :", "TestCase01: The URL of the Leetcode homepage contains 'leetcode' :",
                    status ? "Pass" : "Fail");
        } else {
            status = false;
            logStatus("End TestCase :", "TestCase01: The URL of the Leetcode homepage contains 'leetcode' :",
                    status ? "Pass" : "Fail");
        }

        System.out.println("End TestCase : TestCase01");

    }

    // TestCase02: Verify Problem Set URL and Display First 5 Questions
    /**
     * 
     */
    public void TestCase02() {
        boolean status = true;
        System.out.println("Start Test case: TestCase02");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[href='/problemset/'] p")).click();
        if (driver.getCurrentUrl().contains("problemset")) {
            logStatus("End TestCase :", "TestCase02: The URL of the Leetcode homepage contains 'problemset' :",
                    status ? "Pass" : "Fail");
        } else {
            status = false;
            logStatus("End TestCase :", "TestCase02: The URL of the Leetcode homepage contains 'problemset' :",
                    status ? "Pass" : "Fail");
        }
        List<String> expectedDetails = Arrays.asList("1. Two Sum", "2. Add Two Numbers",
                "3. Longest Substring Without Repeating Characters", "4. Median of Two Sorted Arrays",
                "5. Longest Palindromic Substring");
        List<WebElement> detailsList = driver.findElements(By.xpath("(//div[@role='rowgroup'])[2]/div/div[2]"));
        List<String> details = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            details.add(detailsList.get(i).getText());
        }
        if (!details.equals(expectedDetails)) {
            status = false;
            logStatus("End TestCase :", "TestCase02: The correct details of the problems are obtained and verified :",
                    status ? "Pass" : "Fail");
        } else {
            logStatus("End TestCase :", "TestCase02: The correct details of the problems are obtained and verified :",
                    status ? "Pass" : "Fail");
        }
        // System.out.println(details);

        System.out.println("End TestCase : TestCase02");

    }
    //TestCase03: Verify the Two Sum problem
    public void TestCase03() {
        boolean status = true;
        System.out.println("Start Test case: TestCase03");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='/problems/two-sum']")).click();
        if (driver.getCurrentUrl().contains("two-sum")) {
            logStatus("End TestCase :", "TestCase03: The URL of the problem contains 'two-sum':",
                    status ? "Pass" : "Fail");
        } else {
            status = false;
            logStatus("End TestCase :", "TestCase03: The URL of the problem contains 'two-sum':",
                    status ? "Pass" : "Fail");
        }

        System.out.println("End TestCase : TestCase03");

    }

    //TestCase04: Ensure the submissions tab displays "Register or Sign In"
    public void TestCase04() {
        boolean status = true;
        System.out.println("Start Test case: TestCase04");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='/problems/two-sum/submissions']")).click();
        String msg = driver.findElement(By.xpath("//div[(contains(@class,'gap'))]/a[contains(@href,'/accounts')]")).getText();
		if (msg.equalsIgnoreCase("Register or Sign In")){
            logStatus("End TestCase :", "The message 'Register or Sign In' is displayed when you click on the submissions tab.:",
                    status ? "Pass" : "Fail");
        }
		else{
			logStatus("End TestCase :", "The message 'Register or Sign In' is displayed when you click on the submissions tab.:",
                    status ? "Pass" : "Fail");
		}

        System.out.println("End TestCase : TestCase04");

    }
}
