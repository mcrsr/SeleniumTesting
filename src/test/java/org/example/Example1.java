package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Example1 {

    @Test
    public static void login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("oxd-userdropdown-name"))));
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Thread.sleep(2000);
        driver.quit();
    }
}
