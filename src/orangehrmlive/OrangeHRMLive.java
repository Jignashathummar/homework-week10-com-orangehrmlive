package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl = "https://opensource-demo.orangehrmlive.com/"
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class OrangeHRMLive {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;
    static String browser = "Chrome";

    public static void main(String[] args) {
        //Launch the Chrome Browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser");
        }
        //Get base URL
        driver.get(baseUrl);
        //Maximise the Browser
        driver.manage().window().maximize();
        String title = driver.getTitle();

        //Get the title of the Page.
        System.out.println("Title: " + title);

        //Get current URL
        System.out.println("The current URL : " + driver.getCurrentUrl());

        //Get Page source
        System.out.println("Page source : " + driver.getPageSource());

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Click on ‘Forgot your password?’ link
        WebElement forgotlink = driver.findElement(By.cssSelector("p[class^='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotlink.click();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get current URL
        System.out.println("The current URL : " + driver.getCurrentUrl());

        //back page
        driver.navigate().back();
        System.out.println("Get current Url " + driver.getCurrentUrl());
        driver.navigate().refresh();

        //Enter username field
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        //Enter password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        //Click on login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[class^='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();

        //close browser
        driver.quit();
    }
}
