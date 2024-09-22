import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.opentelemetry.sdk.logs.data.Body.string;

public class SeleniumTest {
    public static ChromeOptions options;

    public static WebDriver driver;

    @BeforeTest
    public static void setup(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
    }
    
    @Test
    void TestSteps()
    {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//li[text()='Sign In Portal']")).click();
        driver.findElement(By.xpath("//input[@id='usr']")).sendKeys("sa");
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("sa");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement webElement = driver.findElement(By.xpath("//h3[text()='Formal Shoes']"));

        String actualFirstCategory = webElement.getText();

        String expectedFirstCategory = "Formal Shoes";

        Assert.assertEquals(expectedFirstCategory, actualFirstCategory);

    if(actualFirstCategory.equals(expectedFirstCategory))
    {
        System.out.println("Found: The actual category matches the expected category.");
    } else {
        System.out.println("Not Found: The actual category does not match the expected category.");
    }

        driver.close();




    }


}
