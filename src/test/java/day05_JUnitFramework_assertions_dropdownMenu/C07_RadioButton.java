package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C07_RadioButton extends TestBase_Each {

    @Test
    public void yazidanSecimTesti(){

        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        ReusableMethods.bekle(1);
        //	b. Cinsiyet Radio button elementlerini locate edin

        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //	c. Iki farkli test method’u oluşturup yazidan  size uygun olani secin
        WebElement erkekYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekYaziElementi.click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());

    }

    @Test
    public void radioButtonSecimTesti(){

        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        ReusableMethods.bekle(1);
        //	b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //	c. Iki farkli test method’u oluşturup direk buton’dan size uygun olani secin

        erkekRadioButton.click();
        ReusableMethods.bekle(1);
        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }
}
