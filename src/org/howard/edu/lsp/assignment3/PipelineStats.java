/**
 * Name: Miles Brown
 */
package org.howard.edu.lsp.assignment3;

/**
 * Tracks statistics for the ETL pipeline,
 * such as rows read, transformed, and skipped.
 */
public class PipelineStats {
    public int rowsRead = 0;
    public int rowsTransformed = 0;
    public int rowsSkipped = 0;

    /**
     * Prints a summary of pipeline execution.
     */
    public void printSummary() {
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
    }
}
