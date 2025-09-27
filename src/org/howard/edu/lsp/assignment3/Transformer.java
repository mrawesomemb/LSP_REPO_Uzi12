/**
 * Name: Miles Brown
 */
package org.howard.edu.lsp.assignment3;

/**
 * Generic interface for transforming objects.
 *
 * @param <T> type of object to transform
 */
public interface Transformer<T> {
    /**
     * Transforms an input object into a new output object.
     *
     * @param input object to transform
     * @return transformed object
     * @throws InvalidRowException if transformation fails
     */
    T transform(T input) throws InvalidRowException;
}
