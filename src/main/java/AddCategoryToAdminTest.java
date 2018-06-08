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
        catalogPage.checkDashboard();
        catalogPage.checkCatalog();















        // logout
        loginPage.clickToHeaderMenu();
        loginPage.clickToLogoutButton();

        loginPage.closeChromeDriver();

    }





}
