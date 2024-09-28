package day05_JUnitFramework_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C08_DropdownMenu extends TestBase_Each {

    @Test
    public void test01(){

        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");


        //1. Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

        WebElement gunAcilirMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        // gunAcilirMenu.sendKeys("5");
        // Dropdown menu de bir WebElement oldugu icin
        // WebElement method'lari ile kullanilabilir
        // Ancak Select class'i bize islem yapabilecegimiz daha fazla method sunar

        Select selectGun = new Select(gunAcilirMenu);

        selectGun.selectByIndex(5);  // sendKeys("5") ile ayni islevi yapar

        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        WebElement ayAcilirMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));

        // ayAcilirMenu.sendKeys("Nisan");

        Select selectAy = new Select(ayAcilirMenu);
        selectAy.selectByValue("nisan");


        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

        WebElement yilAcilirMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

        Select selectYil = new Select(yilAcilirMenu);

        selectYil.selectByVisibleText("1990");

        //4. Secilen değerleri konsolda yazdirin

        // System.out.println(gunAcilirMenu.getText());
        // menude olan tum option'lari yazdirir

        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());


        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın

        // tum option'lari yazdirir ama option'lar ile ilgili baska islem yapmak istedigimizde kulllanamayiz
        // ornegin kac option oldugu bilgisine bu yontemle ulasamayiz
         System.out.println(ayAcilirMenu.getText());


         List<WebElement> ayOptionElementleriList  = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListeDonustur(ayOptionElementleriList));
        // [Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]


        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedMenuSize = 13;
        int actualMenuSize = ayOptionElementleriList.size();

        Assertions.assertEquals(expectedMenuSize,actualMenuSize);


        ReusableMethods.bekle(2);
    }
}
