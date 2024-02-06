import shapes.Point;
import shapes.Triangle;
import structures.HashTable;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hashTableSize;
        HashTable hashTable;
        double area;

        // Read size of the hash table from user and create hash table with specified size.
        System.out.print("Enter size of hash table: ");
        hashTableSize = scanner.nextInt();
        hashTable = new HashTable(hashTableSize);

        // Loop that initializes hash table.
        for (int i = 0; i < hashTableSize; i++) {
            Point a = getRandomPoint();
            Point b = getRandomPoint();
            Point c = getRandomPoint();

            // If three points form a valid triangle, add it to the hash table
            if (Triangle.isValidTriangle(a, b, c)) {
                Triangle triangle = new Triangle(a, b, c);
                hashTable.add(triangle);
                continue;
            }

            i--;    // If we've got this far, triangle is invalid - repeat iteration
        }

        System.out.println(hashTable);

        // Read target area and remove all triangles with area smaller than specified.
        System.out.print("Enter target area: ");
        area = scanner.nextDouble();
        hashTable.removeWhereAreaLessThan(area);

        System.out.println("Table with removed triangles:");
        System.out.println(hashTable);
    }

    // Method that generates a point with random coordinates from
    private static Point getRandomPoint() {
        Random random = new Random();
        double x = Math.round((random.nextDouble() * 100 - 50) * 100) / 100.0; // Set x coordinate to random number from -50 to 50 with precision of 2 digits after comma
        double y = Math.round((random.nextDouble() * 100 - 50) * 100) / 100.0; // Set y coordinate to random number from -50 to 50 with precision of 2 digits after comma

        return new Point(x, y);
    }
}
