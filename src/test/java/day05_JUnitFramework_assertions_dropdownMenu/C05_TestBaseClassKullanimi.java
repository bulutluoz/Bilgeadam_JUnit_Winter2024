package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_TestBaseClassKullanimi extends TestBase_Each {


    @Test
    public void aramaTesti(){

        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucYazisi = "0 Products Found";
        String actualAramaSonucYazisi = aramaSonucElementi.getText();


        Assertions.assertNotEquals(unExpectedAramaSonucYazisi,actualAramaSonucYazisi);

        ReusableMethods.bekle(2);
    }
}
