package day04_Annotations;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_TestAnnotations {

    /*
        1- Junit'in class'daki test method'larini calistirma icin bir siralamasi yoktur
           Calisma sirasini ONGOREMEYIZ ve kontrol edemeyiz
           sadece method isimleri test01, test02, test03 gibi sirali isimler oldugunda
           bu siralamaya uyar

         2- @Test notasyonu sayesinde
            istedigimiz test method'unu bagimsiz olarak calistirabilecegimiz gibi,
            class level'dan tum method'lari toplu olarak da calistirabiliriz

         3- Gecici olarak calistirilmasini istemedigimiz test method'u varsa
            @Disabled olarak isaretleyebiliriz
     */

    // 3 farkli test methodu olusturun
    // bu test method'lari bagimsiz olarak da calistirilabilmelidir


    @Test
    public void testotomasyonTesti(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // test otomasyonu sayfasina gidin

        driver.get("https://www.testotomasyonu.com");

        // title'in Test Otomasyonu icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Testotomasyonu title testi PASSED");
        } else System.out.println("Testotomasyonu title testi FAILED");

        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test @Disabled
    public void youtubeTesti(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Youtube'a gidip
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube url testi PASSED");
        } else System.out.println("Youtube url testi FAILED");

        ReusableMethods.bekle(3);
        driver.quit();

    }

    @Test
    public void bestbuyTest(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //bestbuy sitesine gidin

        driver.get("https://www.bestbuy.com");

        // title'in Rest icermedigini test edin

        String unExpectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();

        if ( !actualTitle.contains(unExpectedTitleIcerik)){
            System.out.println("Bestbuy title testi PASSED");
        }else System.out.println("Bestbuy title testi FAILED");

        ReusableMethods.bekle(3);
        driver.quit();
    }



}
