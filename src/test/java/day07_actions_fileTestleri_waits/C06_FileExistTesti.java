package day07_actions_fileTestleri_waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C06_FileExistTesti extends TestBase_Each {

    @Test
    public void dosyaIndirmeTesti(){

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='logo.png']"))
                .click();

        /*
            biz logo.png'e tiklayinca
            dosya bir kac saniye icerisinde bilgisayarimizdaki Downloads klasorune kaydedilecek

            Selenium WebDriver bilgisayarimizdaki dosyalara ulasamaz

            Bilgisayarimizdaki dosyalara erismek icin
            Java kullanabiliriz

            Java'nin dosyaya ulasabilmesi icin
            dosya yoluna ihtiyacimiz var

            Files.exists(Paths.get(dosyaYolu)) kodu
            verilen dosya yolunda bir dosya varsa true
            verilen dosya yolunda dosya yoksa false dondurur

         */

        String dosyaYolu = "/Users/ahmetbulutluoz/Downloads/logo.png";
        String yanlisDosyaYolu = "/Users/ahmetbulutluoz/Downloads/deneme.png";

        System.out.println(  Files.exists(Paths.get(dosyaYolu))  ); // true

        System.out.println(Files.exists(Paths.get(yanlisDosyaYolu))); // false


        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        Assertions.assertTrue( Files.exists(Paths.get(dosyaYolu)) );


    }
}
