package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

public class SauceDemoPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        //maximize the window
        driver.manage().window().maximize();

//Locate web elements for login
        WebElement usernameInput = driver.findElement(By.xpath("//input[@data-test = 'username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));

        //Interact with the elements
        String username = "standard_user", password = "secret_sauce";
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        Thread.sleep(3000);

        // print in the console the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL after log in: " + currentUrl);

        WebElement sauceLabsBackpackAddToCartButton = driver.findElement(By.xpath("//button[@id = 'add-to-cart-sauce-labs-backpack']"));
        sauceLabsBackpackAddToCartButton.click();

        Thread.sleep(3000);

        WebElement sauceLabsTShirtAddToCartButton = driver.findElement(By.xpath("//button[@name = 'add-to-cart-sauce-labs-bolt-t-shirt']"));
        sauceLabsTShirtAddToCartButton.click();

        Thread.sleep(3000);


        //locate the cart button
        WebElement cartButton = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']"));
cartButton.click();

Thread.sleep(3000);


// verify that cart contains 2 items only
        List<WebElement> productsInCart = driver.findElements(By.xpath("//div[@class = 'cart_item']")); // 1

        // how do we verify
        int expectedItemsInCart = 2;
        int actualItemsInCart = productsInCart.size();

        if(expectedItemsInCart == actualItemsInCart){
            System.out.println("TEST: PASSED");
            System.out.println("Expected items in the cart: " + expectedItemsInCart);
            System.out.println("Actual items in the cart: " + actualItemsInCart);
        } else {
            System.err.println("TEST: FAILED");
            System.err.println("Expected items in the cart: " + expectedItemsInCart);
            System.err.println("Actual items in the cart: " + actualItemsInCart);
        }


        driver.quit();

    }

}