package zavrsniprojekat.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import zavrsniprojekat.Tests.LoginTest;

import java.io.IOException;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("C:\\Users\\djuki\\Desktop\\Untitled spreadsheet (6).xlsx");
        homeURL = excelReader.getStringData("Sheet1", 1, 0);
    }



}
