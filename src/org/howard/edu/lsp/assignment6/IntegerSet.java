package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet class represents a mathematical set of integers.
 * A set cannot contain duplicate elements and supports standard set operations
 * such as union, intersection, difference, and complement.
 * 
 * @author Your Name
 * @version 1.0
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Clears the internal representation of the set.
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if the 2 sets are equal, false otherwise.
     * Two sets are equal if they contain all of the same values in ANY order.
     * This overrides the equals method from the Object class.
     * 
     * @param o the object to compare with this set
     * @return true if the sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof IntegerSet)) {
            return false;
        }
        IntegerSet other = (IntegerSet) o;
        
        // Check if sizes are different
        if (this.length() != other.length()) {
            return false;
        }
        
        // Check if all elements in this set are in the other set
        return set.containsAll(other.set) && other.set.containsAll(set);
    }

    /**
     * Returns true if the set contains the value, otherwise false.
     * 
     * @param value the value to search for
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * 
     * @return the maximum value in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Cannot find largest element in an empty set");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     * 
     * @return the minimum value in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Cannot find smallest element in an empty set");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set or does nothing if already present.
     * 
     * @param item the value to add to the set
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if not there.
     * 
     * @param item the value to remove from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Set union: modifies this set to contain all unique elements in this or other.
     * After this operation, the set contains all elements from both sets.
     * 
     * @param other the set to union with this set
     */
    public void union(IntegerSet other) {
        for (Integer item : other.set) {
            if (!set.contains(item)) {
                set.add(item);
            }
        }
    }

    /**
     * Set intersection: modifies this set to contain only elements in both sets.
     * After this operation, the set contains only elements that were in both sets.
     * 
     * @param other the set to intersect with this set
     */
    public void intersect(IntegerSet other) {
        set.retainAll(other.set);
    }

    /**
     * Set difference (this \ other): modifies this set to remove elements found in other.
     * After this operation, the set contains only elements that were in this set but not in other.
     * 
     * @param other the set whose elements will be removed from this set
     */
    public void diff(IntegerSet other) {
        set.removeAll(other.set);
    }

    /**
     * Set complement: modifies this set to become (other \ this).
     * After this operation, the set contains elements that are in other but not in the original this.
     * 
     * @param other the set to take the complement with respect to
     */
    public void complement(IntegerSet other) {
        List<Integer> result = new ArrayList<Integer>();
        for (Integer item : other.set) {
            if (!set.contains(item)) {
                result.add(item);
            }
        }
        set = result;
    }

    /**
     * Returns true if the set is empty, false otherwise.
     * 
     * @return true if the set has no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a String representation of the set.
     * The format is elements enclosed in square brackets separated by commas.
     * 
     * @return a string representation of the set
     */
    @Override
    public String toString() {
        return set.toString();
    }
}