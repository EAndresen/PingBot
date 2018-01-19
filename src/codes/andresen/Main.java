package codes.andresen;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        primaryStage.setTitle("BingBot");
        Scene scene =new Scene(root, 260, 183);
        root.getStylesheets().add(getClass().getResource("Stylesheet.css").toString());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
