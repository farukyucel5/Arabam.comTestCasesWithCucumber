package PageObject;

import DriverPackage.Driver;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractClass {

    private WebDriver driver = Driver.getDriver();




    public  void navigation(){
        driver.get("https://www.arabam.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void clickFunction(WebElement clickElement){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement clickElement1=wait.until(ExpectedConditions.visibilityOf(clickElement));
        clickElement1.click();
    }

    public void sendKeysFunction(WebElement sendKeysElement, String value){

        sendKeysElement.sendKeys(value);

    }

    public void selectElementFromDropdown(WebElement dropdown,String element){

        Select slc = new Select(dropdown);

        slc.selectByVisibleText(element);

    }


    public void Assertion(WebElement actual,String expected){
        Assert.assertEquals(actual.getText(),expected);
        System.out.println("My Message :  " + actual.getText());

    }
    public void Assertion(String actual,String expected){
        Assert.assertEquals(actual,expected);
        System.out.println("My Message :  " + actual);

    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,270)", "");
    }
    public void dragAndDrop(WebElement drag,WebElement drop){
        Actions actions=new Actions(driver);

        actions.dragAndDrop(drag,drop).build().perform();
    }

    public void jsClick(WebElement element){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement clickElement1=wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",element);

    }

    public void filtering(List<WebElement> cars,String minPrice,WebElement noResult){
        int price=Integer.parseInt(minPrice);//string minPrice is converted to integer
        List<String> priceList=cars.stream().map(WebElement::getText).collect(Collectors.toList());
        //we get the text of the price elements

        if (priceList.size()>0) {

            List<String> replacedList = priceList.stream().map(n -> n.replace(" TL", "")).collect(Collectors.toList());
            //we removed the letters and dot from the text in order to convert all to integer value
            List<String> replaced2 = replacedList.stream().map(n -> n.replace(".", "")).collect(Collectors.toList());


            List<Integer> intPriceList = replaced2.stream().map(Integer::parseInt).collect(Collectors.toList());
            //all string prices are converted to integer

            intPriceList.forEach(n -> Assert.assertTrue(n > price));
            //verifying that all prices are greater than minPrice passed in

            System.out.println("==============Filtered================");
            intPriceList.forEach(System.out::println);
        }else{
            Assert.assertTrue(noResult.isDisplayed());
            System.out.println("SORRY NO RESULT FOUND!! TRY AGAIN");
        }

    }

    //========================Register============================\\

    public void fillInTheForm(DataTable table,WebElement nameBox){

     List<List<String>> data=table.cells();
        Actions actions=new Actions(driver);

        actions.click(nameBox).sendKeys(data.get(0).get(0)).sendKeys(Keys.TAB).
                sendKeys(data.get(0).get(1)).sendKeys(Keys.TAB).sendKeys(data.get(0).get(2)).
                sendKeys(Keys.TAB).sendKeys(data.get(0).get(3)).perform();

        Driver.waiting(4);

    }

    public void assertions(WebElement element){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement assertElement1=wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(assertElement1.isDisplayed());
    }

}
