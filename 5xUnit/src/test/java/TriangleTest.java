import model.Triangle;
import model.TriangleType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {
    private Triangle triangle;


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
        Assert.assertEquals(triangle.getType(), TriangleType.RIGHT);

        triangle = new Triangle.Builder().setTriangleASides(10)
                .setTriangleBSides(10).setTriangleCSides(25).build();
        Assert.assertEquals(triangle.getType(), TriangleType.NOT_TRIANGLE);

        triangle = new Triangle.Builder().setTriangleASides(13.2)
                .setTriangleBSides(11).setTriangleCSides(18.9).build();
        Assert.assertEquals(triangle.getType(), TriangleType.DEFAULT);
    }

    @Test
    public void testCountArea() {
        double expected = 6;
        triangle = new Triangle.Builder().setTriangleASides(3)
                .setTriangleBSides(4).setTriangleCSides(5).build();
        Assert.assertEquals(triangle.getArea(), expected);
    }

    @Test
    public void testCountPerimeter() {
        double expected = 42;
        triangle = new Triangle.Builder().setTriangleASides(17)
                .setTriangleBSides(15).setTriangleCSides(10).build();
        Assert.assertEquals(triangle.getPerimeter(), expected);
    }


}
