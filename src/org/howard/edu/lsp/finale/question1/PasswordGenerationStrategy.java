package org.howard.edu.lsp.finale.question1;

public interface PasswordGenerationStrategy {
    
    /**
     * Generates a password of the specified length.
     * 
     * @param length the desired length of the password
     * @return a randomly generated password string
     */
    String generate(int length);
}
