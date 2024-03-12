package org.example.resumeanalyzer;

import java.sql.SQLException;

public class ErrorHandler {
    public static void handleException(Exception e) {
        if (e instanceof EmptyPdfException) {
            handleEmptyPdfException((EmptyPdfException) e);
        } else if (e instanceof PdfAccessException) {
            handlePdfAccessException((PdfAccessException) e);
        } else if (e instanceof SQLException) {
            handleSQLException((SQLException) e);
        } else {
            // Handle other types of exceptions here
            // For example, log the exception or display an error message
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void handleEmptyPdfException(EmptyPdfException e) {
        // Handle EmptyPdfException
        // For example, display a user-friendly error message
        System.err.println("Empty or unreadable PDF: " + e.getMessage());
    }
    private static void handlePdfAccessException(PdfAccessException e) {
        // Handle EmptyPdfException
        // For example, display a user-friendly error message
        System.err.println("Error reading PDF file" + e.getMessage());
    }

    public static void handleSQLException(SQLException e) {
        // You can implement your error handling logic here
        // For example, log the error or display an error message
        System.err.println("SQLException occurred: " + e.getMessage());
    }
}
