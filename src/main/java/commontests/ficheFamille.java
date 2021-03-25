/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commontests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *
 * @author R.Pereira
 */
public class ficheFamille {
    
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  /*@After
  public void tearDown() {
    driver.quit();
  }*/
  @Test
  public void login() {
      /* Ricardo P changements */
      System.setProperty("webdriver.chrome.driver","C:\\Users\\R.Pereira\\Documents\\NetBeansProjects\\SeleniumTest01\\SeleniumTest01\\chromedriver.exe");
      driver = new ChromeDriver();
      try{
        driver.get("https://hulk.agoraplus.fr/agora");
        driver.manage().window().setSize(new Dimension(1936, 1066));
        // closing coockies
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        
        driver.findElement(By.xpath("//img[@onclick=\"aff_login(\'enf\')\"]")).click();
        {
          WebElement element = driver.findElement(By.xpath("//img[@onclick=\"aff_login(\'enf\')\"]"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.name("p_login")).sendKeys("admin");
        driver.findElement(By.name("p_pass")).sendKeys("bl@nQui13");
        driver.findElement(By.xpath("//button[@id=\'logIn\']/img")).click();
        driver.findElement(By.xpath("//ul[@id=\'menuLeft\']/li[2]")).click();
        driver.findElement(By.linkText("FAMILLES - FOYERS")).click();
        driver.findElement(By.linkText("Recherche")).click();
        driver.findElement(By.id("inputsrcFAMILY")).click();
        driver.findElement(By.id("inputsrcFAMILY")).sendKeys("357");
        driver.findElement(By.id("inputsrcFAMILY")).sendKeys(Keys.ENTER);
        assertThat(driver.findElement(By.cssSelector(".adm_header > table td:nth-child(1)")).getText(), is("MME CLAIRE-MARIE GONNY"));
     }catch(Exception e){
        System.out.println("Test Failed on Login Hulk");
        //driver.quit();
        e.printStackTrace();
     }
  }
  @Test
  public void ficheparent() {
    try{
        driver.get("https://hulk.agoraplus.fr/agora/pck_gestion.display_family?p_family=357");
        driver.manage().window().setSize(new Dimension(1920, 1050));
        driver.findElement(By.xpath("//img[@alt=\'Modifier\']")).click();
        driver.findElement(By.xpath("//table[@id=\'parent\']/tbody/tr[11]")).click();
        driver.findElement(By.id("mail")).click();
        driver.findElement(By.id("mail")).click();
        driver.findElement(By.id("mail")).sendKeys("14890@mailinator.com");
        driver.findElement(By.cssSelector(".submit")).click();
        assertThat(driver.findElement(By.xpath("//div[@id=\'contentCenter\']/table/tbody/tr/td/table/tbody/tr[6]/td[2]/a")).getText(), is("14890@mailinator.com"));

    }catch(Exception e){
        System.out.println("Test Failed on change mail on Hulk");
        //driver.quit();
        e.printStackTrace();
     }
  }
    
}
