/**
 * Name: Miles Brown
 */
package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Reads products from a CSV file.
 */
public class CSVReader {
    /**
     * Reads product rows from a CSV file.
     *
     * @param filePath path to CSV file
     * @param stats    pipeline statistics object
     * @return list of Products
     * @throws IOException if the file cannot be read
     */
    public List<Product> read(String filePath, PipelineStats stats) throws IOException {
        List<Product> products = new ArrayList<>();
        File inputFile = new File(filePath);

        System.out.println("Looking for input file at: " + inputFile.getAbsolutePath());
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Input file '" + filePath + "' not found");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stats.rowsRead++;
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    stats.rowsSkipped++;
                    continue;
                }
                try {
                    BigDecimal price = new BigDecimal(parts[2]);
                    products.add(new Product(parts[0], parts[1], price));
                } catch (NumberFormatException e) {
                    stats.rowsSkipped++;
                }
            }
        }
        return products;
    }
}
