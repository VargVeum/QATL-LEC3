import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver;

    public BasePage() {
        initChromeDriver();
    }

    public void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", BasePage.class.getResource(getDriverFileName()).getPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private String getDriverFileName() {
        String browserType = System.getProperty("browser.name");

        if(browserType.equals("Firefox"))
            return"chromedriver";
        if(browserType.equals("Chrome"))
            return"chromedriver.exe";
        if(browserType.equals("IE"))
            return"chromedriver.exe";
        return"chromedriver";
    }

    public void waitForElementsCount(By locator, int count) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
    }


    public void closeChromeDriver() {
        driver.close();
    }

    public void openAdminURL() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    }

    public void clickToLogoutButton() {
        WebElement logoutButton = driver.findElement(By.id("header_logout"));
        logoutButton.click();
    }

    public void clickToHeaderMenu() {
        WebElement userMenu = driver.findElement(By.id("header_employee_box"));
        userMenu.click();
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.name("submitLogin"));
        loginButton.click();
    }

    public void enterPassword() {
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("Xcg7299bnSmMuRLp9ITw");
    }

    public void enterLogin() {
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys("webinar.test@gmail.com");
    }


}
