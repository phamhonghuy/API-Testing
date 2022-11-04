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
 * Check Cart when change quantity a product in cart
 */

@Test
public class TC7 {
    public static void tc7(){
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

            //Step 5: Add a product to cart:
            WebElement homeBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[title='Quay trở về trang chủ']"))));
            homeBtn.click();
            WebElement viewProductBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[id='collection1'] div[class='grid-uniform md-mg-left-15'] div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) a:nth-child(1)"))));
            viewProductBtn.click();
            WebElement addProductBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]"))));
            addProductBtn.click();
            Thread.sleep(3000);
            WebElement oc = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]"))));
            String oldcost = oc.getText();
            System.out.println("old cost: "+oldcost);
            WebElement inputQuantity = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/input[1]"))));
            inputQuantity.sendKeys("1");
            WebElement updateCostBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/button[1]"))));
            updateCostBtn.click();
            Thread.sleep(3000);
            WebElement nc = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]"))));
            String newcost = nc.getText();
            System.out.println("new cost: "+newcost);




            //Verify
            if(oldcost.equals(newcost)){
                System.out.println("Change quantity success!!!");
            }
            Thread.sleep(6000);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Fail!!!");
        }
        driver.close();
        driver.quit();
    }
}
