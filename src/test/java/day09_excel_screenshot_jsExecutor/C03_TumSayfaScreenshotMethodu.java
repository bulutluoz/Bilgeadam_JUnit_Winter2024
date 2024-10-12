package day09_excel_screenshot_jsExecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_TumSayfaScreenshotMethodu extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // testotomasyonu sayfasina gidildigini test edin

        WebElement logoElementi = driver.findElement(By.xpath("//*[@class='col-lg-3 logo-left']"));

        Assertions.assertTrue(logoElementi.isDisplayed());

        // rapora eklenmek uzere tum sayfa fotografini cekin
        ReusableMethods.bekle(1);

        ReusableMethods.tumSayfaScreenshot(driver);
        ReusableMethods.tumSayfaScreenshot(driver,"241012_anasayfaTesti");


        // sayfayi kapatin
        driver.quit();


    }

}
