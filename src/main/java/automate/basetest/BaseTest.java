package automate.basetest;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.beans.DesignMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    public static Properties prop;
    public static WebDriver driver;


    public BaseTest() {

        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\abhishek.dubey\\IdeaProjects\\automateit\\src\\main\\java\\automate\\configuration\\config");
            prop.load(fis);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void launcher() {

        String browserName = prop.getProperty("browser");

        if ((browserName.equalsIgnoreCase("chrome"))) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.dubey\\IdeaProjects\\automateit\\drivers\\chromedriver.exe");


            if (prop.getProperty("mode").equals("--incognito")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(prop.getProperty("mode"));
                driver = new ChromeDriver(options);


                //code to connect with remote server using docker and aws

           /* driver = new ChromeDriver();
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", "chrome");
            try {
                driver = new RemoteWebDriver(new URL("http://16.171.38.179:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" chrome launched in incognito mode.. ");
            driver.get(prop.getProperty("url"));

            driver.manage().window().maximize();*/


            } else if (prop.getProperty("mode").equals("--default")) {

                driver = new ChromeDriver();
                System.out.println(" chrome launched in default mode.. ");
            }


        } else {


            System.out.println(" firefox launched.. ");

        }

        driver.get(prop.getProperty("url"));

        driver.manage().window().maximize();


    }


    public String getScreenshot(String filePath) throws IOException {


        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "reports" + filePath + ".png");
        FileUtils.copyFile(sourceFile, file);
        return filePath;
    }


}

