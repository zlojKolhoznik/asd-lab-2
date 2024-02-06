package structures;

import shapes.Triangle;

// Class that represents a single-linked list - chain of elements in hash table.
public class SingleLinkedList {
    private int size = 0;               // Number of elements in the list.
    private SingleLinkedNode first;     // First element of the list.
    private SingleLinkedNode last;      // Last element of the list.

    // Method that adds an element to the list.
    public void add(Triangle element) {
        SingleLinkedNode node = new SingleLinkedNode(element);  // Create a new node.

        // If the list is empty, add first element as first and last.
        if (first == null) {
            first = node;
            last = node;
            size++;         // Increase size of the list.
            return;
        }

        // If the list is not empty, connect new node with last and reassign pointer.
        last.next = node;
        last = node;
        size++;
    }

    // Method that returns an element with specified index.
    public Triangle get(int index) {
        // If index is out of array size - throw an IndexOfBoundsException.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // Get node with specified index.
        SingleLinkedNode result = getNode(index);

        // Return triangle that is contained inside result.
        return result.data;
    }

    // Method that gets node with specified index.
    private SingleLinkedNode getNode(int index) {
        SingleLinkedNode current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Method that returns size of the list.
    public int getSize() {
        return size;
    }

    // Method that removes element with specified index.
    public void removeAt(int index) {
        // If index is out of array size - throw an IndexOfBoundsException.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        SingleLinkedNode toRemove = getNode(index);                 // Node that will be removed from list.
        SingleLinkedNode previous = getNode(index - 1);       // Previous node that will be connected with toRemove.next.
        previous.next = toRemove.next;

        // If toRemove is last node, reassign pointer last.
        if (previous.next == null) {
            last = previous;
        }
    }
}

// Class that represents node of single-linked data structure.
class SingleLinkedNode {
    public Triangle data;
    public SingleLinkedNode next;

    public SingleLinkedNode(Triangle data) {
        this.data = data;
    }
}
