package collections.entity;

import collections.util.CompositionType;
import collections.util.Instruments;

import java.time.Duration;
import java.util.List;

public class RecordComposition extends Composition {
    private List<Instruments> instruments;
    private final CompositionType type;

    public RecordComposition(String name, Duration duration, String artist, List<Instruments> instruments, CompositionType type) {
        super(name, duration, artist);
        this.instruments = instruments;
        this.type = type;
    }

    public List<Instruments> getInstruments() {
        return instruments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecordComposition{");
        sb.append("instruments=").append(instruments);
        sb.append('}');
        return sb.toString();
    }
}
