package day08_cookies_webTables;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.SheetCollate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcel() throws IOException {

        /*
            Selenium bilgisayarimizda bulunan dosyalara erisemez

            java bilgisayarimizdaki dosyalara erisebilir,
            dosyadaki bilgileri alabilir
            ANCAAKK Java da excel'deki farkli sayfa ve satirlari
            kullanamaz

            Excel dosya yapisina uygun bjeler olusturmak icin
            projemize yeni dependency eklememiz gerekiyor

            ekledigimiz apachePoi dependency'leri sayesinde
            excel dosyasindaki tum datalari alip
            excel yapisina uygun olarak olusturdugumuz
            workbook objesine kaydettik.

            ONEMLI NOT : biz butun islemlerimizi
                         kendi class'imizda workbook uzerinde yapacagiz
                         bir degisiklik yaparsak excel dosyasina kaydetmek icin
                         ekstra islem yapmaliyiz
         */


        // 1.adim : java'nin dosyaya erisebilmesi icin dosya yolunu kaydedelim
        String dosyaYolu = System.getProperty("user.dir")+ "/src/test/java/day08_cookies_webTables/ulkeler.xlsx";

        // 2.adim : dosya yolunu kullanarak FileInputStream ile dosyaya ulasalim
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // 3.adim : fileInputStream objesi ile alinan bilgileri
        //          excel yapisina uygun bir workbook olarak kaydedelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        Row dokuzuncuSatir = sayfa1.getRow(9);

        Cell ucuncuData = dokuzuncuSatir.getCell(3);

        // Row ve Cell index kullanir, yani 0'dan baslar
        // biz row olarak 9, cell olarak 3 secince
        // bize 10.satirdaki, 4.datayi verir
        System.out.println(ucuncuData); // Canberra


        // excelde 18.satirda olan Belcika'nin Turkce baskent ismini yazdirmak istersek

        // her seferinde satir ve cell objesi olusturmak zorunda degiliz
        // sayfa1 objesinden istenen satir ve dataya ulasabiliriz

        System.out.println(sayfa1.getRow(17).getCell(3)); //  Brüksel

    }
}
