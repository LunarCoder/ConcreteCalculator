module com.softengproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.softengproject to javafx.fxml, ALL_UNNAMED;

    exports com.softengproject;
}
