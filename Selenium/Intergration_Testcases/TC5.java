package Selenium_CuoiKi_Nhom1.Intergration_Testcases;


import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test edit information of user
 * Test Step:
 * 1. Goto https://giaybom.com/
 * 2. Click Log in button
 * 3. In log in form, enter email and password
 * 4. Click Submit button
 * 5. Click Xem địa chỉ
 * 6. Click Sửa
 * 7. Enter new Name, new address...
 * 8. Click Save
 * 9. Verify new information
 */

@Test
public class TC5 {
    public static void tc5(){
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
            fieldEmail.sendKeys("test6@gmail.com");

            //3.2 fill password:
            WebElement fieldPassword = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("CustomerPassword"))));
            fieldPassword.sendKeys("123456");

            //Step 4: Click Submit
            WebElement SubmitBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[value='Đăng nhập']"))));
            SubmitBtn.click();
            System.out.println("Đăng nhập thành công!!!");

            //Step 5: Click Xem địa chỉ:
            WebElement viewAddBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[href='/account/addresses']"))));
            viewAddBtn.click();

            //Step 6: Click Sửa
            WebElement editBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > div:nth-child(10) > main:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > p:nth-child(5) > a:nth-child(1)"))));
            editBtn.click();

            //Step 7: enter new Name, new Address,...
            WebElement oldFN = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='grid__item two-thirds medium-down--one-whole'] h3"))));
            String oldFullName = oldFN.getText();
            Thread.sleep(3000);
            WebElement fieldNewLastName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[2]/div[1]/div[1]/div[2]/input[1]"))));
            fieldNewLastName.sendKeys("New");
            //Step 8: Verify new information


            WebElement saveBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[2]/div[1]/p[2]/input[1]"))));
            saveBtn.click();
            WebElement backBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]"))));
            backBtn.click();
            //
            WebElement newFN = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".h5"))));
            String newFullName = newFN.getText();
            if(newFullName.equals(oldFullName+"New")){
                System.out.println("Updated Success!!!");
            }else{
                System.out.println("Updated Fail!!!");
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
