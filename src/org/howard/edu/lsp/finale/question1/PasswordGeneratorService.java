package org.howard.edu.lsp.finale.question1;
/** 
 * DESIGN PATTERN DOCUMENTATION:
 * 
 * 1. DESIGN PATTERNS USED:
 *    - Singleton Pattern: Ensures only one instance of PasswordGeneratorService exists
 *    - Strategy Pattern: Allows runtime selection of password generation algorithms
 * 
 * 2. WHY THESE PATTERNS ARE APPROPRIATE:
 * 
 *    SINGLETON PATTERN:
 *    - The requirements explicitly state "Only one instance of the service may exist"
 *      and "Provide a single shared access point"
 *    - A Singleton ensures centralized management of the password generation service
 *    - It provides global access through getInstance() while preventing unauthorized
 *      instantiation through a private constructor
 *    - This pattern is ideal for services that coordinate system-wide resources
 * 
 *    STRATEGY PATTERN:
 *    - The requirements state "Support multiple approaches to password generation"
 *      and "Make password-generation behavior swappable"
 *    - Strategy encapsulates each algorithm in separate classes, allowing them to
 *      vary independently from the service that uses them
 *    - The setAlgorithm() method enables runtime selection of different strategies
 *    - New algorithms can be added without modifying existing code (Open/Closed Principle)
 *    - This promotes loose coupling between the service and the generation algorithms
 */
public class PasswordGeneratorService {
    
    /** The single instance of the service (Singleton pattern) */
    private static PasswordGeneratorService instance;
    
    /** The current password generation strategy */
    private PasswordGenerationStrategy currentStrategy;
    
    /**
     * Private constructor to prevent external instantiation (Singleton pattern).
     */
    private PasswordGeneratorService() {
        this.currentStrategy = null;
    }
    
    /**
     * Returns the single instance of PasswordGeneratorService.
     * Creates the instance if it doesn't exist (lazy initialization).
     * 
     * @return the singleton instance of PasswordGeneratorService
     */
    public static PasswordGeneratorService getInstance() {
        if (instance == null) {
            instance = new PasswordGeneratorService();
        }
        return instance;
    }
    
    /**
     * Sets the password generation algorithm to use.
     * 
     * @param name the name of the algorithm ("basic", "enhanced", or "letters")
     * @throws IllegalArgumentException if the algorithm name is not recognized
     */
    public void setAlgorithm(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Algorithm name cannot be null");
        }
        
        switch (name.toLowerCase()) {
            case "basic":
                currentStrategy = new BasicPasswordStrategy();
                break;
            case "enhanced":
                currentStrategy = new EnhancedPasswordStrategy();
                break;
            case "letters":
                currentStrategy = new LettersPasswordStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + name);
        }
    }
    
    /**
     * Generates a password of the specified length using the current algorithm.
     * 
     * @param length the desired length of the password
     * @return a randomly generated password string
     * @throws IllegalStateException if no algorithm has been set
     * @throws IllegalArgumentException if length is not positive
     */
    public String generatePassword(int length) {
        if (currentStrategy == null) {
            throw new IllegalStateException("No algorithm selected. Call setAlgorithm() first.");
        }
        
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be positive");
        }
        
        return currentStrategy.generate(length);
    }
}
