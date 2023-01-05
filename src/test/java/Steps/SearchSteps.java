package Steps;

import DriverPackage.Driver;
import PageObject.PageLocatorClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class SearchSteps{
    PageLocatorClass pageClass=new PageLocatorClass();
    @Given("Navigate to the website")
    public void navigateToTheWebsite() {
        pageClass.navigation();
    }

    @And("son yirmi dort saat linkine tıkla")
    public void sonYirmiDortSaatLinkineTıkla() {
        pageClass.clickTimeInterval();
    }

    @Then("Otomobil linkine tıkla")
    public void otomobilLinkineTıkla() throws InterruptedException {
        pageClass.setVehicleType();
        Thread.sleep(3000);
    }

    @And("Dacia markayı sec")
    public void daciaMarkayıSec() {
        pageClass.setBrand();
    }

    @Then("model  sec")
    public void modelSec() {
        pageClass.setModel();
    }

    @And("Minimum fiyat belirle {string}")
    public void minimumFiyatBelirle(String price){
        pageClass.setMinPrice(price);
    }

    @Then("verify thet the filters are applied")
    public void verifyThetTheFiltersAreApplied() {
        pageClass.filterAssert();

    }

    @And("get the filtered list of cars {string}")
    public void getTheFilteredListOfCars(String minPrice) {
        pageClass.getFilteredList(minPrice);
    }

    //==========Register test==================\\

    @And("Uye ol linkine tıkla")
    public void uyeOlLinkineTıkla() {
        pageClass.setSignUp();

    }

    @Then("fill in the register form")
    public void fillInTheRegisterForm(DataTable table) {

          pageClass.filling(table);

    }

    @And("click the check boxes and hit the registerButton")
    public void clickTheCheckBoxesAndHitTheRegisterButton() {
        pageClass.clickCheckBox();
    }

    @Then("verify that confirmation phone number button is visible")
    public void verifyThatConfirmationPhoneNumberButtonIsVisible() {
        pageClass.verifyConfirmationBtn();
    }
}