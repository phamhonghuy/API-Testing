package Selenium_CuoiKi_Nhom1.Signup_Unit_Testcases;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Check Name cann't have special character
 * Test step:
 * 1. Go to: https://giaybom.com/
 * 2. Click Register
 * 3. In Name field, enter "anh!@#" and fill all other field
 * 4. Click Submit and verify
 */
@Test
public class TC11 {
    public static void tc11(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1: Goto https://giaybom.com/
            driver.get("https://giaybom.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            //Step 2: Click Register button
            WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > header:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(2)"))));
            registerBtn.click();
            //Step 3: In Name field, not enter and observe
                //3.1 fill first name:
            WebElement fieldFirstName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("FirstName"))));
            fieldFirstName.sendKeys("anh!@#");

                //3.2 fill last name:
            WebElement fieldLastName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("LastName"))));
            fieldLastName.sendKeys("Huynh Phuc");

                //3.3 fill email:
            WebElement fieldEmail = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Email"))));
            fieldEmail.sendKeys("jlashfa185asd3@gmail.com");

                //3.4 fill phone:
            WebElement fieldPhone = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Phone"))));
            fieldPhone.sendKeys("123123123");

                //3.5 fill password:
            WebElement fieldPassword = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("CreatePassword"))));
            fieldPassword.sendKeys("1234567");
            Thread.sleep(3000);
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
                System.out.println("Kiểm lỗi form không đạt yêu cầu!");
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
