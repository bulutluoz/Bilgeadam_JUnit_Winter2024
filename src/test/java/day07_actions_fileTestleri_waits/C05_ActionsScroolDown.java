package day07_actions_fileTestleri_waits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_ActionsScroolDown extends TestBase_Each {

    @Test
    public void iframeTest(){

        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        ReusableMethods.bekle(1);

        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .perform();

        //4- videoyu izlemek icin Play tusuna basin
        //   video oynatma iframe icinde oldugu icin once iframe'e gecis yapmaliyiz


        //5- videoyu calistirdiginizi test edin



        ReusableMethods.bekle(5);
    }
}
