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
 * Test register an account
 * Test Step:
 * 1. Goto https://giaybom.com/
 * 2. Click Register button
 * 3. In register form, enter all field
 * 4. Click Submit button
 * 5. Check status
 */

@Test
public class TC1 {
    public static void tc1(){
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            //Step 1: Goto https://giaybom.com/
            driver.get("https://giaybom.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            System.out.println("Opened Website");

            //Step 2: Click Register button
            WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > header:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(2)"))));
            registerBtn.click();

            //Step 3: Fill all fields
            //3.1 fill first name:
            WebElement fieldFirstName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("FirstName"))));
            fieldFirstName.sendKeys("Cong Anh");

            //3.2 fill last name:
            WebElement fieldLastName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("LastName"))));
            fieldLastName.sendKeys("Huynh Phuc");

            //3.3 fill email:
            WebElement fieldEmail = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Email"))));
            fieldEmail.sendKeys("test7@gmail.com");

            //3.4 fill phone:
            WebElement fieldPhone = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Phone"))));
            fieldPhone.sendKeys("123123123");

            //3.5 fill password:
            WebElement fieldPassword = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("CreatePassword"))));
            fieldPassword.sendKeys("123");

            //Step 4: Click Submit
            WebElement SubmitBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[value='Đăng ký']"))));
            SubmitBtn.click();

            //Verify Register status
            String checkTitle = driver.getTitle();
            System.out.println(checkTitle);
            if(checkTitle.equals("Tạo tài khoản – giayBOM")){
                System.out.println("Đăng kí chưa thành công!!!");
            }else{
                System.out.println("Đã đăng kí!!!");
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
