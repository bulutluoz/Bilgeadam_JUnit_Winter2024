package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C02_TumSayfaScreenshot extends TestBase_Each {

    @Test
    public void test01() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin

        WebElement aramaSonucyaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucyaziElementi.getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);

        // rapora eklenmek uzere, tum sayfa screenshot alin
        ReusableMethods.bekle(1);

        // 1- olusturacagimiz resim icin dosya yolu hazirla (uzantisi jpg, jpeg, png olabilir)
        String dosyaYolu = "target/screenshots/tumSayfa.png";

        // 2- dosya yolunu kullanarak, resmi kaydedecegimiz File olusturalim
        File tumSayfaResmi = new File(dosyaYolu);

        // 3- fotografi cekmek icin TakeScreenshot objesi olusturalim
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 4- takesScreenshot objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim

        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 5- geciciresim'i asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim,tumSayfaResmi);


        // sayfayi kapatin

        ReusableMethods.bekle(1);
        driver.quit();



    }
}
