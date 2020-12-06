package collections.action;


import collections.comparator.CompositionComparator;
import collections.entity.Composition;
import collections.entity.Disc;

import java.time.Duration;
import java.util.List;

public class Actions {
    public Duration getDiscDuration(Disc disc) {
        Duration rez = Duration.ZERO;
        for (Composition composition : disc.getCompositions()) {
            rez = rez.plus(composition.getDuration());
        }
        return rez;
    }

    public List<Composition> sortByStyles(Disc disc) {
        List<Composition> musicalCompositions = disc.getCompositions();
        musicalCompositions.sort(new CompositionComparator());
        disc.setCompositions(musicalCompositions);
        return musicalCompositions;
    }

    public List<Composition> getMusicalByDuration(Disc disc, Duration from, Duration to) {
        List<Composition> musicalCompositions = disc.getCompositions();
        musicalCompositions.removeIf(musicalComposition -> !(musicalComposition.getDuration().getSeconds() < to.getSeconds() &&
                musicalComposition.getDuration().getSeconds() > from.getSeconds()));
        return musicalCompositions;
    }
}
