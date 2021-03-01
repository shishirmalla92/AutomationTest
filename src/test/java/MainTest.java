import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class MainTest {

    private WebDriver driver;

    @Test
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\shish\\Downloads\\chromedriver_win32_new\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://dev.archipro.co.nz");
        driver.manage().window().maximize();
        WebElement signInButton = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/header/div[1]/div/div[2]/nav[2]/ul/li[2]/a"));
        Thread.sleep(5000);
        signInButton.click();
        Thread.sleep(5000);
        WebElement email= driver.findElement(By.name("email"));
        WebElement password=driver.findElement(By.name("password"));
        email.sendKeys("shishir@archipro.co.nz");
        password.sendKeys("ArchiPro@2020");
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div[2]/div/div[1]/div/section/div/div/div/div[2]/form/div/div[3]/input"));
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"ArchiPro - Build your Dream Project");
        WebElement profileDropdown = driver.findElement(By.className("navbar-action-profile--arrow"));
        profileDropdown.click();
        Thread.sleep(2000);
        WebElement logOutButton = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div/header/div[1]/div/div[2]/div[2]/div[2]/ul/li[7]/div/a"));
        logOutButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"ArchiPro - where beautifully designed spaces begin");
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
