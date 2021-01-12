/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifinal;

import org.junit.Test;
import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


/**
 *
 * @author Jeremy
 */
public class GuiFinalTest {
    
    public GuiFinalTest() {
    }
    WebDriver driver;
    URL page;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\!Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        try {
            page = new URL("https://localhost:44395/");
        } catch (MalformedURLException ex) {
            System.out.println("Error 404 - URL bad");
            System.exit(404);
        }
    }

    @After
    public void tearDown() {
       driver.quit();
    }

    //unit tests
    @Test
    public void testnavbarappearsonpage(){
        driver.get(page.toString());
        WebElement nav = driver.findElement(By.xpath("/html/body/header/nav/div/div/ul[2]"));
        
    }
    
    //functional tests
    @Test
    public void testuserlogin() {
        driver.get(page.toString());
        
        WebElement loginlink = driver.findElement(By.xpath("/html/body/header/nav/div/div/ul[1]/li[2]/a"));
        loginlink.click();
        
        WebElement email = driver.findElement(By.id("Input_Email"));
        email.sendKeys("yeet@yeet.com");
        
        WebElement password = driver.findElement(By.id("Input_Password"));
        password.sendKeys("Yeet#123");
        
        WebElement submit = driver.findElement(By.id("login-submit"));
        submit.click();
          
    }
    
    @Test
    public void testuserreg() {
        driver.get(page.toString());
        
        WebElement reglink = driver.findElement(By.xpath("/html/body/header/nav/div/div/ul[1]/li[1]/a"));
        reglink.click();
        
        WebElement email = driver.findElement(By.id("Input_Email"));
        email.sendKeys("sawtoothkiller@gmail.com");
        
        WebElement password = driver.findElement(By.id("Input_Password"));
        password.sendKeys("HorizonZero#543");
        
        WebElement confpassword = driver.findElement(By.id("Input_ConfirmPassword"));
        confpassword.sendKeys("HorizonZero#543");
        
        WebElement submit = driver.findElement(By.id("registerSubmit"));
        submit.click();
        
        
    }
    
    
    
}
