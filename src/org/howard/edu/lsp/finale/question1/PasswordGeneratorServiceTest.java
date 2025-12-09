package org.howard.edu.lsp.finale.question1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordGeneratorServiceTest {
    
    private PasswordGeneratorService service;
    
    /**
     * Sets up the test fixture before each test method.
     * Retrieves the singleton instance of PasswordGeneratorService.
     */
    @BeforeEach
    public void setup() {
        service = PasswordGeneratorService.getInstance();
    }
    
    /**
     * Tests that getInstance() returns a non-null instance.
     */
    @Test
    public void checkInstanceNotNull() {
        assertNotNull(service, "getInstance() should return a non-null instance");
    }
    
    /**
     * Tests that getInstance() always returns the exact same instance (true Singleton behavior).
     * Verifies that multiple calls to getInstance() return the same object in memory.
     */
    @Test
    public void checkSingleInstanceBehavior() {
        PasswordGeneratorService second = PasswordGeneratorService.getInstance();
        
        // Use assertSame to verify they are the EXACT same object in memory
        assertSame(service, second, 
            "getInstance() must return the same instance every time (Singleton pattern)");
    }
    
    /**
     * Tests that calling generatePassword() without setting an algorithm throws IllegalStateException.
     */
    @Test
    public void generateWithoutSettingAlgorithmThrowsException() {
        PasswordGeneratorService s = PasswordGeneratorService.getInstance();
        
        // Attempt to generate password without setting algorithm should throw exception
        assertThrows(IllegalStateException.class, () -> {
            s.generatePassword(10);
        }, "generatePassword() should throw IllegalStateException when no algorithm is set");
    }
    
    /**
     * Tests that the basic algorithm generates passwords of correct length containing only digits.
     */
    @Test
    public void basicAlgorithmGeneratesCorrectLengthAndDigitsOnly() {
        service.setAlgorithm("basic");
        String p = service.generatePassword(10);
        
        // Verify length
        assertEquals(10, p.length(), "Password length should be 10");
        
        // Verify all characters are digits (0-9)
        assertTrue(p.matches("[0-9]+"), 
            "Basic algorithm password should contain only digits (0-9)");
    }
    
    /**
     * Tests that the enhanced algorithm generates passwords of correct length 
     * containing valid characters (A-Z, a-z, 0-9).
     */
    @Test
    public void enhancedAlgorithmGeneratesCorrectCharactersAndLength() {
        service.setAlgorithm("enhanced");
        String p = service.generatePassword(12);
        
        // Verify length
        assertEquals(12, p.length(), "Password length should be 12");
        
        // Verify all characters are alphanumeric (A-Z, a-z, 0-9)
        assertTrue(p.matches("[A-Za-z0-9]+"), 
            "Enhanced algorithm password should contain only A-Z, a-z, and 0-9");
    }
    
    /**
     * Tests that the letters algorithm generates passwords containing only letters (A-Z, a-z).
     */
    @Test
    public void lettersAlgorithmGeneratesLettersOnly() {
        service.setAlgorithm("letters");
        String p = service.generatePassword(8);
        
        // Verify length
        assertEquals(8, p.length(), "Password length should be 8");
        
        // Verify all characters are letters (A-Z, a-z) with no digits
        assertTrue(p.matches("[A-Za-z]+"), 
            "Letters algorithm password should contain only letters (A-Z, a-z)");
        assertFalse(p.matches(".*[0-9].*"), 
            "Letters algorithm password should not contain any digits");
    }
    
    /**
     * Tests that switching between algorithms changes the password generation behavior.
     * Verifies that each algorithm produces output with its characteristic properties.
     */
    @Test
    public void switchingAlgorithmsChangesBehavior() {
        // Test basic algorithm (digits only)
        service.setAlgorithm("basic");
        String p1 = service.generatePassword(10);
        assertEquals(10, p1.length(), "Basic password should have length 10");
        assertTrue(p1.matches("[0-9]+"), 
            "Basic algorithm should produce only digits");
        
        // Test letters algorithm (letters only)
        service.setAlgorithm("letters");
        String p2 = service.generatePassword(10);
        assertEquals(10, p2.length(), "Letters password should have length 10");
        assertTrue(p2.matches("[A-Za-z]+"), 
            "Letters algorithm should produce only letters");
        assertFalse(p2.matches(".*[0-9].*"), 
            "Letters algorithm should not produce any digits");
        
        // Test enhanced algorithm (alphanumeric)
        service.setAlgorithm("enhanced");
        String p3 = service.generatePassword(10);
        assertEquals(10, p3.length(), "Enhanced password should have length 10");
        assertTrue(p3.matches("[A-Za-z0-9]+"), 
            "Enhanced algorithm should produce alphanumeric characters");
        
        // Verify that all three passwords are different (extremely high probability)
        assertNotEquals(p1, p2, "Passwords from different algorithms should differ");
        assertNotEquals(p2, p3, "Passwords from different algorithms should differ");
        assertNotEquals(p1, p3, "Passwords from different algorithms should differ");
    }
}