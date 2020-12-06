package read;

import collections.read.CompositionRead;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    @Test
    public void readTest() {
        List<String> strings1 = new ArrayList<>();

        String str1 = "type=record name=name1 duration=200 artist=artist1 INSTRUMENTS=guitar,piano";
        String str2 = "type=musical name=name2 duration=300 artist=artist2 AUDIOSTYLE=jazz";

        strings1.add(str1);
        strings1.add(str2);

        CompositionRead compositionRead = new CompositionRead();
        List<String> strings2 = compositionRead.read(compositionRead.getAbsolutePath("src/main/resources/compositions.txt"));

        Assert.assertEquals(strings1, strings2);
    }
}
