package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_HtmlAlerts extends TestBase_Each {

    @Test
    public void test01(){

        /*
            Acilan sayfada bir pop up ciktiginda
            eger locate edilebiliyorsa
            bu bir HTML pop up'dir ve diger WebElementler gibi locate edip kullanilabilir
         */

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        ReusableMethods.bekle(2);

        // cookies kabul edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[9]"))
                .click();


        ReusableMethods.bekle(5);

    }

}
