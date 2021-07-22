import models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewcarTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        //login
    }

    @Test
    public void createNewCar(){
       Car car = Car.builder()
               .address("Tel Aviv, Israel")
               .make("BMW")
               .model("M5")
               .year("2020")
               .engine("2.0")
               .fuel("Petrol")
               .gear("MT")
               .wD("AWD")
               .doors("5")
               .seats("4")
               .clasS("C")
               .fuelConsumption("6.5")
               .carRegNumber("100-67-14")
               .price("65")
               .distanceIncluded("500")
               .typeFeature("type of")
               .about("very good car")
               .build();

       app.carHelper().openCarForm();
       app.carHelper().fillCarForm(car);

    }
}
