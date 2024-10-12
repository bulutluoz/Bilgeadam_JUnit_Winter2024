package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C04_IstenenWebelementScreenshot extends TestBase_Each {

    @Test
    public void aramaTesti() throws IOException {

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

        // rapora eklenmek uzere, arama sonuc yazisinin screenshot alin
        ReusableMethods.bekle(1);

        // 1- olusturacagimiz resim icin dosya yolu hazirla (uzantisi jpg, jpeg, png olabilir)
        String dosyaYolu = "target/screenshots/istenenWebelement.png";

        // 2- dosya yolunu kullanarak, resmi kaydedecegimiz File olusturalim
        File webelementScreenshot = new File(dosyaYolu);

        // 3- screenshot alinacak Webelementi locate edip kaydedin
        //    biz yukarda aramaSonucyaziElementi'ni olusturduk

        // 4- kaydettigimiz webElement'i kullanarak fotografi cekip,
        //    gecici bir dosyaya kaydedelim
        File geciciResim = aramaSonucyaziElementi.getScreenshotAs(OutputType.FILE);

        // 5- geciciresim'i asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim,webelementScreenshot);


        ReusableMethods.webelementScreenshot(aramaSonucyaziElementi);
        ReusableMethods.webelementScreenshot(aramaSonucyaziElementi,"Arama testi");

        driver.quit();

    }
}
