import model.ExperimentalPlane;
import model.MilitaryPlane;
import model.PassengerPlane;
import model.Plane;
import org.testng.Assert;
import org.testng.annotations.Test;
import type.ExperimentalPlaneClassification;
import type.ExperimentalPlaneType;
import type.MilitaryPlaneType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ExperimentalPlaneClassification.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ExperimentalPlaneClassification.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        Assert.assertTrue(airport.getTransportMilitaryPlanes().stream().allMatch(plane -> plane.getType() == MilitaryPlaneType.TRANSPORT));
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();

        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        Assert.assertTrue(IntStream.range(0, airport.getPlanes().size() - 2)
                .allMatch(i -> planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity()
                        <= planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()));
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertTrue(bomberMilitaryPlanes.stream()
                .anyMatch(plane -> plane.getType() == MilitaryPlaneType.BOMBER));
    }

    @Test
    public void testExperimentalPlanesHasClassificationHigherThanUnclassified() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        Assert.assertTrue(experimentalPlanes.stream()
                .anyMatch(plane -> plane.getClassification() != ExperimentalPlaneClassification.UNCLASSIFIED));
    }
}
