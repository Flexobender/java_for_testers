package ru.nsd.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper group;
    private ContactHelper contact;
    public Properties properties;
    private JdbcHelper jdbc;
    private HibernateHelper hbm;

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (group == null) {
            group = new GroupHelper(this);
        }
        return group;
    }

    public ContactHelper contact() {
        if (contact == null) {
            contact = new ContactHelper(this);
        }
        return contact;
    }

    public JdbcHelper jdbc() {
        if (jdbc == null) {
            jdbc = new JdbcHelper(this);
        }
        return jdbc;
    }
    public HibernateHelper hbm() {
        if (hbm == null) {
            hbm = new HibernateHelper(this);
        }
        return hbm;
    }



    public void init(String browser, Properties properties) {
        this.properties = properties;
        if (driver == null) {
            if (browser.equals("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equals("edge")) {
                driver = new EdgeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1564, 823));
            session().login(properties.getProperty("web.username"), properties.getProperty("web.password"));
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
