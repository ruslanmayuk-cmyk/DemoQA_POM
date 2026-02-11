package com.demoqa.core;

import com.demoqa.utils.MyListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    protected WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver start() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        // ChromeOptions  options = new ChromeOptions();

        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
        }

        WebDriverListener listener = new MyListener(driver);
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        // options.addArguments(" -- headless=new");
        // options.addArguments(" -- headless=new");// without opening a browser windows
        // options.addArguments(" -- windows-size=800,600");

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return driver;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();

        }
    }
}
