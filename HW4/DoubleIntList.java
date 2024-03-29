//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw3;

public class DoubleIntList implements IntList {
    // the first and last nodes of the list
    public DoubleIntNode front, end;
    // tells how many nodes are in the list
    public int size;

    // Default constructor
    public DoubleIntList() {
        front = null;
        size = 0;
        end = null;
    }

    // Returns the size of the list
    public int size() {
        return size;
    }

    // Returns the first node of the list
    public DoubleIntNode getFront() {
        return front;
    }

    // Returns the last node of the list
    public DoubleIntNode getEnd() {
        return end;
    }

    /*===== Part 2 =====*/

    // Should be used in add and remove methods to check if the index is valid
    public void checkIndex(int index) {
        // Index should always be between 0 and size - 1
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + "and size: " + size);
        }
    }

    // Adds a new node to the end of the list
    public void add(int value) {

        // Checks if the list is empty so that the new node is both the front and end
        if (size == 0) {
            front = new DoubleIntNode(value);
            end = front;
        }
        // If the list is not empty, the new node is added to the end
        else {
            DoubleIntNode temp = new DoubleIntNode(end, value, null);
            end.next = temp;
            end = temp;
        }

        // Increase the size of the list
        size++;
    }

    // Adds a new node at the specified index
    public void add(int index, int value) {
        checkIndex(index);

        // Checks if the index is 0, the new node is added to the front
        if (index == 0) {
            DoubleIntNode temp = new DoubleIntNode(null, value, front);
            front.prev = temp;
            front = temp;
        }
        // Checks if the index is the size, the new node is added to the end
        else if (index == size) {
            DoubleIntNode temp = new DoubleIntNode(end, value, null);
            end.next = temp;
            end = temp;
        }
        // Checks if the index is in the middle, the new node is added in the middle
        else {
            DoubleIntNode current = front;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            DoubleIntNode temp = new DoubleIntNode(current.prev, value, current);
            current.prev.next = temp;
            current.prev = temp;
        }

        // Increase the size of the list
        size++;
    }

    //Check point
    //Part 3 toString
    public String toString(){
        StringBuilder result = new StringBuilder("[");

        // Checks if the list is empty and if it is, return an empty string
        if (size == 0) return result.append("]").toString();

        // Checks if the list is not empty and if it is, add the first node to the string
        DoubleIntNode current = front;
        result.append(current.data);

        // Add the rest of the nodes to the string
        for (int i = 0; i < size - 1; i++) {
            current = current.next;
            result.append(",").append(current.data);
        }

        // Return the string
        return result.append("]").toString();
    }
    //Check point
    //Part 4
    public void set(int index, int value){
        checkIndex(index);
        // Checks if the index is 0 and update the front node
        if (index == 0) front.data = value;

            // Checks if the index is the size - 1 and update the end node
        else if (index == size - 1) end.data = value;

            // Checks if the index is in the middle and update the node in the middle
        else {
            DoubleIntNode current = front;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.data = value;
        }
    }
    public int get(int index){
        //return value of the element at index
        //use checkIndex to make sure index is allowed
        checkIndex(index);

        // Checks if the index is 0 and return the data of the front node
        if (index == 0) return front.data;

        // Checks if the index is the size - 1 and return the data of the end node
        if (index == size - 1) return end.data;

        // Checks if the index is in the middle and return the data of the node in the middle
        DoubleIntNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }
    public int indexOf(int value){
        // Checks if the list is empty and return -1
        if (size == 0) return -1;

        // Checks every node in the list
        DoubleIntNode current = front;
        for (int i = 0; i < size; i++) {
            if (current.data == value) return i;
            current = current.next;
        }

        // For if the no node with the specified value is found
        return -1;
    }
    public boolean isEmpty(){
        //check if list is empty
        return size == 0;
    }
    //Check Point
    //Part 5
    public void remove(int index){
        //remove element from the list
        //make sure to update all the fields
        //and take care of all "corner" cases
        //you CAN'T use any extra space of O(n) size
        //you can't create any new nodes (use "new" key word is not allowed)
        //you can and should create helpers like the temp we used in LinkedIntList for all the methods
        checkIndex(index);

        // Checks if size is one or less and remove the only node
        if (index == 0) {
            if (front.next != null) {
                front = front.next;
                front.prev = null;
            } else {
                front = null;
                end = null;
            }
        }

        // Checks if the index is the size - 1 and remove the end node
        else if (index == size - 1) {
            end = end.prev;
            end.next = null;
        }

        // Checks if the index is in the middle and remove the node in the middle
        else {
            DoubleIntNode current = front;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        // Decrease the size of the list
        size--;
    }
    //Check Point
    //Part 6
    public void sort(){
        //Use selection sort to modify your list
        //at the end of your method your list should be sorted
        //you CAN'T use any extra space of O(n) size
        //you can't create any new nodes (use "new" key word is not allowed)
        //you can and should create helpers like the temp we used in LinkedIntList for all the methods
        //You also can't use methods like add or remove here
        //You must redirect links

        // Checks if the list is empty or one element it's already sorted
        if (size <= 1) return;

        // Current node we're looking at
        DoubleIntNode current = front;

        // Loop through the list
        for (int i = 0; i < size - 1; i++) {
            // This is the smallest node so far we've searched
            DoubleIntNode min = current;

            // Loop through the rest of the list again
            DoubleIntNode check = current.next;
            for (int j = i + 1; j < size; j++) {
                // And if we find a smaller value we set it to min
                if (check.data < min.data) min = check;
                check = check.next;
            }

            // Swaps the current node's data with the min value
            int temp = current.data;
            current.data = min.data;
            min.data = temp;

            // Move to the next node
            current = current.next;
        }
    }
}
