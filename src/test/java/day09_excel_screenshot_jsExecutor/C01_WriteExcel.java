package day09_excel_screenshot_jsExecutor;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        String dosyaYolu = "src/test/java/day08_cookies_webTables/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //3) Adimlari takip ederek Sayfa1’de 1.satira kadar gidelim
        //4) 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(250000);

        //8) 15.satir nufus kolonuna 54000 yazdirali
        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        //9) Dosyayi kaydedelim

        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);

        //10)Dosyayi kapatalim
        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();



    }
}
