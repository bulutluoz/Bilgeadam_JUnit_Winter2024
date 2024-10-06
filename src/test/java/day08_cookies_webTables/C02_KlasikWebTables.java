package day08_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C02_KlasikWebTables extends TestBase_Each {

    @Test
    public void webtableTesti(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");
        //2.Web table tum body’sini yazdirin

        WebElement bodyElementi = driver.findElement(By.tagName("tbody"));

        System.out.println(bodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

        String expectedBodyIcerik = "Comfortable Gaming Chair";
        String actualTumBodyYazilar = bodyElementi.getText();

        Assertions.assertTrue(actualTumBodyYazilar.contains(expectedBodyIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin

        System.out.println(ReusableMethods.stringListeDonustur(satirElementleriList));

        System.out.println("============");

        for (int i = 0; i <satirElementleriList.size() ; i++) {

            System.out.println(i+1 +".satir : " +  satirElementleriList.get(i).getText()   );

        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //   WebTablo'larinda sutun kullanimi yoktur
        //   Satirlar ve satirlardaki datalar vardir
        //   Sutun sayisinin 4 oldugunu test etmek icin,
        //   herhangi bir satirdaki data sayisinin 4 oldugunu test edebiliriz

        int expectedSutunSayisi = 4;

        List<WebElement> ikinciSatirDataElementleriList =
                driver.findElements(By.xpath("//tbody/tr[2]/td"));

        int actualSatirdakiDataSayisi = ikinciSatirDataElementleriList.size();

        Assertions.assertEquals(expectedSutunSayisi,actualSatirdakiDataSayisi);


        //7. 3.sutunu yazdirin
        //   WebTablolarinda sutun yapisi yoktur,
        //   bunun yerine her satirdaki 3.datayi yazdirabiliriz

        List<WebElement> ucuncuSutunDataElementleriList =
                driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println( "3.sutun : " + ReusableMethods.stringListeDonustur(ucuncuSutunDataElementleriList));


        //8. Tablodaki basliklari yazdirin

        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//th"));

        System.out.println("Basliklar : "+ReusableMethods.stringListeDonustur(baslikElementleriList));


        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(getDataValue(2, 3)); // $40.00
        System.out.println(getDataValue(3, 2));  // Travel

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedDeger = "Furniture";
        String actualDeger = getDataValue(4,2);

        Assertions.assertEquals(expectedDeger,actualDeger);


        // 11. ismi "Samsung White Smart Watch" olan urunun
        // fiyatinin "$40.00" oldugunu test edin

        // bu urunun kacinci satirda oldugunu bilmiyoruz
        // ama hangi satirda ise 1.data isim, 3.data fiyat
        // tum satirlari bir loop ile elden gecirebiliriz

        for (int i = 1; i <= satirElementleriList.size() ; i++) { // 1.satirdan 5.satira kadar

            String satirdakiIsim = getDataValue(i,1);
            String satirdakiFiyat = getDataValue(i,3);

            if (satirdakiIsim.equals("Samsung White Smart Watch")){

                Assertions.assertEquals(satirdakiFiyat,"$40.00");
            }

        }



        ReusableMethods.bekle(2);
    }


    public String getDataValue(int satirNo, int sutunNo){

        //             //tbody/tr[    2     ]/td[  3   ]

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucreElementi.getText();
    }
}
