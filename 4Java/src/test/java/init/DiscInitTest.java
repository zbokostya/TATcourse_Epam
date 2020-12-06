package init;

import collections.entity.Disc;
import collections.exception.InvalidDataException;
import collections.init.DiscInit;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class DiscInitTest {
    @Test
    public void initTest()throws InvalidDataException {
        LinkedList<String> strings = new LinkedList<>();

        strings.add("type=musical name=name1 duration=200 artist=artist audiostyle=jazz");

        DiscInit discInit = new DiscInit();
        Disc disc = discInit.discInit(strings);

        int expected = 1;
        int actual = disc.getCompositionSize();
        Assert.assertEquals(expected,actual);
    }
}
