package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_TestBaseKullanimi {

    /*
        Gorevimiz tek test method'u ile halledilebilir durumda olsa da
        @Before... ve @After.. method'larini kullanmayi tercih ederiz

        @Before... ve @After.. method'lari kullanmazsak
        FAILED olan her test method'unda
        assertion'dan sonraki kodlar calismayacagi icin
        driver.quit(); yapilamaz
     */

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");


        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucYazisi = "0 Products Found";
        String actualAramaSonucYazisi = aramaSonucElementi.getText();


        Assertions.assertNotEquals(unExpectedAramaSonucYazisi,actualAramaSonucYazisi);

        System.out.println("assertion failed oldugunda bu satir calismaz");

        ReusableMethods.bekle(2);



    }

    @Test
    public void test02(){
        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // url'in "youtube" icerdigini test edin

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));


    }
}
