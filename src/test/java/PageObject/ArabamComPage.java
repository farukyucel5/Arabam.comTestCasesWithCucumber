package PageObject;

import DriverPackage.Driver;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ArabamComPage extends AbstractClass {


    private  WebDriver driver;

    public ArabamComPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[text()='Son 24 Saat']")
    private WebElement timeInterval;
    public void clickTimeInterval(){

        clickFunction(timeInterval);
    }

    @FindBy(xpath = "//a[@href='otomobil']")
    private WebElement vehicleType;

    public void setVehicleType(){
        clickFunction(vehicleType);
    }

    @FindBy(xpath = "(//a[@class='list-item'])[8]")
    private WebElement dacia;

    public void setBrand(){

       jsClick(dacia);
    }

    @FindBy(xpath = "//*[@href='otomobil/dacia-logan']")
    private WebElement logan;


    public void setModel(){

        clickFunction(logan);
    }


    @FindBy(xpath = "(//button[@class='facet-button closed'])[1]")
    private WebElement fiyat;
    @FindBy(xpath = "//*[@*='Min TL']")
    private WebElement minPriceBox;

    @FindBy(xpath = "(//*[@class='btn btn-search'])[1]")
    private WebElement araBtn;

    public void setMinPrice(String price) {
        jsClick(fiyat);
        sendKeysFunction(minPriceBox,price);
        clickFunction(araBtn);
        Driver.waiting(4);
    }

    @FindBy(xpath = "(//*[@class='filter-value'])[1]")
    private WebElement timeFilter;
    @FindBy(xpath = "(//*[@class='filter-value'])[2]")
    private WebElement priceFilter;

    public void filterAssert(){
        Assert.assertTrue(timeFilter.isDisplayed() && priceFilter.isDisplayed());
    }
    @FindBy(xpath = "//span[@class='db no-wrap listing-price']")
    private List<WebElement> filteredList;
    @FindBy(className = "no-result-content")
    private static WebElement noResult;

    public void getFilteredList(String minPrice){

        filtering(filteredList,minPrice,noResult);
    }

    //==========Register test==================\\

    @FindBy(xpath = "//*[@aria-label='Üye ol']")
    private static WebElement signUp;
    public void setSignUp(){
        clickFunction(signUp);
    }

    @FindBy(xpath = "//*[@id='name']")
    private static WebElement nameBox;
    public void filling(DataTable table){

        fillInTheForm(table,nameBox);


    }

    @FindBy(xpath = "(//*[@class='check-mark'])[1]")
    private static WebElement checkBox1;
    @FindBy(xpath = "//*[text()='Tamam']")
    private static WebElement confirmationBtn;
    @FindBy(xpath = "(//*[@class='check-mark'])[2]")
    private static WebElement checkBox2;
    @FindBy(xpath = "(//*[@class='check-mark'])[3]")
    private static WebElement checkBox3;
    @FindBy(xpath = "//*[@type='submit']")
    private static WebElement submit;
    public void clickCheckBox(){
        clickFunction(checkBox1);
        clickFunction(confirmationBtn);
        clickFunction(checkBox2);
        clickFunction(checkBox3);
        jsClick(submit);

    }
    @FindBy(xpath = "//*[text()='Doğrulama Kodu Gönder']")
    private static WebElement getConfirmationBtn;

    public void verifyConfirmationBtn(){

        assertions(getConfirmationBtn);
    }

    //==========header verification===============\\


    @FindBy(xpath = "//*[@class='tab-button active']")
    private static  WebElement header;
    public void Header(){

        clickFunction(header);

    }

    @FindBy(xpath = "//*[@*='tab-content active']/div")
    private static List<WebElement> subHeadlines;

    public void subHeader(String word){
        contentCheck(subHeadlines,word);


    }























}
