package parse;

import collections.exception.InvalidDataException;
import collections.parse.CompositionParser;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParserTest {
    @Test
    public void parseTest() throws InvalidDataException {
        CompositionParser compositionParser = new CompositionParser("type=record name=name1 duration=200 artist=artist INSTRUMENTS=guitar,piano");

        Assert.assertEquals("RECORD", compositionParser.takeCompositionType().toString());
        Assert.assertEquals("NAME1", compositionParser.takeName());
        Assert.assertEquals(200, compositionParser.takeDuration().getSeconds());
        List<String> strings = compositionParser.takeInstruments().stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("GUITAR", "PIANO"), strings);
        Assert.assertEquals("ARTIST", compositionParser.takeArtist());
    }
}
