package collections.create;

import collections.entity.MusicalComposition;
import collections.entity.RecordComposition;
import collections.exception.InvalidDataException;
import collections.parse.CompositionParser;

public class CompositionCreator {
    private final CompositionParser compositionParser;

    public CompositionCreator(CompositionParser compositionParser) {
        this.compositionParser = compositionParser;
    }

    public MusicalComposition createMusicalComposition() throws InvalidDataException {
        return new MusicalComposition(
                compositionParser.takeName(),
                compositionParser.takeDuration(),
                compositionParser.takeArtist(),
                compositionParser.takeAudioStyle(),
                compositionParser.takeCompositionType());
    }
    public RecordComposition createRecordComposition() throws InvalidDataException {
        return new RecordComposition(
                compositionParser.takeName(),
                compositionParser.takeDuration(),
                compositionParser.takeArtist(),
                compositionParser.takeInstruments(),
                compositionParser.takeCompositionType());
    }
}
