module com.ufrpe.br.jjgameson {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens br.ufrpe.jjgameson to javafx.fxml;
    opens br.ufrpe.jjgameson.gui to javafx.fxml;
    exports br.ufrpe.jjgameson;
    exports br.ufrpe.jjgameson.gui;
}