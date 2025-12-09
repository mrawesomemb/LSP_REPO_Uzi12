package org.howard.edu.lsp.finale.question1;
import java.util.Random;

public class BasicPasswordStrategy implements PasswordGenerationStrategy {
    
    /** Character set containing only digits */
    private static final String DIGITS = "0123456789";
    
    /** Random number generator */
    private final Random random;
    
    /**
     * Constructs a BasicPasswordStrategy with a new Random instance.
     */
    public BasicPasswordStrategy() {
        this.random = new Random();
    }
    
    /**
     * Generates a password containing only digits.
     * 
     * @param length the desired length of the password
     * @return a randomly generated password containing only digits (0-9)
     */
    @Override
    public String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(DIGITS.length());
            password.append(DIGITS.charAt(index));
        }
        
        return password.toString();
    }
}