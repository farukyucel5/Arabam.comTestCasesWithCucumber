package DriverPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;
    public static WebDriver getDriver() {


        if (driver==null){
            driver =new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

    public static void waiting(int value){
        try {
            Thread.sleep(value* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
