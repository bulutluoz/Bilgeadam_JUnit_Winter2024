package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_All;

public class C02_JsAlerts extends TestBase_All {

    //1. Test

    @Test
    public void jsAlertTesti(){
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertYazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo()
                                        .alert()
                                        .getText();

        Assertions.assertEquals(expectedAlertYazi,actualAlertYazi);

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo()
                .alert()
                .accept();

    }




    //2.Test


    @Test
    public void JsCanceltesti(){
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();

        //	- Cancel'a basip,

        driver.switchTo()
                .alert()
                .dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.id("result"))
                                            .getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }




    //3.Test

    @Test
    public void promptTesti(){
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(2);
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();

        //	- Cikan prompt ekranina "Emre" yazdiralim

        driver.switchTo().alert().sendKeys("Emre");


        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Emre icerdigini test edelim

        String expectedSonucIcerik = "Emre";
        String actualSonucYazisi = driver.findElement(By.id("result"))
                                            .getText();


        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));
    }


}
