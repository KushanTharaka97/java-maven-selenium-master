
import com.thoughtworks.gauge.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utils.driver.Driver;

public class WhatsApp {
    WebDriver webDriver = Driver.webDriver;
    Actions builder = new Actions(webDriver);

    @Step("say this <text>")
    public void watsapp(String text) {

    //   ---------------------------[Finding the Name - Begins]---------------------------  
        try {
            Thread.sleep(1000);
            // webDriver.findElement(By.xpath("//span[contains(text(),'Sunera Avinash Chandrasiri')]")).click();
            webDriver.findElement(By.xpath("//span[contains(text(),'GaugeTesting')]")).click();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  //   ---------------------------[Finding the Name -END]---------------------------  

    //   ---------------------------[sending Message - Begins]---------------------------  
    for(int i = 0 ; i < 10000 ; i++){
        try{
            Thread.sleep(2000);
            WebElement msgSpace = webDriver.findElement(By.xpath("//div[contains(text(),'Type a message')]"));
            String TextToSend = text  + " " + i;
    Action mouseOverHome = builder
            .moveToElement(msgSpace)
            .sendKeys( TextToSend)
            .sendKeys(Keys.ENTER)
            .build();
            mouseOverHome.perform();

            System.out.println("--[INFO]--"+ i) ;
        }catch(Exception e){
            System.out.println("--[ERROR]--"+e);
            webDriver.findElement(By.xpath("//div[contains(text(),'Type a message')]")).sendKeys("Hi - test 0#");

        }
    }

          //   ---------------------------[Sending Msg - END]---------------------------  
       

    }
}
