import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.CatalogPage;
import pages.LoginPage;

public class AddCategoryToAdminTest extends BaseTest {

    public void addCategoryToAdmin(){
        LoginPage loginPage = new LoginPage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        loginPage.openAdminURL();
        // login
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        // add new category
        catalogPage.clickCatalogButton();
        catalogPage.clickCategoryButton();
        catalogPage.clickAddNewCategoryButton();
        catalogPage.addNewCategory();
        catalogPage.checkSuccessMessage();
        catalogPage.refreshPage();
        catalogPage.clickCatalogButton();
        catalogPage.clickCategoryButton();
        catalogPage.searchCreatedCategory();
        catalogPage.waitForCategoryIsDisplayed();
        // logout
        loginPage.clickToHeaderMenu();
        loginPage.clickToLogoutButton();
        // close driver
        closeChromeDriver();

    }
}
