package day07_actions_fileTestleri_waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C08_FileUploadTesti extends TestBase_Each {

    @Test
    public void fileUploadTesti(){

        /*
            Dosya yuklemek icin choose file butonuna basip,
            acilan bilgisayar klasor yapisindan istedigimiz dosyayi secmemiz
            Selenium ile mumkun degil

            bunun yerine selenium ile choose file butonunu locate edip
            bu webelement'e dinamik dosya yoplunu sendKeys() ile yollariz
         */

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        // day07 altindaki notlar.txt dosyasini secelim.

            // 1.adim chooseFile butonunu bir webElement olarak kaydedelim
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));
            // 2.adim yuklemek istedigimiz dosyanin dinamik dosya yolunu olusturalim
        String dinamikDosyaYolu =   System.getProperty("user.dir") +  // projenin dinamik dosya yolu
                                    "/" +
                                    "src/test/java/day07_actions_fileTestleri_waits/notlar.txt";

            // 3.adim dinamik dosya yolunu sendkeys() ile chooseFile butonuna yolla

        chooseFileButonu.sendKeys(dinamikDosyaYolu);


        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedElementi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(fileUploadedElementi.isDisplayed());


    }
}
