/**
 * Name: Miles Brown
 */
package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.*;

/**
 * Writes products to a CSV file.
 */
public class CSVWriter {
    /**
     * Writes a list of products to a CSV file.
     *
     * @param filePath path to output CSV file
     * @param products list of products to write
     * @throws IOException if writing fails
     */
    public void write(String filePath, List<Product> products) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product p : products) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getPrice());
                writer.newLine();
            }
        }
    }
}
