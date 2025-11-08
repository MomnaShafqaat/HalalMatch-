module com.example.redkeepithalal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.redkeepithalal to javafx.fxml;
    exports com.example.redkeepithalal;
}