package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkSuccessMessage(){
        WebElement successMessage = driver.findElement(By.className("alert alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Сообщение об успешном создании продукта не появилось");
        Assert.assertEquals(successMessage.getText(), "\n\t\t\tСоздано\n\t\t");
    }

    public void searchCreatedCategory() {
        WebElement searchFieldByName = driver.findElement(By.cssSelector("input[name='categoryFilter_name']"));
        searchFieldByName.sendKeys("MartynenkoTestCategory");
        searchFieldByName.submit();
    }


    public void addNewCategory() {
        WebElement categoryNameField = driver.findElement(By.id("name_1"));
        String categoryName = "MartynenkoTestCategory";
        categoryNameField.sendKeys(categoryName);
        categoryNameField.submit();
    }

    public void clickAddNewCategoryButton() {
        WebElement addNewCategoryButton = driver.findElement(By.id("page-header-desc-category-new_category"));
        addNewCategoryButton.click();
    }

    public void clickCategoryButton() {
        WebElement categoryButton = driver.findElement(By.cssSelector("li[data-submenu='11']"));
        categoryButton.click();
    }

    public void waitForCategoryIsDisplayed(){
        String categoryNameOnThePage = driver.findElement(By.cssSelector("tbody tr td:nth-child(3)")).getText();
        Assert.assertEquals(categoryNameOnThePage, categoryNameOnThePage, "Category is absent on the page!");
    }

}


