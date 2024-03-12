package org.example.resumeanalyzer;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FileExtractor {

    public static String extractTextFromPDF(String filePath) {
        File file = new File(filePath);
        String extractedText = null;
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper textStripper = new PDFTextStripper();
            extractedText = textStripper.getText(document);
            if (extractedText == null || extractedText.trim().isEmpty()) {
                throw new EmptyPdfException("Empty or unreadable PDF");
            }
        } catch (IOException | EmptyPdfException e) {
            ErrorHandler.handleException(e);
        }
        return extractedText;
    }
}

//class FileExtractMain {
//
//    public static void main(String[] args) {
//        String filePath = "C:\\Users\\jerry\\Downloads\\checkNothing.pdf";
//        try {
//            String extractedText = FileExtractor.extractTextFromPDF(filePath);
//            System.out.println("Extracted Text:\n" + extractedText);
//        } catch (IOException e) {
//            System.err.println("Error reading PDF file: " + e.getMessage());
//        }
//    }
//}
//
