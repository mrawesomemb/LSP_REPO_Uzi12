package org.howard.edu.lsp.finale.question1;
import java.security.SecureRandom;

public class EnhancedPasswordStrategy implements PasswordGenerationStrategy {
    
    /** Character set containing uppercase letters, lowercase letters, and digits */
    private static final String ALLOWED_CHARS = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "abcdefghijklmnopqrstuvwxyz" +
        "0123456789";
    
    /** Secure random number generator */
    private final SecureRandom secureRandom;
    
    /**
     * Constructs an EnhancedPasswordStrategy with a new SecureRandom instance.
     */
    public EnhancedPasswordStrategy() {
        this.secureRandom = new SecureRandom();
    }
    
    /**
     * Generates a password containing uppercase letters, lowercase letters, and digits.
     * 
     * @param length the desired length of the password
     * @return a randomly generated password containing A-Z, a-z, and 0-9
     */
    @Override
    public String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(ALLOWED_CHARS.length());
            password.append(ALLOWED_CHARS.charAt(index));
        }
        
        return password.toString();
    }
}