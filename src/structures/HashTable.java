package structures;

import shapes.Triangle;

// Class that represents hash table with separate chaining.
public class HashTable {
    private int size;                       // Size of hash table (impossible to change in the future).
    private SingleLinkedList[] table;       // Array of single linked lists to store elements of the table.
                                            // This also implements separate chaining.

    public HashTable(int size) {
        this.size = size;
        table = new SingleLinkedList[this.size];
    }


    // Method that adds element to hash table.
    public boolean add(Triangle element) {
        int key = (int) element.getPerimeter();     // Use integer part of perimeter as key.
        int hash = getHash(key);                    // Calculate hash.
        SingleLinkedList list = table[hash];        // Get list that corresponds to calculated hash.

        // If there is no list on this position, create new one.
        if (list == null) {
            table[hash] = new SingleLinkedList();
            list = table[hash];
        }

        list.add(element); // Add elements to the list.

        return true;
    }

    // Method that returns list of elements with hash that corresponds to given key.
    public SingleLinkedList get(int key) {
        return table[getHash(key)];
    }

    // Calculates hash using formula 'key mod size'.
    private int getHash(int key) {
        return key % size;
    }

    // Method that removes all the triangles with area less than given with parameter.
    public void removeWhereAreaLessThan(double area) {
        // Iterate through every element in the table.
        for (SingleLinkedList list : table) {
            // If hash has no elements - skip it.
            if (list == null) {
                continue;
            }

            // Iterate through every element in the chain and delete it if it meets the condition.
            for (int i = 0; i < list.getSize(); i++) {
                if (list.get(i).getArea() < area) {
                    list.removeAt(i);
                }
            }
        }
    }

    // String representation of hash table.
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Hash\t|Key\t\t\t\t|Element\n-----------------------------------------------------------------------------------------\n");
        for (int i = 0; i < size; i++) {
            SingleLinkedList list = table[i];
            result.append(i).append("\t\t|");
            if (list == null) {
                result.append("No element with this hash\n").append("-----------------------------------------------------------------------------------------\n");
                continue;
            }

            for (int j = 0; j < list.getSize(); j++) {
                Triangle element = list.get(j);
                if (j != 0) {
                    result.append("\t\t|");
                }

                result.append(element.getPerimeter()).append("\t|");
                result.append(element).append("\n");
            }
            result.append("-----------------------------------------------------------------------------------------\n");
        }

        return result.toString();
    }
}
