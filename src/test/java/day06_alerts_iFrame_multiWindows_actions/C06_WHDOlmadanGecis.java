package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C06_WHDOlmadanGecis extends TestBase_Each {

    @Test
    public void test01(){

        // Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // Yeni bir tab acarak youtube.com'a gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        ReusableMethods.bekle(1);

        // bagimsiz bir window olusturup bestbuy.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com");
        ReusableMethods.bekle(1);


        /*
            3 farkli window acildi
            Selenium herbirine ayri WindowHandleDegeri verdi
            ama biz kaydetmedik

            WindowHandleDegeri olmadan window'lar arasi gecis yapamayiz
            1- tum acik olan window'larin whd'lerini alip bir Set olarak kaydedelim
            2- Set'teki WHD'lerini bir for-each loop ile ele alip
               her bir whd'inin oldugu window'a gecis yapariz
            3- gectigimiz window'da
               bize hedef olarak verilen Url veya Title'i kontrol edip
               eger istenen windows'ta isek break; diyerek loop'u bitirebiliriz

         */

         Set<String> whdSeti = driver.getWindowHandles();

        System.out.println(whdSeti);
        // [3A5BE2B91A73E86E79092CEC7DEB4FAE, 08B9460470F2DDB9F077B284AE2352DB, BA646047C3F3CA4DB5DDE719C26540F4]

        // Title'i "YouTube" olan window'a geri donun

        for ( String eachWhd : whdSeti
             ) {

            driver.switchTo().window(eachWhd);

            if (driver.getTitle().equals("YouTube")){
                break;
            }
        }

        System.out.println("Youtube url : " + driver.getCurrentUrl());
        //Youtube url : https://www.youtube.com/



        // url'i "https://www.testotomasyonu.com/" olan window'a geri donun
        // [3A5BE2B91A73E86E79092CEC7DEB4FAE, 08B9460470F2DDB9F077B284AE2352DB, BA646047C3F3CA4DB5DDE719C26540F4]

        for ( String eachWhd : whdSeti){

            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals("https://www.testotomasyonu.com/")){
                break;
            }

        }

        System.out.println("Testotomasyonu title : " + driver.getTitle());
        // Testotomasyonu title : Test Otomasyonu - Test Otomasyonu

        ReusableMethods.bekle(1);

    }
}
