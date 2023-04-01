package day_02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        // https://www.google.com/ adresine gidin
        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        // arama cubuguna "Nutella" yazıp aratın
        // bulunan sonuc sayısını yazdırın
        // sonuc sayısının 100000000  fazla oldugunu test edin
        // sayfayı kapatın


        WebDriverManager.chromedriver().setup();   //chrome ayarlarını yaptık
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));   //driver objesi
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));    //sayfanın yüklenmesi icin max bekleme süresi



        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");




        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String googleTitle = driver.getTitle();                               //en son bulundugum sayfanın sayfa baslıgını getirir

        if(googleTitle.contains("Google")){                                   //google kelimesini içeriyor mu?
            System.out.println("Title Google içeriyor...");
        }else{
            System.out.println("Title Google içermiyor...");
        }
        Thread.sleep(2000);





        // arama cubuguna "Nutella" yazıp aratın

        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);    //arama cubugunun locate'ini aldık nutella yazdırdık ve enter...





        // bulunan sonuc sayısını yazdırın

        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        // System.out.println(sonucYazisi.getText());                //getText String e çevirir

        String arr[] = sonucYazisi.getText().split(" ");      //Boşluktan ayırıyoruz (Split)

        String sonuc = arr[1];                                      //[1] index'i al

        System.out.println(sonuc);                                  //141.000.000 sadece sonucu yazdırdık





        // sonuc sayısının 100000000  fazla oldugunu test edin

        String sonucc = sonuc.replaceAll("\\D","");

        if(Integer.parseInt(sonucc)>100000000){
            System.out.println("Sonuc sayisi 100000000'dan fazla");
        }else{
            System.out.println("Sonuc sayisi 100000000'dan fazla degil");
        }




        // sayfayı kapatın
        driver.close();

    }
}