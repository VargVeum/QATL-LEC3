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
        WebElement successMessage = driver.findElements(By.cssSelector("div.alert.alert-success")).get(0);
        Assert.assertTrue(successMessage.isDisplayed(), "Сообщение об успешном создании продукта не появилось");
        Assert.assertEquals(successMessage.getText(), "×\nСоздано");
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

    public void clickCatalogButton(){
        WebElement catalogButton = driver.findElement(By.id("subtab-AdminCatalog"));
        catalogButton.click();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }



    public void waitForCategoryIsDisplayed(){
        String categoryNameOnThePage = driver.findElement(By.cssSelector("tbody tr td:nth-child(3)")).getText();
        Assert.assertEquals(categoryNameOnThePage, categoryNameOnThePage, "Category is absent on the page!");
    }

}


