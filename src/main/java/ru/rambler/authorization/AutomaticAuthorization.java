package ru.rambler.authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AutomaticAuthorization {
    private static WebDriver webDriver;

    @Test
    public void testAutomaticAuthorizationCheckForNewMessages() throws Exception {
        System.setProperty("webdriver.chrome.driver","path\\chromedriver_2.31\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //https://id.rambler.ru/login-20/#/login
        webDriver.get("https://id.rambler.ru/login-20/#/login");

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[1]/div/input")).sendKeys("alexey2017alexey@rambler.ru");
        webDriver.findElement(By.xpath("//*[@id=\"form_password\"]")).sendKeys("alexey");
        webDriver.findElement(By.cssSelector("#app > div > div.wrapper > form > div:nth-child(5) > div > button")).click();

        String s = webDriver.findElement(By.xpath("//*[@id=\"topline\"]/div/div[1]/div/div[2]/a[2]/span")).getText();
        System.out.println(s.length() > 0 ? "есть новые письма" : "нет новых писем");
        webDriver.quit();
    }

    @AfterClass
    public static void quit() throws Exception {
        webDriver.quit();
    }
}
