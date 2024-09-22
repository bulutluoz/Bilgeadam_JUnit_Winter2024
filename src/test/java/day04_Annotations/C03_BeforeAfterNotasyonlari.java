package day04_Annotations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_BeforeAfterNotasyonlari {

    WebDriver driver;
    @BeforeEach
    public void setup(){
        System.out.println("BeforeEach notasyonlu setup calisti");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    public void teardown(){
        System.out.println("AfterEach notasyonlu teardown calisti");
        ReusableMethods.bekle(3);
        driver.quit();
    }

    @Test
    public void testotomasyonTesti(){
        // test otomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // title'in Test Otomasyonu icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Testotomasyonu title testi PASSED");
        } else System.out.println("Testotomasyonu title testi FAILED");
    }

    @Test
    public void youtubeTesti(){
        // Youtube'a gidip
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube url testi PASSED");
        } else System.out.println("Youtube url testi FAILED");
    }

    @Test
    public void bestbuyTest(){
        //bestbuy sitesine gidin
        driver.get("https://www.bestbuy.com");

        // title'in Rest icermedigini test edin

        String unExpectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();

        if ( !actualTitle.contains(unExpectedTitleIcerik)){
            System.out.println("Bestbuy title testi PASSED");
        }else System.out.println("Bestbuy title testi FAILED");

    }


}
