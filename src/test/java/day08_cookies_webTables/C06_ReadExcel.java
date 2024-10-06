package day08_cookies_webTables;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C06_ReadExcel {

    @Test
    public void test01(){

        // exceldeki Sayfa2'ye gidin

        Workbook workbook = null;

        try {
            String dosyaYolu = System.getProperty("user.dir")+ "/src/test/java/day08_cookies_webTables/ulkeler.xlsx";
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            System.out.println("Excel dosyasi kullanilamiyor");
        }

        Sheet sayfa2 = workbook.getSheet("Sayfa2");


        // son kullanilan satirin exceldeki 20.satir oldugunu test edin

        int expectedSonSatirNo = 20 ;
        int actualSonSatirNo = sayfa2.getLastRowNum()+1;

        Assertions.assertEquals(expectedSonSatirNo,actualSonSatirNo);


        // fiziki kullanilan satir sayisinin 8 oldugunu test edin


        int expectedFizikiKullanilanSatirSayisi = 8;
        int actualFizikiKullanilanSatirSayisi = sayfa2.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedFizikiKullanilanSatirSayisi,actualFizikiKullanilanSatirSayisi);


        // 5.satir 1. hucredeki datayi yazdirin
        // System.out.println(sayfa2.getRow(4).getCell(0)); // NullPointerException
        System.out.println(sayfa2.getRow(4)); // null
        // satir null olarak isaretlendigi icin
        // satiri yazdirinca null yazar
        // ama null olarak isaretlenen satirdan .getCell() method kullanirsak NullPointerException verir


        // 25.satir 2. hucredeki datayi yazdirin
        // System.out.println(sayfa2.getRow(24).getCell(1)); // NullPointerException


        // 2.satir 1. hucredeki datayi yazdirin
        System.out.println(sayfa2.getRow(1).getCell(0)); // 1.0

        // 2.satir 2. hucredeki datayi yazdirin
        System.out.println(sayfa2.getRow(1).getCell(1)); // null


        // 2.satir 7. hucredeki datayi yazdirin
        System.out.println(sayfa2.getRow(6).getCell(0)); // null


    }
}
