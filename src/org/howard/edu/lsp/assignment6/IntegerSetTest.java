package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * JUnit test class for IntegerSet.
 * Tests all public methods including edge cases.
 * 
 * @author Your Name
 * @version 1.0
 */
public class IntegerSetTest {
    
    private IntegerSet set1;
    private IntegerSet set2;
    private IntegerSet set3;
    
    /**
     * Sets up test fixtures before each test.
     * Creates fresh IntegerSet instances for testing.
     */
    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
        set3 = new IntegerSet();
    }
    
    /**
     * Tests the clear method.
     */
    @Test
    @DisplayName("Test clear() method")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length());
        
        set1.clear();
        assertEquals(0, set1.length());
        assertTrue(set1.isEmpty());
    }
    
    /**
     * Tests the length method with empty and populated sets.
     */
    @Test
    @DisplayName("Test length() method")
    public void testLength() {
        assertEquals(0, set1.length());
        
        set1.add(1);
        assertEquals(1, set1.length());
        
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length());
        
        // Adding duplicate should not increase length
        set1.add(2);
        assertEquals(3, set1.length());
    }
    
    /**
     * Tests the equals method for various scenarios.
     */
    @Test
    @DisplayName("Test equals() method")
    public void testEquals() {
        // Empty sets should be equal
        assertTrue(set1.equals(set2));
        
        // Add same elements in different order
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(2);
        set2.add(1);
        
        assertTrue(set1.equals(set2));
        assertTrue(set2.equals(set1));
        
        // Different sets should not be equal
        set3.add(1);
        set3.add(2);
        assertFalse(set1.equals(set3));
        
        // Test with null
        assertFalse(set1.equals(null));
        
        // Test with different object type
        assertFalse(set1.equals("not a set"));
        
        // Test reflexivity (set equals itself)
        assertTrue(set1.equals(set1));
    }
    
    /**
     * Tests the contains method.
     */
    @Test
    @DisplayName("Test contains() method")
    public void testContains() {
        assertFalse(set1.contains(1));
        
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(4));
    }
    
    /**
     * Tests the largest method including exception case.
     */
    @Test
    @DisplayName("Test largest() method")
    public void testLargest() {
        // Test exception on empty set
        assertThrows(IllegalStateException.class, () -> {
            set1.largest();
        });
        
        set1.add(5);
        set1.add(10);
        set1.add(3);
        set1.add(7);
        
        assertEquals(10, set1.largest());
        
        // Test with negative numbers
        set2.add(-5);
        set2.add(-10);
        set2.add(-3);
        assertEquals(-3, set2.largest());
    }
    
    /**
     * Tests the smallest method including exception case.
     */
    @Test
    @DisplayName("Test smallest() method")
    public void testSmallest() {
        // Test exception on empty set
        assertThrows(IllegalStateException.class, () -> {
            set1.smallest();
        });
        
        set1.add(5);
        set1.add(10);
        set1.add(3);
        set1.add(7);
        
        assertEquals(3, set1.smallest());
        
        // Test with negative numbers
        set2.add(-5);
        set2.add(-10);
        set2.add(-3);
        assertEquals(-10, set2.smallest());
    }
    
    /**
     * Tests the add method including duplicate handling.
     */
    @Test
    @DisplayName("Test add() method")
    public void testAdd() {
        assertTrue(set1.isEmpty());
        
        set1.add(1);
        assertTrue(set1.contains(1));
        assertEquals(1, set1.length());
        
        // Adding duplicate should not change set
        set1.add(1);
        assertEquals(1, set1.length());
        
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length());
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
    }
    
    /**
     * Tests the remove method.
     */
    @Test
    @DisplayName("Test remove() method")
    public void testRemove() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set1.remove(2);
        assertFalse(set1.contains(2));
        assertEquals(2, set1.length());
        
        // Removing non-existent element should not cause error
        set1.remove(99);
        assertEquals(2, set1.length());
        
        set1.remove(1);
        set1.remove(3);
        assertTrue(set1.isEmpty());
    }
    
    /**
     * Tests the union method.
     */
    @Test
    @DisplayName("Test union() method")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        set1.union(set2);
        
        assertEquals(4, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        
        // Test union with empty set
        set3.union(set1);
        assertEquals(4, set3.length());
        assertTrue(set3.equals(set1));
        
        // Test union with self
        int originalLength = set1.length();
        set1.union(set1);
        assertEquals(originalLength, set1.length());
    }
    
    /**
     * Tests the intersect method.
     */
    @Test
    @DisplayName("Test intersect() method")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        set1.intersect(set2);
        
        assertEquals(2, set1.length());
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(4));
        
        // Test intersection with empty set
        set3.add(5);
        set3.intersect(set1);
        assertTrue(set3.isEmpty());
        
        // Test disjoint sets
        set1.clear();
        set1.add(1);
        set2.clear();
        set2.add(2);
        set1.intersect(set2);
        assertTrue(set1.isEmpty());
    }
    
    /**
     * Tests the diff method.
     */
    @Test
    @DisplayName("Test diff() method")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.diff(set2);
        
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(3));
        assertFalse(set1.contains(4));
        
        // Test diff with empty set
        int originalLength = set1.length();
        set1.diff(set3);
        assertEquals(originalLength, set1.length());
        
        // Test diff that removes all elements
        set1.clear();
        set1.add(1);
        set1.add(2);
        set2.clear();
        set2.add(1);
        set2.add(2);
        set1.diff(set2);
        assertTrue(set1.isEmpty());
    }
    
    /**
     * Tests the complement method.
     */
    @Test
    @DisplayName("Test complement() method")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        set1.complement(set2);
        
        assertEquals(2, set1.length());
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
        
        // Test complement with empty set
        set3.add(5);
        set3.complement(set1);
        assertEquals(2, set3.length());
        assertTrue(set3.equals(set1));
        
        // Test complement where other is subset
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(1);
        set1.complement(set2);
        assertTrue(set1.isEmpty());
    }
    
    /**
     * Tests the isEmpty method.
     */
    @Test
    @DisplayName("Test isEmpty() method")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty());
        
        set1.add(1);
        assertFalse(set1.isEmpty());
        
        set1.remove(1);
        assertTrue(set1.isEmpty());
        
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
    }
    
    /**
     * Tests the toString method.
     */
    @Test
    @DisplayName("Test toString() method")
    public void testToString() {
        assertEquals("[]", set1.toString());
        
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        String result = set1.toString();
        assertTrue(result.startsWith("["));
        assertTrue(result.endsWith("]"));
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("3"));
    }
}