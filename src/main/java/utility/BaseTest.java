package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        String url = "https://omada.net";
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterMethod
    public void teardown(ITestResult itr) {
        String methodName = itr.getMethod().getMethodName();
        boolean testPassed = true;
        if (itr.getStatus() == ITestResult.FAILURE) {
            testPassed = false;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        StringBuilder msg = new StringBuilder(formatter.format(date) + " Finished " + methodName + " - ");
        if (testPassed) {
            msg.append("passed.");
        } else {
            msg.append("FAILED");
            Throwable t = itr.getThrowable();
            if (t != null) {
                String n1 = System.getProperty("line.separator");
                msg.append(n1);
                msg.append("   ");
                msg.append(t.toString());
                if (!(t instanceof org.testng.internal.thread.ThreadExecutionException)) {
                    for (StackTraceElement e : t.getStackTrace()) {
                        msg.append(n1);
                        msg.append("   ");
                        msg.append(e.toString());
                    }
                }
            }
        }
        File log = new File("log.txt");
        try {
            if (!log.exists()) {
                log.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(log, true);
            fileWriter.write(msg + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
