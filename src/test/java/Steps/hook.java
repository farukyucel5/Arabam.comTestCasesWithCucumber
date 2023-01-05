package Steps;


import DriverPackage.Driver;
import io.cucumber.java.After;

public class hook extends Driver {
    @After
    public void tearDown(){

        Driver.closeDriver();
    }
}
