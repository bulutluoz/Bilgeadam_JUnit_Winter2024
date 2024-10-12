package day09_excel_screenshot_jsExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_javaScriptExecutor extends TestBase_Each {

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com");


        JavascriptExecutor jse = (JavascriptExecutor) driver;


        // jse.executeScript("calisacak js kodu", uzerinde calisilacak webElement );
        // click, scroolIntoWiew, alert


        WebElement flashUrunYaziElementi = driver.findElement(By.xpath("//*[text()='Flash Sale For You']"));

        // jse.executeScript("arguments[0].scrollIntoView(true);",flashUrunYaziElementi);

        //jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",flashUrunYaziElementi);

        jse.executeScript("document.evaluate(\"//*[text()='Flash Sale For You']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView({block: 'center'});");
        ReusableMethods.bekle(5);


        // jse kullanarak nike sneaker'i tiklayin

        WebElement nikeSneaker = driver.findElement(By.xpath("//a[text() = 'Nike Sneaker Orange & Gray']"));


        jse.executeScript("arguments[0].click();",nikeSneaker);

        ReusableMethods.bekle(5);



        jse.executeScript("alert('Yasasin JUnit BITTI');");

        ReusableMethods.bekle(5);


    }
}
