package collections.parse;

import collections.exception.InvalidDataException;
import collections.util.AudioStyle;
import collections.util.CompositionTags;
import collections.util.CompositionType;
import collections.util.Instruments;
import collections.valid.CompositionValidator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CompositionParser {
    private final String source;

    public CompositionParser(String source) {
        this.source = source.toUpperCase();
    }

    public String takeName() throws InvalidDataException {
        if (CompositionValidator.isCompositionValid(source)) {
            int index = source.indexOf(CompositionTags.NAME) + CompositionTags.NAME.length();

            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String str = scanner.next();
            return str;
        } else {
            throw new InvalidDataException("Not valid composition (Name)");
        }
    }

    public String takeArtist() throws InvalidDataException {
        if (CompositionValidator.isCompositionValid(source)) {
            int index = source.indexOf(CompositionTags.ARTIST) + CompositionTags.ARTIST.length();

            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");

            return scanner.next();
        } else {
            throw new InvalidDataException("Not valid composition (Artist)");
        }
    }

    public Duration takeDuration() throws InvalidDataException {
        if (CompositionValidator.isCompositionValid(source)) {
            int index = source.indexOf(CompositionTags.DURATION) + CompositionTags.DURATION.length();
            Scanner scanner = new Scanner(source.substring(index));

            scanner.useDelimiter("=| ");
            scanner.useLocale(Locale.US);

            return Duration.ofSeconds(scanner.nextInt());
        } else {
            throw new InvalidDataException("Not valid composition (Duration)");
        }
    }

    public AudioStyle takeAudioStyle() throws InvalidDataException {
        if (CompositionValidator.isCompositionValid(source)) {
            int index = source.indexOf(CompositionTags.AUDIO_STYLE) + CompositionTags.AUDIO_STYLE.length();

            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");

            String styleStr = scanner.next();

            if (CompositionValidator.isStyleValid(styleStr)) {
                return AudioStyle.valueOf(styleStr);
            } else {
                throw new InvalidDataException("Plane type not valid");
            }
        } else {
            System.out.println(source);
            throw new InvalidDataException("Not valid plane (Type Plane)");
        }
    }

    public List<Instruments> takeInstruments() throws InvalidDataException {
        if (CompositionValidator.isCompositionValid(source)) {
            int index = source.indexOf(CompositionTags.INSTRUMENTS) + CompositionTags.INSTRUMENTS.length();

            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("[= ]");

            String styleStr = scanner.nextLine();
            String[] instruments = styleStr.split(",");
            List<Instruments> rez = new ArrayList<>();
            for (String instrument : instruments) {
                if (CompositionValidator.isInstrumentsValid(instrument)) {
                    rez.add(Instruments.valueOf(instrument));
                } else {
                    throw new InvalidDataException("Plane type not valid");
                }
            }
            return rez;
        } else {
            System.out.println(source);
            throw new InvalidDataException("Not valid plane (Type Plane)");
        }
    }

    public CompositionType takeCompositionType() throws InvalidDataException {
        if (CompositionValidator.isCompositionValid(source)) {
            int index = source.indexOf(CompositionTags.TYPE) + CompositionTags.TYPE.length();

            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");

            String typeStr = scanner.next();

            if (CompositionValidator.isTypeValid(typeStr)) {
                return CompositionType.valueOf(typeStr);
            } else {
                throw new InvalidDataException("Composition type not valid");
            }
        } else {
            System.out.println(source);
            throw new InvalidDataException("Not valid composition (Type Composition)");
        }
    }
}
