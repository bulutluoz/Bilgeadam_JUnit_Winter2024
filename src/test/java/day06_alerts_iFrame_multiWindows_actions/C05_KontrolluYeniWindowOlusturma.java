package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_KontrolluYeniWindowOlusturma extends TestBase_Each {

    @Test
    public void test01(){

        // Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // title'in "Test Otomasyonu" icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Window handle degerini kaydedin ve yazdirin
        String testotomasyonuWindowhandle = driver.getWindowHandle();

        System.out.println("Testotomasyonu Window handle degeri : " + testotomasyonuWindowhandle);

        ReusableMethods.bekle(3);


        // Yeni bir tab acarak youtube.com'a gidin

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");

        // url'in "youtube" icerdigini test edin

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        String youtubeWindowhandle = driver.getWindowHandle();

        System.out.println("Youtube Window handle degeri : " + youtubeWindowhandle);

        ReusableMethods.bekle(3);

        // bagimsiz bir window olusturup bestbuy.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com");

        // Title'in "Best" icerdigini test edin

        expectedTitleIcerik = "Best";
        actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Window handle degerini kaydedin ve yazdirin

        String bestbuyWindowhandle = driver.getWindowHandle();

        System.out.println("Bestbuy Window handle degeri : " + bestbuyWindowhandle);

        ReusableMethods.bekle(3);

        /*
            Test her calistiginda
            Selenium her bir window icin unique bir window handle degeri olusturur
            Test calistigi surece bu window handle degerleri sabit olur
            ve window'lar arasinda gecis yapmak isterseniz
            window handle degerleri sayesinde gecis yapabilirsiniz
         */
        //Testotomasyonu Window handle degeri : EDB74DD8A33374284434C7FD473948D8
        //Youtube Window handle degeri : 8F58944C570CCADC3CA0293137652CB6
        //Bestbuy Window handle degeri : C471E5EAEA3E57DF1578BCC5EFEA2174

        // yeniden testotomasyonun acik oldugu window'a donun ve title'i yazdirin

        driver.switchTo().window(testotomasyonuWindowhandle);

        System.out.println("testotomasyonu title : " + driver.getTitle());

        ReusableMethods.bekle(3);

        // yeniden youtube'un acik oldugu window'a donun ve title'i yazdirin

        driver.switchTo().window(youtubeWindowhandle);

        System.out.println("youtube title : " + driver.getTitle());

        ReusableMethods.bekle(3);


        // yeniden bestbuy'in acik oldugu window'a donun ve title'i yazdirin

        driver.switchTo().window(bestbuyWindowhandle);

        System.out.println("bestbuy title : " + driver.getTitle());

        ReusableMethods.bekle(3);


    }
}
