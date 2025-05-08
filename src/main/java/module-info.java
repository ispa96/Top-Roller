module com.ispasoiurobert.fxproject.toproller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires java.desktop;
    requires javafx.media;


    opens com.ispasoiurobert.fxproject.toproller to javafx.fxml;
    exports com.ispasoiurobert.fxproject.toproller;
}