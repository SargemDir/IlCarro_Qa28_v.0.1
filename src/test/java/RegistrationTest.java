import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().logout();
        }
    }

    @Test
    public void registrationTest(){

    }
}
