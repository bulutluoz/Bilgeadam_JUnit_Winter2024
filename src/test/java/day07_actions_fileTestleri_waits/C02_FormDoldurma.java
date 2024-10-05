package day07_actions_fileTestleri_waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_FormDoldurma extends TestBase_Each {

    @Test
    public void formDoldurmaTesti(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[text()='Account'])[1]"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.click(firstnameKutusu)
                .sendKeys("Reyhan")
                .sendKeys(Keys.TAB)
                .sendKeys("Gunduz")
                .sendKeys(Keys.TAB)
                .sendKeys("reyhan@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        ReusableMethods.bekle(2);

        // ve Sign Up butonuna basalim
        driver.findElement(By.id("btn-submit-form"))
                .click();
        ReusableMethods.bekle(1);

        //5- Kaydin olusturuldugunu test edin
        //   Kayit olusturulunca direk sisteme girmedi,
        //   Kaydin basarili olarak olusturuldugunu test etmek icin sisteme giris yapalim

        WebElement emailKutusu = driver.findElement(By.id("email"));

        actions.click(emailKutusu)
                .sendKeys("reyhan@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        // giris yaptiktan sonra
        // giris yapabildigimizi test etmek icin logout butonunun gorunur oldugunu assert edelim
        WebElement logoutButonu = driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));


        ReusableMethods.bekle(2);

        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();


        ReusableMethods.bekle(2);
    }
}
