package org.howard.edu.lsp.finale.question1;
import java.util.Random;

public class LettersPasswordStrategy implements PasswordGenerationStrategy {
    
    /** Character set containing only uppercase and lowercase letters */
    private static final String LETTERS = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "abcdefghijklmnopqrstuvwxyz";
    
    /** Random number generator */
    private final Random random;
    
    /**
     * Constructs a LettersPasswordStrategy with a new Random instance.
     */
    public LettersPasswordStrategy() {
        this.random = new Random();
    }
    
    /**
     * Generates a password containing only letters.
     * 
     * @param length the desired length of the password
     * @return a randomly generated password containing only letters (A-Z, a-z)
     */
    @Override
    public String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(LETTERS.length());
            password.append(LETTERS.charAt(index));
        }
        
        return password.toString();
    }
}