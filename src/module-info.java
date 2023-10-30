module effortLoggerV2 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.logging;
	
	opens application to javafx.graphics, javafx.fxml;
}

// jake's module-info