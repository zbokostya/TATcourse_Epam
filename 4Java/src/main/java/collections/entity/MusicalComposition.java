package collections.entity;

import collections.util.AudioStyle;
import collections.util.CompositionType;

import java.time.Duration;

public class MusicalComposition extends Composition{
    private final AudioStyle audioStyle;
    private final CompositionType type;

    public MusicalComposition(String name, Duration duration, String artist, AudioStyle audioStyle, CompositionType type) {
        super(name, duration, artist);
        this.audioStyle = audioStyle;
        this.type = type;
    }

    public AudioStyle getAudioStyle() {
        return audioStyle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MusicalComposition{");
        sb.append("audioStyle=").append(audioStyle);
        sb.append('}');
        return sb.toString();
    }
}
