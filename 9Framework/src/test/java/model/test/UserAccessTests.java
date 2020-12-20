package model.test;

import model.model.User;
import model.page.HomePage;
import model.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserAccessTests extends CommonConditions {

    @Test
    public void signIn() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserEmail = new HomePage(driver)
                .login(testUser)
                .getUserEmail();
        Assert.assertEquals(loggedInUserEmail, testUser.getEmail());

    }

    @Test
    public void register() {
        User testUser = UserCreator.withRandom();
        String loggedInUserEmail = new HomePage(driver)
                .openPage()
                .openRegisterPage()
                .register(testUser)
                .login(testUser)
                .getUserEmail();
        Assert.assertEquals(loggedInUserEmail, testUser.getEmail());
    }

    @Test
    public void changeAddress() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String address = new HomePage(driver)
                .login(testUser)
                .openChangeDataWindow()
                .changeAddress("пр.Рокосовского 100-12")
                .saveChanges()
                .getAddress();
        Assert.assertEquals(address, "пр.Рокосовского 100-12");
    }

    @Test
    public void changeCity() {
        String city = new HomePage(driver)
                .openChangeCityWindow()
                .selectCity("Поставы")
                .acceptCity()
                .getCity();
        Assert.assertEquals(city, "Поставы");
    }


}
