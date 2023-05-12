module gre.lab2 {
  requires javafx.controls;
  requires javafx.fxml;

  exports gre.lab2.graph;

  exports gre.lab2.gui;
  opens gre.lab2.gui to javafx.fxml;
  exports gre.lab2.gui.impl;
  opens gre.lab2.gui.impl to javafx.fxml;
  exports gre.lab2.groupeX;
  opens gre.lab2.groupeX to javafx.fxml;
}
