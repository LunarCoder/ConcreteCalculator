module com.softengproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.softengproject to javafx.fxml;
    exports com.softengproject;
}
