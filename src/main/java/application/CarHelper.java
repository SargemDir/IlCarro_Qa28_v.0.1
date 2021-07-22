package application;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        if (isCarFormPresent()){
            typeLocation(car.getAddress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());
            pause(7000);

        }

    }

    private void typeLocation(String address) {
        WebElement el = wd.findElement(By.id("pickUpPlace"));
        el.click();
        el.clear();
        el.sendKeys(address);
        pause(2000);
        wd.findElement(By.xpath("//div[@class='pac-item']")).click();
        pause(2000);

    }

    private boolean isCarFormPresent() {
        return wd.findElements(By.xpath("//h1[contains(.,'Let the car work')]")).size()>0;
    }

}
