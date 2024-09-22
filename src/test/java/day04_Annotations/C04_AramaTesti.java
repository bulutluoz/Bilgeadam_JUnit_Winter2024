package day04_Annotations;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_AramaTesti {

    // Uc farkli test methodu olusturarak asagidaki gorevleri gerceklestirin
    /*
        EGER yapilan setup tum test method'lari calismadan
        en basta SADECE 1 kere calisacaksa
        bu durumda @BeforeEach yerine @BeforeAll kullanilir

        ONEMLI : @BeforeAll ve @AfterAll notasyonunu kullanan method'lar
                 static olmak ZORUNDADIR
     */
    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        System.out.println("@BeforeAll notasyonuna sahip setup calisti");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown(){

        System.out.println("@AfterAll notasyonuna sahip teardown calisti");
        driver.quit();
    }

    // 1- testotomasyonu anasayfaya gidin
    //    Url'in testotomasyonu icerdigini test edin
    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Anasayfa testi PASSED");
        }else System.out.println("Anasayfa testi FAILED");
    }

    // 2- phone icin arama yapip, urun bulunabildigini test edin

    @Test
    public void test02(){

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);

        WebElement aramaSonucuElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucuElementi.getText();

        if (!unExpectedAramaSonucu.equals(actualAramaSonucu)){
            System.out.println("Arama testi PASSED");
        } else System.out.println("Arama testi FAILED");
    }

    // 3- aramada bulunan urunlerden ilkini tiklayip
    //    acilan sayfadaki urun isminde case sensitive olmadan phone bulundugunu test edin

    @Test
    public void test03(){

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();
        ReusableMethods.bekle(1);
        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        if (actualUrunIsmi.contains(expectedUrunIsimIcerik)){
            System.out.println("Ilk urun isim testi PASSED");
        }else System.out.println("Ilk urun isim testi FAILED");
        ReusableMethods.bekle(2);
    }



}
