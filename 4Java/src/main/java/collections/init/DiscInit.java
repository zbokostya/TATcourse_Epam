package collections.init;

import collections.create.CompositionCreator;
import collections.entity.Disc;
import collections.exception.InvalidDataException;
import collections.parse.CompositionParser;
import collections.util.CompositionType;

import java.util.List;

public class DiscInit {
    public Disc discInit(List<String> stringList) throws InvalidDataException {
        Disc disc = Disc.getInstance();
        CompositionType compositionType;
        CompositionParser compositionParser;
        CompositionCreator compositionCreator;
        for (String s : stringList) {
            try {
                compositionParser = new CompositionParser(s);
                compositionCreator = new CompositionCreator(compositionParser);
                compositionType = compositionParser.takeCompositionType();
                switch (compositionType) {
                    case MUSICAL:
                        disc.addComposition(compositionCreator.createMusicalComposition());
                        break;
                    case RECORD:
                        disc.addComposition(compositionCreator.createRecordComposition());
                        break;
                    default:
                        throw new InvalidDataException("There is no such composition");

                }
            } catch (InvalidDataException e) {
                throw new InvalidDataException("There is no such composition");
            }
        }
        return disc;
    }
}
