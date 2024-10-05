package day07_actions_fileTestleri_waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C09_Waits {

    @Test
    public void implicitlyWaitTesti(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledYaziElementi =
                driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue(textBox.isEnabled());

        driver.quit();
    }


    @Test
    public void explicitlyWaitTesti(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        //5. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();

        // ve textbox etkin oluncaya kadar bekleyin
        // EGER sadece 1 element ve o element uzerindeki TEK BIR ISLEM icin bekleme yapmak istersek
        // explict wait kullanilabilir
        // (implicitly wait sorunu cozuyorsa extradan bu isleme gerek yok)

        // 1.adim WebDriverWait objesi olusturalim
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));

        // 2.adim kullanmak istedigimiz WebElementi locate edelim
        //   textbox yukarda locate edilip kaydedildi

        // 3. wait objesi ile webelement'i istenen islem kadar bekletelim

        // ve textbox etkin oluncaya kadar bekleyin
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledYaziElementi =
                driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue(textBox.isEnabled());

        driver.quit();

    }


}
