package collections.entity;

import collections.exception.InvalidDataException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Disc {
    private List<Composition> compositions;
    Duration capacity = Duration.ofSeconds(5000);
    private static final Disc INSTANCE = new Disc();

    public Disc() {
        compositions = new ArrayList<>();
    }

    public static Disc getInstance() {
        return INSTANCE;
    }

    public Disc(List<Composition> compositions) throws InvalidDataException {
        this.compositions = compositions;
        Duration rez = Duration.ZERO;
        for (Composition composition : compositions) {
            rez = rez.plus(composition.getDuration());
        }
        if (capacity.minus(rez).getSeconds() > 0) {
            capacity = capacity.minus(rez);
        } else throw new InvalidDataException("Disc is full");
    }

    public List<Composition> getCompositions() {
        return compositions;
    }
    public int getCompositionSize() {
        return compositions.size();
    }


    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }

    public void addComposition(Composition composition) throws InvalidDataException {
        compositions.add(composition);
        if (capacity.minus(composition.getDuration()).getSeconds() > 0) {
            capacity = capacity.minus(composition.getDuration());
        } else throw new InvalidDataException("Disc is full");
    }


    public Duration getCapacity() {
        return capacity;
    }

    public void setCapacity(Duration capacity) {
        this.capacity = capacity;
    }
}
