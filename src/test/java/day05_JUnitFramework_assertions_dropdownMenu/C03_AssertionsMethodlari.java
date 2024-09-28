package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_AssertionsMethodlari {

    @Test
    public void test01(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // url'in https://www.testotomasyonu.com/ oldugunu test edin

        String expectedUrl = "https://www.testotomasyonu.com";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);

        // bir Test methodu calistirildiginda
        // kodlarda RunTime'da olusan bir hata varsa
        // JUnit hata olan bolumun altini TURUNCU NOKTALAR ile belirlginlestirir

        // Assertions.assertTrue(expectedUrl.equals(actualUrl));

        ReusableMethods.bekle(2);
        driver.quit();

    }
}
