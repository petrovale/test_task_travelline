package ru.rambler.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Registration {

    private static WebDriver webDriver;
    /*
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\your_directory\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://id.rambler.ru/account/registration");

        System.out.println(webDriver.getTitle());
        webDriver.quit();
    }
    */
    @BeforeClass
    public static void init() throws Exception {
        System.setProperty("webdriver.chrome.driver","path\\chromedriver_2.31\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quit() throws Exception {
        webDriver.quit();
    }

    //email-адрес уже существует
    @Test
    public void testMailBoxAlreadyExists() throws Exception {
        //webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://id.rambler.ru/account/registration");
        //System.out.println(webDriver.getTitle());
        //System.out.println(webDriver.getCurrentUrl());
        webDriver.findElement(By.id("login.username")).sendKeys("dsfsdfsdf");
        webDriver.findElement(By.id("password.main")).sendKeys("");
//*[@id="root"]/div/div/form/section[3]/div/div/div[2]
        //Thread.sleep(4000);
        //String loginUsername = webDriver.findElement(By.xpath("//*[@id='root']/div/div/form/section[3]/div/div/div[2]")).getText();
                //webDriver.findElement(By.cssSelector("div[class*='message-3980010542']")).getText();
                //webDriver.findElement(By.xpath("//div[@class='message-3980010542']")).getText();

        Assert.assertEquals("Пользователь уже существует",
                webDriver.findElement(By.xpath("//*[@id='root']/div/div/form/section[3]/div/div/div[2]")).getText());
}

    //email-адрес некорректный
    @Test
    public void testMailboxBlankField() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        webDriver.findElement(By.id("login.username")).sendKeys("");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        //webDriver.findElement(By.id("password.main")).sendKeys("");
        Assert.assertEquals("Недопустимый логин",
                webDriver.findElement(By.xpath("//*[@id='root']/div/div/form/section[3]/div/div/div[2]")).getText());
    }

    //email-адрес корректный
    @Test
    public void testMailboxCorrectValue() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        webDriver.findElement(By.id("login.username")).sendKeys("fdshdshg");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        //webDriver.findElement(By.id("password.main")).sendKeys("");
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@id='root']/div/div/form/section[3]/div/div/div[2]"));
        if (elements.size() > 0) {
            System.out.println("My element was found on the page");
            throw new Exception("My element was found on the page");
        }
    }


    //email-адрес не корректный
    @Test
    public void testMailboxNoCorrectValue() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        webDriver.findElement(By.id("login.username")).sendKeys("fd sh dshg");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        //webDriver.findElement(By.id("password.main")).sendKeys("");
        Assert.assertEquals("Недопустимый логин",
                webDriver.findElement(By.xpath("//*[@id='root']/div/div/form/section[3]/div/div/div[2]")).getText());
    }

    //размер email-адрес меньше допустимого(email<3)
    @Test
    public void testMailboxLessMin() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        webDriver.findElement(By.id("login.username")).sendKeys("x");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        //webDriver.findElement(By.id("password.main")).sendKeys("");
        Assert.assertEquals("Недопустимый логин",
                webDriver.findElement(By.xpath("//*[@id='root']/div/div/form/section[3]/div/div/div[2]")).getText());
    }

    //размер email-адрес больше допустимого(email>31)
    @Test
    public void testMailboxLargerMax() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        webDriver.findElement(By.id("login.username")).sendKeys("fdgdfgdfgdfgdfggdddddddddddddd");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        //webDriver.findElement(By.id("password.main")).sendKeys("");
        Assert.assertEquals("Логин должен быть от 3 до 31 символов",
                webDriver.findElement(By.xpath("//*[@id='root']/div/div/form/section[3]/div/div/div[2]")).getText());
    }

    //пароль значение меньше 6 символов
    @Test
    public void testPasswordLessMin() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        //webDriver.findElement(By.id("login.username")).sendKeys("x");
        webDriver.findElement(By.id("password.main")).sendKeys("fdg");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        Assert.assertEquals("Пароль должен содержать от 6 до 32 символов",
                webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/section[1]/div/div[1]/div[2]")).getText());
    }

    //пароль значение больше 32 символов
    @Test
    public void testPasswordLargerMax() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        //webDriver.findElement(By.id("login.username")).sendKeys("x");
        webDriver.findElement(By.id("password.main")).sendKeys("asdfghjklqasdfghjklqasdfghjklqddf");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        Assert.assertEquals("Пароль должен содержать от 6 до 32 символов",
                webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/section[1]/div/div[1]/div[2]")).getText());
    }

    //пароль должен содержать от 6 до 32 латинских букв и цифр, а также символы ! @ $ % ^ & * ( ) _ - +
    @Test
    public void testPasswordNonLatinLetters() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        //webDriver.findElement(By.id("login.username")).sendKeys("x");
        webDriver.findElement(By.id("password.main")).sendKeys("вапвавпа");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        Assert.assertEquals("Вы вводите русские буквы",
                webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/section[1]/div/div[1]/div[2]")).getText());
    }

    //проверка пароля на неподдерживаемые символы
    @Test
    public void testPasswordUnsupportedСharacters() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        //webDriver.findElement(By.id("login.username")).sendKeys("x");
        webDriver.findElement(By.id("password.main")).sendKeys("           ");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        Assert.assertEquals("Символ \" \" не поддерживается. Можно использовать символы ! @ $ % ^ & * ( ) _ - +",
                webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/section[1]/div/div[1]/div[2]")).getText());
    }

    //проверка пароля, при вводе только цифр
    @Test
    public void testPasswordOnlyNumbers() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        //webDriver.findElement(By.id("login.username")).sendKeys("x");
        webDriver.findElement(By.id("password.main")).sendKeys("42342342342343423424");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        Assert.assertEquals("Пароль средней сложности",
                webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/section[1]/div/div[1]/div[2]")).getText());
    }

    //верный повтор пароля
    @Test
    public void testCorrectPasswordRepeat() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        //webDriver.findElement(By.id("login.username")).sendKeys("x");
        webDriver.findElement(By.id("password.main")).sendKeys("42342342342343423424");
        webDriver.findElement(By.id("password.confirm")).sendKeys("42342342342343423424");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        Assert.assertEquals("Введено верно",
                webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/section[2]/div/div/div[2]")).getText());
    }

    //не верный повтор пароля
    @Test
    public void testIncorrectPasswordRepeat() throws Exception {
        webDriver.get("https://id.rambler.ru/account/registration");
        //webDriver.findElement(By.id("login.username")).sendKeys("x");
        webDriver.findElement(By.id("password.main")).sendKeys("42342342342343423424");
        webDriver.findElement(By.id("password.confirm")).sendKeys("423423423");
        webDriver.findElement(By.cssSelector("#root > div > div > form > footer > button")).click();
        Assert.assertEquals("Пароли не совпадают",
                webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/section[2]/div/div/div[2]")).getText());
    }
}
