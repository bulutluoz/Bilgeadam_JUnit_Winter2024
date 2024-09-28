package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C09_DropdownMenu extends TestBase_Each {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownMenuElementi = driver.findElement(By.id("dropdown"));

        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        Select select = new Select(dropdownMenuElementi);

        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);

        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");

        System.out.println(select.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);


        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");

        System.out.println(select.getFirstSelectedOption().getText());

        ReusableMethods.bekle(1);


        //	4.Tüm dropdown değerleri(value) yazdırın

        System.out.println(dropdownMenuElementi.getText());

        System.out.println("======Bir liste olarak tum option'lar=======");

        List<WebElement> tumOptionElementleriList = select.getOptions();

        System.out.println(ReusableMethods.stringListeDonustur(tumOptionElementleriList));
        // [Please select an option, Option 1, Option 2]


        //	5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedSize = 4;
        int actualSize = tumOptionElementleriList.size();

        Assertions.assertEquals(expectedSize,actualSize);

    }
}
