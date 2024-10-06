package day08_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_Cookies extends TestBase_Each {

    @Test
    public void cookiesTesti(){

        // arabam.com'a gidelim
        driver.get("https://www.arabam.com");




        System.out.println(driver.manage().getCookies());

        System.out.println("==================");

        int index = 1;
        for (Cookie eachCookie: driver.manage().getCookies()){

            System.out.println(index +".cookie    :     "+eachCookie);
            System.out.println("-------------------");
            index++;
        }

        // source isimli cookie'nin degerinin direct oldugunu test edin

        String expectedValue = "direct";
        String actualvalue = driver.manage()
                                    .getCookieNamed("source")
                                    .getValue();

        Assertions.assertEquals(expectedValue,actualvalue);


        // cookie'ler arasinda ismi "OptanonConsent" olan bir cookie bulundugunu test edin

        boolean arananCookieVarMi = false;

        for (Cookie eachCookie : driver.manage().getCookies()){

            if ( eachCookie.getName().equals("OptanonConsent")){
                arananCookieVarMi = true;
            }
        }

        Assertions.assertTrue(arananCookieVarMi);


        // ismi araba, degeri corolla olan bir cookie olusturup, sayfaya ekleyin

        Cookie yeniCookie = new Cookie("araba","corolla");
        driver.manage().addCookie(yeniCookie);

        // eklendigini gormek icin yazdiralim
        index = 1;
        for (Cookie eachCookie: driver.manage().getCookies()){

            System.out.println(index +".cookie    :     "+eachCookie);
            System.out.println("-------------------");
            index++;
        }

        // arabam cookie'sinin eklendigini test edin

        arananCookieVarMi = false;

        for (Cookie eachCookie : driver.manage().getCookies()){

            if ( eachCookie.getName().equals("araba")){
                arananCookieVarMi = true;
            }
        }

        Assertions.assertTrue(arananCookieVarMi);

        // tum cookie'leri silin

        driver.manage().deleteAllCookies();

        // tum cookie'lerin silindigini test edin

        int cookieSayisi = driver.manage().getCookies().size();

        Assertions.assertEquals(0,cookieSayisi);




        ReusableMethods.bekle(2);

    }
}
