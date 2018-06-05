import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCategoryToAdminTest extends BasePage {

    public void addCategoryToAdmin(){
        openAdminURL();
        // login
        enterLogin();
        enterPassword();
        clickLoginButton();
        // add new category
        checkDashboard();
        checkCatalog();
        WebElement categoryButton = driver.findElement(By.cssSelector("li[data-submenu='11']"));
        categoryButton.click();
        WebElement addNewCategoryButton = driver.findElement(By.id("page-header-desc-category-new_category"));
        addNewCategoryButton.click();
        WebElement categoryNameField = driver.findElement(By.id("name_1"));

        String categoryName = "MartynenkoTestCategory";
        categoryNameField.sendKeys(categoryName);
        categoryNameField.submit();
        // verify that new category successfully added
        boolean successMessage = driver.findElement(By.className("alert alert-success")).isDisplayed();
        // search new category
        WebElement searchFieldByName = driver.findElement(By.cssSelector("input[name='categoryFilter_name']"));
        searchFieldByName.sendKeys("MartynenkoTestCategory");
        WebElement searchButton = driver.findElement(By.id("submitFilterButtoncategory"));
        searchButton.click();

        waitForElementsCount(By.cssSelector("tbody tr"), 1);

        String categoryNameOnThePage = driver.findElement(By.cssSelector("tbody tr td:nth-child(3)")).getText();
        Assert.assertEquals(categoryNameOnThePage, categoryName, "Category is absent on the page!");












        // logout
        clickToHeaderMenu();
        clickToLogoutButton();

        closeChromeDriver();

    }


    private void checkDashboard() {
        WebElement dashboardButton = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
        dashboardButton.click();
        Assert.assertEquals("Dashboard • prestashop-automation", driver.getTitle());
        driver.navigate().refresh();
        Assert.assertEquals("Dashboard • prestashop-automation", driver.getTitle());
    }

    private static void checkCatalog() {
        WebElement catalogButton = driver.findElement(By.xpath("//span[contains(text(),'Каталог')]"));
        catalogButton.click();
        Assert.assertEquals("товары • prestashop-automation", driver.getTitle());
        driver.navigate().refresh();
        Assert.assertEquals("товары • prestashop-automation", driver.getTitle());
    }


}
