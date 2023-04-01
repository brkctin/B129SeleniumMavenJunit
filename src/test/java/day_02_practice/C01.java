package day_02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.FileStore;
import java.time.Duration;

public class C01 {

    public static void main(String[] args) {


        // https://www.amazon.com/ adresine gidin
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        // sayfayi kapatiniz


        WebDriverManager.chromedriver().setup();   //chorme ayarlarını yaptık

        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));   //driver objesi
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");



        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusunun = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        String actuelTagName = aramaKutusunun.getTagName();     //assing etmek

        String expectedTagName = "input";

        if(expectedTagName.equals(actuelTagName)){    //Beklenen name değeri eşit mi gerçek name değerine
            System.out.println("TagName input");
        }else{
            System.out.println("TagName input degil");
        }



        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin


        String actualNameDegeri = aramaKutusunun.getAttribute("name");  //name attribute'ünün degerini getir (gerçek name degeri)

        String expectedNameDegeri = "field-keywords";                         // beklenen name degeri

        if(expectedNameDegeri.equals(actualNameDegeri)){                      //Beklenen name değeri eşit mi gerçek name değerine
            System.out.println("name attributenin degeri field keywords");
        }else {
            System.out.println("name attributenin degeri field keywords degil");
        }







        // sayfayi kapatiniz
        driver.close();







    }
}





