package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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





}
