import exception.TriangleException;
import model.Triangle;
import model.TriangleType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TriangleTest {
    private Triangle triangle;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void testEquilateral() {
        triangle = new Triangle.Builder().setTriangleASides(10)
                .setTriangleBSides(10).setTriangleCSides(10).build();
        Assert.assertTrue(triangle.isEquilateral());
    }

    @Test
    public void testIsTriangle() {
        triangle = new Triangle.Builder().setTriangleASides(10)
                .setTriangleBSides(10).setTriangleCSides(25).build();
        Assert.assertFalse(triangle.isTriangle());
    }

    @Test
    public void testIsIsosceles() {
        triangle = new Triangle.Builder().setTriangleASides(10)
                .setTriangleBSides(10).setTriangleCSides(15).build();
        Assert.assertTrue(triangle.isIsosceles());
    }

    @Test
    public void testTypes() {
        triangle = new Triangle.Builder().setTriangleASides(3)
                .setTriangleBSides(4).setTriangleCSides(5).build();
        Assert.assertEquals(TriangleType.RIGHT, triangle.getType());

        triangle = new Triangle.Builder().setTriangleASides(10)
                .setTriangleBSides(10).setTriangleCSides(10).build();
        Assert.assertEquals(TriangleType.EQUILATERAL, triangle.getType());

        triangle = new Triangle.Builder().setTriangleASides(10)
                .setTriangleBSides(10).setTriangleCSides(15).build();
        Assert.assertEquals(TriangleType.ISOSCELES, triangle.getType());

        triangle = new Triangle.Builder().setTriangleASides(10)
                .setTriangleBSides(10).setTriangleCSides(25).build();
        Assert.assertEquals(TriangleType.NOT_TRIANGLE, triangle.getType());

        triangle = new Triangle.Builder().setTriangleASides(13.2)
                .setTriangleBSides(11).setTriangleCSides(18.9).build();
        Assert.assertEquals(TriangleType.DEFAULT, triangle.getType());
    }

    @Test
    public void testCountArea() {
        double expected = 6;
        triangle = new Triangle.Builder().setTriangleASides(3)
                .setTriangleBSides(4).setTriangleCSides(5).build();
        Assert.assertEquals(triangle.getArea(), expected, 0.01);
    }

    @Test
    public void testCountPerimeter() {
        double expected = 42.0;
        triangle = new Triangle.Builder().setTriangleASides(17)
                .setTriangleBSides(15).setTriangleCSides(10).build();
        Assert.assertEquals(triangle.getPerimeter(), expected, 0.001);
    }

    @Test
    public void testSidesNegative() {
        expectedException.expect(TriangleException.class);
        expectedException.expectMessage("Sides can't be negative!");
        triangle = new Triangle.Builder().setTriangleASides(17)
                .setTriangleBSides(-115).setTriangleCSides(10).build();
    }
}
