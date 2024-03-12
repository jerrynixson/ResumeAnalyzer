module org.example.resumeanalyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires org.apache.pdfbox;

    opens org.example.resumeanalyzer to javafx.fxml;
    exports org.example.resumeanalyzer;
}