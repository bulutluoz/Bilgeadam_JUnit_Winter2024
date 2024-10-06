package day08_cookies_webTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C03_KlasikOlmayanWebTablolari extends TestBase_Each {

    @Test
    public void webTableTesti(){

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //     //*[@role='trow'][2]/*[@role='tdata'][3]

        //  2. Headers da bulunan basliklari yazdirin

        List<WebElement> baslikElementleriList =
                driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikElementleriList));

        //  3. 3.sutunun basligini yazdirin

        System.out.println(baslikElementleriList.get(2).getText()); // Price

        //  4. Tablodaki tum datalari yazdirin

        List<WebElement> bodyTumDataElementleriList =
                driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(bodyTumDataElementleriList));

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin

        System.out.println("Tablodaki hucre sayisi : " + bodyTumDataElementleriList.size());

        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("Tablodaki satir sayisi : " + satirElementleriList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //     web tablosunda sutun yapisi yok, herhangi bir satirdaki data sayisini yazdirabiliriz

        System.out.println("Sutun sayisi : " + baslikElementleriList.size() );

        //  8. Tablodaki 3.sutunu yazdirin

        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));

        System.out.println("Ucuncu sutun : "+ ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));


        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

        System.out.println(getCellData(2, 3)); // $399.00


        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        //     tum satirlari gozden gecirip
        //     satirdaki category "Furniture" ise fiyatini yazdiralim

        for (int i = 1; i <= satirElementleriList.size() ; i++) {

            String satirdakiCategory = getCellData(i,2);
            String satirdakiFiyat = getCellData(i,3);

            if (satirdakiCategory.equals("Furniture")){
                System.out.println(satirdakiFiyat);
            }

        }



    }


    public String getCellData(int satirNo,int sutunNo){

        //      //*[@role='trow'][   2   ]/*[@role='tdata'][   3   ]

        String dinamikXpath = "//*[@role='trow']["+ satirNo + "]/*[@role='tdata']["+ sutunNo + "]";

        WebElement istenenCellElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenCellElementi.getText();
    }
}
