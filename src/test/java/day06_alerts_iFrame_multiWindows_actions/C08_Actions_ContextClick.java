package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;



public class C08_Actions_ContextClick extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(1);

        //2- “DGI Drones” uzerinde sag click yapin

        Actions actions = new Actions(driver);

        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));

        actions.contextClick(dgiDronesElementi).perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertyazi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertyazi,actualAlertYazi);

        //4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();


        ReusableMethods.bekle(3);
    }
}
