package collections.valid;

import collections.util.AudioStyle;
import collections.util.CompositionTags;
import collections.util.CompositionType;
import collections.util.Instruments;

import java.util.List;

public class CompositionValidator {
    public static boolean isCompositionValid(String composition) {
        composition = composition.toUpperCase();

        return composition.contains(CompositionTags.NAME) &&
                composition.contains(CompositionTags.ARTIST) &&
                composition.contains(CompositionTags.DURATION);
    }

    public static boolean isStyleValid(String typeStr) {
        AudioStyle[] audioStyles = AudioStyle.values();

        for (AudioStyle style : audioStyles) {
            if (style.toString().equalsIgnoreCase(typeStr)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isInstrumentsValid(String typeStr) {
        Instruments[] instruments = Instruments.values();

        for (Instruments style : instruments) {
            if (style.toString().equalsIgnoreCase(typeStr)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isTypeValid(String typeStr) {
        CompositionType[] typeCompositions = CompositionType.values();

        for (CompositionType typeComposition : typeCompositions) {
            if (typeComposition.toString().equalsIgnoreCase(typeStr)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isInstrumentsValid(List<String> instruments) {
        Instruments[] instruments1 = Instruments.values();
        for (Instruments value : instruments1) {
            if (instruments.stream().noneMatch(value.toString()::equalsIgnoreCase)) return false;
        }

        return true;
    }
}
