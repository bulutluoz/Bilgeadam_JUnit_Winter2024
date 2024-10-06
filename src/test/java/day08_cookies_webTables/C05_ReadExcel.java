package day08_cookies_webTables;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C05_ReadExcel {

    @Test
    public void readExcelTesti(){
        Workbook workbook = null;

        try {
            String dosyaYolu = System.getProperty("user.dir")+ "/src/test/java/day08_cookies_webTables/ulkeler.xlsx";
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            System.out.println("Excel dosyasi kullanilamiyor");
        }

        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //	    - 1.satirdaki 2.hucreye gidin ve yazdirin
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)

        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdirin
        // String istenenData = sayfa1.getRow(0).getCell(1).toString();
        String istenenData = sayfa1.getRow(0).getCell(1).getStringCellValue();

        System.out.println(istenenData);

        //		- 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edin

        String expectedCellData = "Kabil";
        String actualCellData = sayfa1.getRow(1).getCell(3).getStringCellValue();

        Assertions.assertEquals(expectedCellData,actualCellData);

        //		- Satir sayisininin 191 oldugunu test edin

        int expectedSatirSayisi = 191;
        int actualSatirSayisi = sayfa1.getLastRowNum()+1;
        // getLastRowNum() bize son satirin index'ini verir
        // yani reelde gorecegimiz satir numarasinin bir eksigine esit olur

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //		- Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin

        int expectedFizikiKullanilanSatirSayisi = 191 ;
        int actualFizikiKullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedFizikiKullanilanSatirSayisi,actualFizikiKullanilanSatirSayisi);

        //      - excel'de ingilizce baskenti Ankara olan bir ulke bulundugunu test edin

        // bir for loop ile ilk satirdan son satira kadar
        // ingilizce baskent isimlerini kontrol etmeliyiz

        boolean ankaraVarMi = false;

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceBaskentIsmi = sayfa1.getRow(i)
                                                            .getCell(1)
                                                            .getStringCellValue();

            if (satirdakiIngilizceBaskentIsmi.equals("Ankara")){
                ankaraVarMi = true;
                break;
            }

        }

        Assertions.assertTrue(ankaraVarMi);

        //		- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedin

        Map<String,String> ingilizceIsimlerMapi = new HashMap<>();

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i)
                                                        .getCell(0)
                                                        .getStringCellValue();

            String satirdakiIngilizceBaskentIsmi = sayfa1.getRow(i)
                                                            .getCell(1)
                                                            .getStringCellValue();

            ingilizceIsimlerMapi.put(satirdakiIngilizceUlkeIsmi,satirdakiIngilizceBaskentIsmi);

        }

        //      - excel'de ingilizce baskenti Amsterdam olan bir ulke bulundugunu test edin

        Assertions.assertTrue( ingilizceIsimlerMapi.containsValue("Amsterdam"));

        //      - excelde ingilizce ismi Togo olan ulkenin
        //        ingilizce baskent isminin Lome oldugunu test edin


        String expectedBaskent = "Lome";
        String actualBaskent = ingilizceIsimlerMapi.get("Togo");

        Assertions.assertEquals(expectedBaskent,actualBaskent);


    }
}
