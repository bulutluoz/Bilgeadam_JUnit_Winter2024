package day06_alerts_iFrame_multiWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C09_Actions_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");


        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        WebElement tasinacakEleman = driver.findElement(By.id("draggable2"));
        WebElement hedefAlan = driver.findElement(By.id("droppable2"));


        actions.dragAndDrop(tasinacakEleman,hedefAlan).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedyazi = "Dropped!";
        String actualyazi = driver.findElement(By.id("droppable2")).getText();

        Assertions.assertEquals(expectedyazi,actualyazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(1);
        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElementi = driver.findElement(By.id("draggable-nonvalid2"));
        hedefAlan = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableElementi,hedefAlan).perform();


        //6- “Drop Here” yazisinin degismedigini test edin

        expectedyazi = "Drop Here";
        actualyazi = driver.findElement(By.id("droppable2")).getText();

        Assertions.assertEquals(expectedyazi,actualyazi);

        ReusableMethods.bekle(2);
    }
}
