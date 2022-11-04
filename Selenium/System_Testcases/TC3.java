package Selenium_CuoiKi_Nhom1.System_Testcases;


import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test login
 * Test Step:
 * 1. Goto https://giaybom.com/
 * 2. Click Log in button
 * 3. In log in form, enter email and password
 * 4. Click Submit button
 * 5. Check status
 */

@Test
public class TC3 {
    public static void tc3(){
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            //Step 1: Goto https://giaybom.com/
            driver.get("https://giaybom.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            System.out.println("Opened Website");

            //Step 2: Click Log in button
            WebElement loginBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > header:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(2)"))));
            loginBtn.click();

            //Step 3: Fill all fields

            //3.1 fill email:
            WebElement fieldEmail = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("CustomerEmail"))));
            fieldEmail.sendKeys("huynh@gmail.com");

            //3.2 fill password:
            WebElement fieldPassword = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("CustomerPassword"))));
            fieldPassword.sendKeys("123456");

            //Step 4: Click Submit
            WebElement SubmitBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[value='Đăng nhập']"))));
            SubmitBtn.click();

            //Verify Register status
            try{
                WebElement checkStatus = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='errors'] ul li"))));
                String checkValue = checkStatus.getText();
                System.out.println(checkValue);
                if(checkValue.equals("Thông tin đăng nhập không hợp lệ.")){
                    System.out.println("Đăng nhập thất bại !!!");
                }
            }catch(Exception e){
                System.out.println("Đăng nhập thành công!!!");
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
