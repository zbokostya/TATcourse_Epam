package collections.util;

public enum Instruments {
    GUITAR("guitar"),
    PIANO("piano"),
    DRUM("drum"),
    TRIANGLE("triangle");


    private final String instruments;

    Instruments(String instruments) {
        this.instruments = instruments;
    }

    public String getDescription() {
        return instruments;
    }
}
