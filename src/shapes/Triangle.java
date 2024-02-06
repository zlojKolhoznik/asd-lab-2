package shapes;

// Class that represents triangle - element of hash table.
public class Triangle {

    // Vertexes of the triangle
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Static method that checks if three points form a triangle.
    public static boolean isValidTriangle(Point a, Point b, Point c) {
        boolean ab = a.distanceTo(b) < (b.distanceTo(c) + c.distanceTo(a)); // True if ab < bc + ac.
        boolean bc = b.distanceTo(c) < (a.distanceTo(b) + c.distanceTo(a)); // True if bc < ab + ac.
        boolean ac = a.distanceTo(c) < (b.distanceTo(c) + a.distanceTo(b)); // True if ac < bc + ab.

        return ab && bc && ac; // Every side of a triangle must be less that sum of two other sides.
    }

    // Method that calculates perimeter of the triangle.
    public double getPerimeter() {
        return a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a);
    }

    // Method that calculates area of the triangle using Heron's formula.
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a.distanceTo(b)) * (p - b.distanceTo(c)) * (p - c.distanceTo(a)));
    }

    // String representation of the triangle.
    @Override
    public String toString() {
        return "Triangle: " + a + ", " + b + ", " + c;
    }
}
