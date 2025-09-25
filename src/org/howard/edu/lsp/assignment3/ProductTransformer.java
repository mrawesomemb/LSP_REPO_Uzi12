/**
 * Name: Miles Brown
 */
package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Transformer implementation for Product objects.
 * Ensures valid fields and rounds prices to 2 decimals.
 */
public class ProductTransformer implements Transformer<Product> {
    @Override
    public Product transform(Product input) throws InvalidRowException {
        if (input.getId().isEmpty() || input.getName().isEmpty() || input.getPrice() == null) {
            throw new InvalidRowException("Invalid row: missing data");
        }
        BigDecimal roundedPrice = input.getPrice().setScale(2, RoundingMode.HALF_UP);
        return new Product(input.getId(), input.getName(), roundedPrice);
    }
}
