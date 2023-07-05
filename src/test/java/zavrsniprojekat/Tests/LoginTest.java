package zavrsniprojekat.Tests;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniprojekat.Base.BaseTest;
import zavrsniprojekat.Pages.*;

public class LoginTest extends BaseTest {

    public LoginpagePage loginpagePage;
    public ProductspagePage productspagePage;
    public YourCartpagePage yourCartpagePage;
    public SideBarPage sideBarPage;
    public YourInformationpagePage yourInformationpagePage;
    public OverwievpagePage overwievpagePage;
    public DetailsContainerPage detailsContainerPage;
    public CompletePage completePage;

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);

        loginpagePage = new LoginpagePage();
        productspagePage = new ProductspagePage();
        detailsContainerPage = new DetailsContainerPage();
        yourCartpagePage = new YourCartpagePage();
        sideBarPage = new SideBarPage();
        yourInformationpagePage = new YourInformationpagePage();
        overwievpagePage = new OverwievpagePage();
        completePage = new CompletePage();
    }

    @Test
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Sheet1", 1, 2);
        String validPassword = excelReader.getStringData("Sheet1", 2, 2);
        loginpagePage.insertUsername(validUsername);
        loginpagePage.insertPassword(validPassword);
        loginpagePage.clickOnLoginButton();
        Assert.assertEquals(productspagePage.productsTitle.getText(), "Products");
        Assert.assertTrue(productspagePage.shoppingCartIcon.isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        String invalidUsername = excelReader.getStringData("Sheet1", 5, 2);
        String validPassword = excelReader.getStringData("Sheet1", 6, 2);
        loginpagePage.insertUsername(invalidUsername);
        loginpagePage.insertPassword(validPassword);
        loginpagePage.clickOnLoginButton();
        Assert.assertTrue(loginpagePage.errorMessage.isDisplayed());
        Assert.assertEquals(loginpagePage.errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void userCannotLogInWithInvalidPassword() {
        String validUsername = excelReader.getStringData("Sheet1", 9, 2);
        String invalidPassword = excelReader.getStringData("Sheet1", 10, 2);
        loginpagePage.insertUsername(validUsername);
        loginpagePage.insertPassword(invalidPassword);
        loginpagePage.clickOnLoginButton();
        Assert.assertTrue(loginpagePage.errorMessage.isDisplayed());
        Assert.assertEquals(loginpagePage.errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    @Test
    public void presenceOfAllProductsPageElements() {
        userCanLogIn();
        Assert.assertTrue(productspagePage.productsTitle.isDisplayed());
        Assert.assertTrue(productspagePage.officialLogo.isDisplayed());
        Assert.assertTrue(productspagePage.inventoryItemsPairedByTwo.isDisplayed());
        Assert.assertTrue(productspagePage.dropDownContainer.isDisplayed());
        Assert.assertTrue(productspagePage.twitterLink.isDisplayed());
        Assert.assertTrue(productspagePage.facebookLink.isDisplayed());
        Assert.assertTrue(productspagePage.linkedinLink.isDisplayed());
    }

    @Test
    public void addProductToShoppingCartViaDetailsContainer() throws InterruptedException {
        String productExample1 = excelReader.getStringData("Sheet1", 2, 4);
        userCanLogIn();
        productspagePage.clickOnSpecificInventoryItem(productExample1);
        Assert.assertTrue(detailsContainerPage.productDetailsContainer.isDisplayed());
        Assert.assertTrue(detailsContainerPage.backToProductsButton.isDisplayed());
        productspagePage.clickOnAddToCartButton();
        Assert.assertTrue(detailsContainerPage.roundBadgeOnShoppingCart.isDisplayed());
        boolean addToCartButtonInContainer = false;
        try {
            addToCartButtonInContainer = productspagePage.addToCartButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(addToCartButtonInContainer);

        detailsContainerPage.roundBadgeOnShoppingCart.click();
        Assert.assertEquals(yourCartpagePage.yourCartPageTitle.getText(), "Your Cart");
        Assert.assertEquals(yourCartpagePage.inventoryItemName.getText(), productExample1);
        Assert.assertTrue(yourCartpagePage.checkoutButton.isDisplayed());

        resetAppState();

    }

    @Test
    public void addMultipleProductsToShoppingCartViaDetailsContainer() throws InterruptedException {
        //----------first product---------------------------------------------
        String productExample1 = excelReader.getStringData("Sheet1", 2, 4);
        userCanLogIn();
        productspagePage.clickOnSpecificInventoryItem(productExample1);
        Assert.assertTrue(detailsContainerPage.productDetailsContainer.isDisplayed());
        Assert.assertTrue(detailsContainerPage.backToProductsButton.isDisplayed());
        productspagePage.clickOnAddToCartButton();
        Assert.assertEquals(detailsContainerPage.roundBadgeOnShoppingCart.getText(), String.valueOf(1));
        boolean addToCartButtonInContainer = false;
        try {
            addToCartButtonInContainer = productspagePage.addToCartButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(addToCartButtonInContainer);

        //----------second product--------------------------------------------
        String productExample2 = excelReader.getStringData("Sheet1", 4, 4);
        detailsContainerPage.backToProductsButton.click();
        productspagePage.clickOnSpecificInventoryItem(productExample2);
        Assert.assertTrue(detailsContainerPage.productDetailsContainer.isDisplayed());
        Assert.assertTrue(detailsContainerPage.backToProductsButton.isDisplayed());
        productspagePage.clickOnAddToCartButton();
        Assert.assertEquals(detailsContainerPage.roundBadgeOnShoppingCart.getText(), String.valueOf(2));
        boolean addToCartButtonInContainer1 = false;
        try {
            addToCartButtonInContainer1 = productspagePage.addToCartButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(addToCartButtonInContainer1);

        detailsContainerPage.roundBadgeOnShoppingCart.click();
        Assert.assertEquals(detailsContainerPage.inventoryItemName.getText(), productExample1);
        //---drugi element u korpi ne znam da asertujem
        //Assert.assertEquals(detailsContainerPage.inventoryItemName.getText(), productExample2);

        resetAppState();
    }

    @Test
    public void addProductToShoppingCartDirectlyFromProductsPage() throws InterruptedException {
        userCanLogIn();
        productspagePage.specificElement.click();
        Assert.assertEquals(productspagePage.shoppingCartBadgeFromProductsPage.getText(), String.valueOf(1));
        boolean addToCartButtonInContainer1 = false;
        try {
            addToCartButtonInContainer1 = productspagePage.specificElement.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(addToCartButtonInContainer1);

        productspagePage.clickOnShoppingCartIcon();
        Assert.assertEquals(yourCartpagePage.yourCartPageTitle.getText(), "Your Cart");
        Assert.assertTrue(yourCartpagePage.checkoutButton.isDisplayed());
        Assert.assertEquals(yourCartpagePage.inventoryItemName.getText(), "Sauce Labs Fleece Jacket");
        resetAppState();
    }

    @Test
    public void enterValidPersonalInformations() throws InterruptedException {
        addProductWithoutReseting();
        String productExample1 = excelReader.getStringData("Sheet1", 2, 4);

        String ime = excelReader.getStringData("Sheet1", 2, 9);
        String prezime = excelReader.getStringData("Sheet1", 3, 9);
        int postal = excelReader.getIntegerData("Sheet1", 4, 9);

        yourCartpagePage.clickOnCheckoutButton();
        Assert.assertTrue(yourInformationpagePage.firstNameInputField.isDisplayed());
        Assert.assertTrue(yourInformationpagePage.lastNameInputField.isDisplayed());
        Assert.assertTrue(yourInformationpagePage.postalCodeInputField.isDisplayed());

        yourInformationpagePage.insertFirstname(ime);
        yourInformationpagePage.insertLastname(prezime);
        yourInformationpagePage.insertPostalCode(postal);
        yourInformationpagePage.continueButton.click();

        Assert.assertEquals(overwievpagePage.overviewPageTitle.getText(), "Checkout: Overview");
        Assert.assertEquals(overwievpagePage.inventoryItemName.getText(), productExample1);
        Assert.assertTrue(overwievpagePage.finishButton.isDisplayed());

        resetAppState();
    }

    @Test
    public void userCannotProceedeWithoutPersonalInformations() throws InterruptedException {
        addProductWithoutReseting();

        yourCartpagePage.checkoutButton.click();

        Assert.assertTrue(yourInformationpagePage.firstNameInputField.isDisplayed());
        Assert.assertTrue(yourInformationpagePage.lastNameInputField.isDisplayed());
        Assert.assertTrue(yourInformationpagePage.postalCodeInputField.isDisplayed());

        yourInformationpagePage.continueButton.click();

        Assert.assertEquals(yourInformationpagePage.errorMessage.getText(), "Error: First Name is required");
    }
    @Test
    public void finishOrderingProduct() throws InterruptedException {
        enterValidPersonalInformations();

        overwievpagePage.finishButton.click();
        Assert.assertEquals(completePage.completePageTitle.getText(), "Checkout: Complete!");
        Assert.assertEquals(completePage.successMessage.getText(), "Thank you for your order!");
        Assert.assertTrue(completePage.backToProductsButton.isDisplayed());
    }


  //--------------pomocna metoda----------------------------
    public void resetAppState() throws InterruptedException {
        productspagePage.hamburgerButton.click();
        //wait.until(ExpectedConditions.elementToBeClickable(sideBarPage.resetAppStateButton));
        //wait.until(ExpectedConditions.visibilityOf(sideBarPage.resetAppStateButton));
        Thread.sleep(1000);
        sideBarPage.resetAppStateButton.click();
    }
  //--------------pomocna metoda------------------------------
    public void addProductWithoutReseting() throws InterruptedException {
        String productExample1 = excelReader.getStringData("Sheet1", 2, 4);
        userCanLogIn();
        productspagePage.clickOnSpecificInventoryItem(productExample1);
        Assert.assertTrue(detailsContainerPage.productDetailsContainer.isDisplayed());
        Assert.assertTrue(detailsContainerPage.backToProductsButton.isDisplayed());
        productspagePage.clickOnAddToCartButton();
        Assert.assertTrue(detailsContainerPage.roundBadgeOnShoppingCart.isDisplayed());
        boolean addToCartButtonInContainer = false;
        try {
            addToCartButtonInContainer = productspagePage.addToCartButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(addToCartButtonInContainer);

        detailsContainerPage.roundBadgeOnShoppingCart.click();
        Assert.assertEquals(yourCartpagePage.yourCartPageTitle.getText(), "Your Cart");
        Assert.assertEquals(yourCartpagePage.inventoryItemName.getText(), productExample1);
        Assert.assertTrue(yourCartpagePage.checkoutButton.isDisplayed());

    }


}
