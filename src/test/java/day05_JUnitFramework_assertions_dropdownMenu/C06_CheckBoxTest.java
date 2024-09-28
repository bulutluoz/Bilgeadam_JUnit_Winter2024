package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_CheckBoxTest extends TestBase_Each {


    @Test
    public void test01(){

        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");

        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin

            // secim hem checkbox kutusundan
            // hem de checkbox kutusunun yaninda bulunan yazidan yapilabilir
            // Sirt Agrisini kutununun kendisinden
            // Carpintiyi yazidan secelim
        WebElement sirtAgrisiCheckBox = driver.findElement(By.xpath("//*[@id='gridCheck5']"));
        sirtAgrisiCheckBox.click();

        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));
        WebElement carpintiCheckBox = driver.findElement(By.xpath("//*[@id='gridCheck4']"));
        carpintiYaziElementi.click();


        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assertions.assertTrue(carpintiCheckBox.isSelected());
        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());

        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());

        ReusableMethods.bekle(5);


    }
}
