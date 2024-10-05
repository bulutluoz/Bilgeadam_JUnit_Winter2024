package day07_actions_fileTestleri_waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        /*
            Java dosya yolunu dinamik yapabilmek icin
            bize 2 alternatif sunar

            1- dosya projenin icindeyse
               herkes icin bilgeadam_JUnit'den sonrasi aynidir
               onceki kisiye ozel kisim icin Java'da System.getProperty("user.dir") kullanilir
               boylece herkeste calisacak dinamik dosya yolu elde edilmis olur
                String dinamikDosyaYolu1 = System.getProperty("user.dir") + "/"+ projedekiHerkesIcinOrtakYol;

             2- dosya proje disinda Downloads, Desktop gibi bir konumda ise
                herkes icin user ismine kadar olan kisim farkli olur
                ama user isminden sonrasi GENELLIKLE ayni olur
                proje disindaki bir dosya icin herkeste calisacak dinamik dosya yolu icin
                String dinamikDosyaYolu2 = System.getProperty("user.home") + "/Downloads/logo.png" ;
                kullanilabilir

         */


        // 1- dosya projenin icindeyse
        // herkes icin bilgeadam_JUnit'den sonrasi herkes icin aynidir

        String absolutePath = "/Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/bilgeadam_JUnit" +
                              "/src/test/java/day07_actions_fileTestleri_waits/notlar.txt";

        String projedekiHerkesIcinOrtakYol = "src/test/java/day07_actions_fileTestleri_waits/notlar.txt";

        System.out.println(System.getProperty("user.dir"));
        //     /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/bilgeadam_JUnit


        String dinamikDosyaYolu1 = System.getProperty("user.dir") + "/"+ projedekiHerkesIcinOrtakYol;

        // proje kapsamindaki notlar.txt'nin var oldugunu test edin

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu1)));



        // 2- dosya proje disinda ise

        String dosyaYolu = "/Users/ahmetbulutluoz" +  "/Downloads/logo.png";


        System.out.println(System.getProperty("user.home")); // /Users/ahmetbulutluoz

        String dinamikDosyaYolu2 = System.getProperty("user.home") + "/Downloads/logo.png" ;

        Assertions.assertTrue( Files.exists(Paths.get(dinamikDosyaYolu2)));


    }
}














