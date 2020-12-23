package model.service;

import model.model.User;
import model.util.StringUtil;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_USER_ADDRESS = "testdata.user.address";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_ADDRESS));
    }

    public static User withRandom() {
        return new User(StringUtil.randomString(10),
                StringUtil.randomEmail(),
                StringUtil.randomString(8),
                "");
    }
}
