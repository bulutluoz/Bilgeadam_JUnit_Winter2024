package day07_actions_fileTestleri_waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C10_ExplicitWait {

    @Test
    public void implictlyWaitTesti(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()=\"Add\"]"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        Assertions.assertTrue(itsBackYaziElementi.isDisplayed());

        driver.quit();
    }

    @Test
    public void explictWaitTesti(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

            // 1.adim wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

            // 2.adim kullanilacak “It’s gone!” yazi elementini locate et
            // 3.adim wait objesi ve “It’s gone!” yazi elementi ile bekle
            // EGER bekleme yapmadan locate islemi mumkun degilse, 2.ve 3.adimi birlikte yapiyoruz

        WebElement itsGoneYaziElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());

        //4. Add buttonuna basin

        driver.findElement(By.xpath("//*[text()=\"Add\"]"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin

        // locate ve bekleme islemini tek adimda yapiyoruz

        WebElement itsBackYaziElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));

        Assertions.assertTrue(itsBackYaziElementi.isDisplayed());

        driver.quit();
    }
}



















