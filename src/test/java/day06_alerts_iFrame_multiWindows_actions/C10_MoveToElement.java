package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C10_MoveToElement extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        ReusableMethods.bekle(3);

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement kidsWearElementi = driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(kidsWearElementi).perform();
        ReusableMethods.bekle(3);

        //3- “Boys” linkine basin

        WebElement boysElementi = driver.findElement(By.linkText("Boys"));

        boysElementi.click();


        //4- Acilan sayfadaki ilk urunu tiklayin

        driver.findElement(By.xpath("(//div[@class='product-box mb-2 pb-1'])[1]"))
                .click();


        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        String expectedUrunisim = "Boys Shirt White Color";
        String actualUrunIsim = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"))
                                        .getText();

        Assertions.assertEquals(expectedUrunisim,actualUrunIsim);

        ReusableMethods.bekle(3);
    }
}
