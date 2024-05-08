import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResolutionTesting {

    // Function to create directory if not exists
    public static void createDirectory(String directory) {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    // Function to take screenshot and save it
    public static void takeScreenshot(WebDriver driver, String folderPath) {
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            File screenshotFile = new File(folderPath + "/Screenshot-" + timestamp + ".png");
            Files.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath(), screenshotFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to run test
    public static void runTest(String browser, Map<String, String> urls, Map<String, Dimension> resolutions) {
        WebDriver driver = null;
        try {
            if ("chrome".equals(browser)) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver();

                String browserFolder = "Screenshots/CHROME";
                createDirectory(browserFolder);

                for (Map.Entry<String, String> entry : urls.entrySet()) {
                    String url = entry.getValue();
                    driver.get(url);

                    String urlFolder = browserFolder + "/" + entry.getKey();
                    createDirectory(urlFolder);

                    for (Map.Entry<String, Dimension> resolutionEntry : resolutions.entrySet()) {
                        String resolution = resolutionEntry.getKey();
                        Dimension dimension = resolutionEntry.getValue();

                        String resolutionFolder = urlFolder + "/" + resolution;
                        createDirectory(resolutionFolder);

                        driver.manage().window().setSize(dimension);
                        takeScreenshot(driver, resolutionFolder);
                    }
                }
            } else {
                throw new IllegalArgumentException("Invalid browser name");
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> urls = new HashMap<>();
        urls.put("Homepage", "https://www.getcalley.com/");
        urls.put("Call from Browser", "https://www.getcalley.com/calley-call-from-browser/");
        urls.put("Pro Features", "https://www.getcalley.com/calley-pro-features/");
        urls.put("Best Auto Dialer App", "https://www.getcalley.com/best-auto-dialer-app/");
        urls.put("How Calley Auto Dialer App Works", "https://www.getcalley.com/how-calley-auto-dialer-app-works/");

        Map<String, Dimension> desktopResolutions = new HashMap<>();
        desktopResolutions.put("1920x1080", new Dimension(1920, 1080));
        desktopResolutions.put("1366x768", new Dimension(1366, 768));
        desktopResolutions.put("1536x864", new Dimension(1536, 864));

        Map<String, Dimension> mobileResolutions = new HashMap<>();
        mobileResolutions.put("360x640", new Dimension(360, 640));
        mobileResolutions.put("414x896", new Dimension(414, 896));
        mobileResolutions.put("375x667", new Dimension(375, 667));

        runTest("chrome", urls, desktopResolutions);
        runTest("chrome", urls, mobileResolutions);
    }
}
