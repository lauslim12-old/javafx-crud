module fxcrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.nicholasdw.view to javafx.fxml;
    exports com.nicholasdw.app;
    exports com.nicholasdw.model;
    exports com.nicholasdw.view;
}