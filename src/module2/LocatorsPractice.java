package module2;



    /*
     * To identify if a locator that we use is unique
     * We will open in our DOM the search selector box
     * We can do it by:
     * Win - Ctrl + F
     * MAC - Command + F
     * */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            // Your driver receives the html from the server and lands there
            driver.get("http://dev-hrm.yoll.io/");

            // findElement is a method that will look for a specific web element in the html
            // however, by itself it cannot do it
            // we will need to provide a locator inside
            // By.id, By.name
            Thread.sleep(1000);

            WebElement usernameInput = driver.findElement(By.name("txtUsername"));
            WebElement passwordInput = driver.findElement(By.name("txtPassword"));

            // type something in the input box
            // webElement.sendKeys();
            usernameInput.sendKeys("username123");
            Thread.sleep(2000);

            //need to clear the input box to enter a new one
            usernameInput.clear();
            Thread.sleep(2000);

            usernameInput.sendKeys("yoll-student");
            Thread.sleep(3000);

            passwordInput.sendKeys("Bootcamp5#");
            Thread.sleep(4000);

            // This expression returns a WebElement type
            // Option 1: Locate the element and store into a object
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            loginButton.click();

//        // Option 2: Use expression directly
//        driver.findElement(By.id("btnLogin")).click();


            Thread.sleep(4000);

            driver.quit();

        }

    }

