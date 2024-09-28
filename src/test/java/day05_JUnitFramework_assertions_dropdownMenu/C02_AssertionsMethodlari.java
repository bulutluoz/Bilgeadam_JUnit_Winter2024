package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_AssertionsMethodlari {

    @Test
    public void test01(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonuRRR";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(   actualUrl.contains(expectedUrlIcerik)   );

        ReusableMethods.bekle(2);
        driver.quit();
    }
}
