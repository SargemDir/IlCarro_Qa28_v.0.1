package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHelper extends HelperBase{
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void typeSearchCurrentMonth(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        typeInputPeriod(dataFrom,dataTo);
    }

    private void typeInputPeriod(String dataFrom, String dataTo) {
        type(By.id("dates"),dataFrom + " - " + dataTo);
        click(By.cssSelector("div.cdk-overlay-container"));

    }

    private void fillInputCity(String city) {
        type(By.id("city"),city);
        pause(500);
        click(By.xpath("//div[@class='pac-item']"));

    }

    public boolean isListOfCarAppeared() {
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public boolean isDataInPath() {
        WebElement warning = wd.findElement(By.xpath("//div[@class='ng-star-inserted']"));
        String warningTxt = warning.getText();

        new WebDriverWait(wd,10)
                .until(ExpectedConditions.textToBePresentInElement(warning,warningTxt));
        return warningTxt.contains("before today");
    }

    public boolean buttonYallaInactive() {
        WebElement yallaBtn = wd.findElement(By.xpath("//button[@type='submit']"));
        return !yallaBtn.isEnabled();
    }
}
