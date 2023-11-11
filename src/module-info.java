module EffortLoggerV2 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.logging;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
