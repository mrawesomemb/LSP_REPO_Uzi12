/**
 * Name: Miles Brown
 */
package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.*;

/**
 * Main coordinator class for the ETL pipeline.
 * Orchestrates reading, transforming, and writing products.
 */
public class ETLPipeline {
    public static void main(String[] args) {
        PipelineStats stats = new PipelineStats();
        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        ProductTransformer transformer = new ProductTransformer();

        try {
            List<Product> inputProducts = reader.read(PipelineConfig.INPUT_FILE, stats);
            List<Product> outputProducts = new ArrayList<>();

            for (Product p : inputProducts) {
                try {
                    Product transformed = transformer.transform(p);
                    outputProducts.add(transformed);
                    stats.rowsTransformed++;
                } catch (InvalidRowException e) {
                    stats.rowsSkipped++;
                }
            }

            writer.write(PipelineConfig.OUTPUT_FILE, outputProducts);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        stats.printSummary();
    }
}
