package Selenium_CuoiKi_Nhom1.Login_Unit_Testcases;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Check the email contain special character
 * Test step:
 * 1. Go to: https://giaybom.com/
 * 2. Click Log in
 * 3. In email field, enter "anh!@#@gmail.com" and fill all other field
 * 4. Click Submit and verify
 */

@Test
public class TC31 {
    public static void tc31(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1: Goto https://giaybom.com/
            driver.get("https://giaybom.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            //Step 2: Click Register button
            WebElement loginBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > header:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(2)"))));
            loginBtn.click();
            //Step 3:


            //3.1 fill email:
            WebElement fieldEmail = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("CustomerEmail"))));
            fieldEmail.sendKeys("anh!@#@gmail.com");

            //3.5 fill password:
            WebElement fieldPassword = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("CustomerPassword"))));
            fieldPassword.sendKeys("123456");

            Thread.sleep(3000);

            //Step 4: Click Submit
            WebElement SubmitBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[value='Đăng nhập']"))));
            SubmitBtn.click();
            //Verify Register status
            String currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);
            if(currentURL.equals("https://giaybom.com/account/login")){
                System.out.println("Đăng nhập chưa thành công!!!");
            }else if(currentURL.equals("https://giaybom.com/account")){
                System.out.println("Đã đăng nhập!!!");
            }
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Fail!!!");
        }
        driver.close();
        driver.quit();
    }
}
