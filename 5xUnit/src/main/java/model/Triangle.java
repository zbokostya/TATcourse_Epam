package model;

import exception.TriangleException;

public class Triangle {
    private final double a;
    private final double b;
    private final double c;


    private Triangle(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public boolean isTriangle() {
        return !(a + b <= c ||
                a + c <= b ||
                b + c <= a);
    }

    public TriangleType getType() {
        if (!isTriangle()) return TriangleType.NOT_TRIANGLE;
        if (isRight()) return TriangleType.RIGHT;
        if (isEquilateral()) return TriangleType.EQUILATERAL;
        if (isIsosceles()) return TriangleType.ISOSCELES;
        return TriangleType.DEFAULT;
    }

    public boolean isRight() {
        return (a * a + b * b) == c * c ||
                (a * a + c * c) == b * b ||
                (b * b + c * c) == a * a;
    }

    public boolean isEquilateral() {
        return a == b && b == c;
    }

    public boolean isIsosceles() {
        return a == b || b == c || a == c;
    }

    public static class Builder {
        private double a = 0;
        private double b = 0;
        private double c = 0;

        public Builder setTriangleASides(double a) {
            this.a = a;
            return this;
        }

        public Builder setTriangleBSides(double b) {
            this.b = b;
            return this;
        }

        public Builder setTriangleCSides(double c) {
            this.c = c;
            return this;
        }

        public Triangle build() throws TriangleException {
            Triangle triangle = new Triangle(this);
            if(!triangle.isTriangle()) throw new TriangleException("Not a triangle");
            return triangle;
        }
    }

}
