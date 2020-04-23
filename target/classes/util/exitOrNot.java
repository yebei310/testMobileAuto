package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class exitOrNot {
    public Boolean check (WebDriver driver , By seletor){
        try{
            driver.findElement(seletor);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
