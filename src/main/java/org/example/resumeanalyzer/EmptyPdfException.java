package org.example.resumeanalyzer;

public class EmptyPdfException extends RuntimeException {
    public EmptyPdfException(String message) {
        super(message);
    }
}
