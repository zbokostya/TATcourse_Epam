package actions;

import collections.action.Actions;
import collections.entity.Disc;
import collections.exception.InvalidDataException;
import collections.init.DiscInit;
import collections.read.CompositionRead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ActionsTest {
    @BeforeClass
    public static void initTest() throws InvalidDataException {
        CompositionRead compositionRead = new CompositionRead();
        DiscInit discInit = new DiscInit();
        discInit.discInit(compositionRead.read(compositionRead.getAbsolutePath("src/main/resources/compositions.txt")));
    }

    @Test
    public void discDurationTest() {
        Disc disc = Disc.getInstance();

        long expected = 500L;
        long actual = new Actions().getDiscDuration(disc).getSeconds();
        Assert.assertEquals(expected,actual,0.01);
    }

}
