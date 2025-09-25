/**
 * Name: Miles Brown
 */
package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a product row in the CSV file.
 * Immutable data structure with id, name, and price.
 */
public class Product {
    private final String id;
    private final String name;
    private final BigDecimal price;

    /**
     * Constructs a Product instance.
     *
     * @param id    product ID
     * @param name  product name
     * @param price product price
     */
    public Product(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
}
