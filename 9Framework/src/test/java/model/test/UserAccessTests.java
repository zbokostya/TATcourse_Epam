package model.test;

import model.model.User;
import model.page.HomePage;
import model.service.TestDataReader;
import model.service.UserCreator;
import model.util.StringParserUtil;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserAccessTests extends CommonConditions {

    public static final String TESTDATA_SEARCH_CITY = "testdata.search.city";

    @Test
    public void signIn() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserEmail = new HomePage(driver)
                .openPage()
                .login(testUser)
                .getUserEmail();
        Assert.assertEquals(loggedInUserEmail, testUser.getEmail());

    }

    @Test
    public void register() {
        User testUser = UserCreator.withRandom();
        System.out.println(testUser.toString());
        String loggedInUserEmail = new HomePage(driver)
                .openPage()
                .openRegisterPage()
                .inputRegisterInForm(testUser)
                .register()
                .login(testUser)
                .getUserEmail();
        Assert.assertEquals(loggedInUserEmail, testUser.getEmail());
    }

    @Test
    public void changeAddress() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String address = new HomePage(driver)
                .openPage()
                .login(testUser)
                .openChangeDataWindow()
                .changeAddress(testUser.getAddress())
                .saveChanges()
                .getAddress();
        Assert.assertEquals(address, testUser.getAddress());
    }

    @Test
    public void changeCity() {
        String city = new HomePage(driver)
                .openPage()
                .openChangeCityWindow()
                .selectCity(TestDataReader.getTestData(TESTDATA_SEARCH_CITY))
                .acceptCity()
                .getCity();
        String actual = StringParserUtil.parseText(city);
        Assert.assertEquals(actual, TestDataReader.getTestData(TESTDATA_SEARCH_CITY));
    }


}
