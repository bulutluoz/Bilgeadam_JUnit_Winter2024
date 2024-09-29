package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C04_iframe extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // inceledigimizde electronics Products yazisinin bir iframe icerisnde oldugunu gorduk
        // webelementi kullanabilmek icin once iFrame'e gecis yapmaliyiz

        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIFrame);
        ReusableMethods.bekle(1);

        WebElement electronicsProductsElementi =
                driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = driver.findElement(By.id("pictext1"))
                                        .getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);


        // Fashion urunleri farkli bir iFrame icinde oldugundan
        // once icinde oldugumuz electronics iFrame'den anasayfaya cikalim
        driver.switchTo().defaultContent(); // ic ice iFrame'ler olsa da direkt anasayfaya doner
        //driver.switchTo().parentFrame();// ic ice iFrame'ler varsa bir ustteki iFrame'e gecer


        // sonra sag taraftaki fashion iFrame'e gecis yapalim
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);

        //4- ‘Fashion’ yazisinin gorunur olduğunu test edin
        WebElement fashionYaziElementi = driver.findElement(By.tagName("h2"));

        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        //5- Sagdaki bolumde gorunen urunler arasinda
        // ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin

        List<WebElement> fashionUrunElementleriList = driver.findElements(By.className("overlay"));

        boolean menSlimFitVarMi = false;

        for (WebElement each : fashionUrunElementleriList){

            if (each.getText().contains("Men Slim Fit")){
                menSlimFitVarMi = true;
            }
        }

        Assertions.assertTrue(menSlimFitVarMi);


        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        // yazi anasayfada oldugundan
        // once icinde oldugumuz fashion iFrame'den anasayfaya donelim
        driver.switchTo().parentFrame();


        WebElement hereAreYaziElementi = driver.findElement(By.xpath("//*[@class='desc']"));


        //7- Sayfayi kapatin
        ReusableMethods.bekle(3);

    }
}
