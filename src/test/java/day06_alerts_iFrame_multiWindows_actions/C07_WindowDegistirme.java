package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C07_WindowDegistirme extends TestBase_Each {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        /*
            clickHere linkini tikladigimizda YENI BIR WINDOW aciliyor
            ama bu window bizim driver.switchTo().newWindow() diyerek actigimiz bir window OLMADIGINDAN
            driver otomatik olarak yeni window'a gecmez
            eski window'da kalir
         */

        System.out.println("click yaptiktan sonra driver'in icinde oldugu sayfanin title'i : " + driver.getTitle());

        ReusableMethods.switchToWindowTitle(driver,"New Window");

        System.out.println("biz gecis yaptiktan sonra driver'in icinde oldugu sayfanin title'i : " + driver.getTitle());


        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi = driver.findElement(By.tagName("h3"));

        expectedYazi = "New Window";
        actualYazi = sayfadakiYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın

        ReusableMethods.switchToWindowUrl(driver,"https://the-internet.herokuapp.com/windows");

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);


        ReusableMethods.bekle(2);
    }
}
