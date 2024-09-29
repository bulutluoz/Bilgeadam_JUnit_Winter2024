package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> elementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : elementList) {

            stringList.add(eachElement.getText());
        }

        return stringList;
    }

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);

        } catch (InterruptedException e) {

            System.out.println("bekleme yapilamadi");
        }

    }

    public static void switchToWindowTitle(WebDriver driver,String hedefTitle){

        Set<String> whdSeti = driver.getWindowHandles();

        for ( String eachWhd : whdSeti
        ) {

            driver.switchTo().window(eachWhd);

            if (driver.getTitle().equals(hedefTitle)){
                break;
            }
        }

    }

    public static void switchToWindowUrl(WebDriver driver,String hedefUrl){

        Set<String> whdSeti = driver.getWindowHandles();

        for ( String eachWhd : whdSeti){

            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                break;
            }
        }
    }


}
