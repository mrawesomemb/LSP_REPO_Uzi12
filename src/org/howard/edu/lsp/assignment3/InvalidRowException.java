/**
 * Name: Miles Brown
 */
package org.howard.edu.lsp.assignment3;

/**
 * Exception thrown when a CSV row is invalid
 * or cannot be transformed into a valid Product.
 */
public class InvalidRowException extends Exception {
    public InvalidRowException(String message) {
        super(message);
    }
}
