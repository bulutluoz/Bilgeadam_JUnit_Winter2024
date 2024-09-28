package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_Assertions {


    @Test
    public void test01(){

        /*
            JUnit testin PASSED ya da FAILED olmasina
            kodun sorunsuz calisip calismadigina bakarak karar verir

            biz testlerimizi if-else ile yaptigimizdan
            kodlarimiz sorunsuz calisiyor
            ve JUnit tum testlerimizi PASSED olarak isaretliyor

            EGER testimiz failed oldugunda
            JUnit'in de failed olarak isaretlemesini istiyorsak
            exception firlatabiliriz
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonuRRR";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        } else   {
            System.out.println("Url testi FAILED");
            throw new AssertionFailedError("url verilen kelimeyi icermiyor");
        }


        ReusableMethods.bekle(3);
        driver.quit();
    }
}
