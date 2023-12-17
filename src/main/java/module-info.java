module com.ufrpe.br.jjgameson {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.ufrpe.br.jjgameson to javafx.fxml;
    exports com.ufrpe.br.jjgameson;
}