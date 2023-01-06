package Steps;

import PageObject.ArabamComPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ArabamSteps {
    ArabamComPage arabamComPage =new ArabamComPage();
    @Given("Navigate to the website")
    public void navigateToTheWebsite() {
        arabamComPage.navigation();
    }

    @And("son yirmi dort saat linkine tıkla")
    public void sonYirmiDortSaatLinkineTıkla() {
        arabamComPage.clickTimeInterval();
    }

    @Then("Otomobil linkine tıkla")
    public void otomobilLinkineTıkla() throws InterruptedException {
        arabamComPage.setVehicleType();
        Thread.sleep(3000);
    }

    @And("Dacia markayı sec")
    public void daciaMarkayıSec() {
        arabamComPage.setBrand();
    }

    @Then("model  sec")
    public void modelSec() {
        arabamComPage.setModel();
    }

    @And("Minimum fiyat belirle {string}")
    public void minimumFiyatBelirle(String price){
        arabamComPage.setMinPrice(price);
    }

    @Then("verify thet the filters are applied")
    public void verifyThetTheFiltersAreApplied() {
        arabamComPage.filterAssert();

    }

    @And("get the filtered list of cars {string}")
    public void getTheFilteredListOfCars(String minPrice) {
        arabamComPage.getFilteredList(minPrice);
    }

    //==========Register test==================\\

    @And("Uye ol linkine tıkla")
    public void uyeOlLinkineTıkla() {
        arabamComPage.setSignUp();

    }

    @Then("fill in the register form")
    public void fillInTheRegisterForm(DataTable table) {

          arabamComPage.filling(table);

    }

    @And("click the check boxes and hit the registerButton")
    public void clickTheCheckBoxesAndHitTheRegisterButton() {
        arabamComPage.clickCheckBox();
    }

    @Then("verify that confirmation phone number button is visible")
    public void verifyThatConfirmationPhoneNumberButtonIsVisible() {
        arabamComPage.verifyConfirmationBtn();
    }

    @And("go to the very buttom of the page")
    public void goToTheVeryButtomOfThePage() {
        arabamComPage.scrollDownToEnd();

    }

    @Then("satilik araba butonuna tikla")
    public void satilikArabaButonunaTikla() {
        arabamComPage.Header();
    }


    @And("Tum alt basliklarin satilik icerdigini dogrula")
    public void tumAltBasliklarinSatilikIcerdiginiDogrula() {

    }

    @And("Tum alt basliklarin satilik icerdigini dogrula {string}")
    public void tumAltBasliklarinSatilikIcerdiginiDogrula(String onSale) {

        arabamComPage.subHeader(onSale);
    }
}