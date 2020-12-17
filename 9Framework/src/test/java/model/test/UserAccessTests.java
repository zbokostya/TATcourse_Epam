package model.test;

import model.model.User;
import model.page.HomePage;
import model.service.UserCreator;
import org.junit.Assert;
import org.junit.Test;

public class UserAccessTests extends CommonConditions {

    @Test
    public void signIn() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserEmail = new HomePage(driver)
                .openPage()
                .openSignInPage()
                .signIn(testUser)
                .openProfilePage()
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
                .openSignInPage()
                .signIn(testUser)
                .openProfilePage()
                .getUserEmail();
        Assert.assertEquals(loggedInUserEmail, testUser.getEmail());
    }
}
