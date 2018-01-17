package codes.andresen;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

class Pinger {
    private Runtime r;
    private Process p;
    private CreatePingString createPingString = new CreatePingString();

    void ping(String ipInput, String countInput, String sizeInput) throws IOException {
      TextArea textArea = new TextArea();
      createPingWindow(textArea);

      String pingCmd = createPingString.createPingLine(countInput, sizeInput, ipInput);

      Thread thread = createPingThread(pingCmd, textArea);
      thread.start();
    }

    private Thread createPingThread(String pingCmd, TextArea textArea) {
        return new Thread(() -> {
            try {
                r = Runtime.getRuntime();
                p = r.exec(pingCmd);

                BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    final String outputLine = inputLine;
                    Platform.runLater(() -> textArea.appendText(outputLine + "\n"));
                }
                in.close();
            } catch (IOException event) {
                System.out.println(event);
            }
        });
    }

    private void killRuntimeProcess() {
        p.destroy();
    }

    private void createPingWindow(TextArea textArea) {
        VBox vBox = new VBox(textArea);
        textArea.setPrefHeight(350);
        textArea.setPrefWidth(350);
        Stage stage = new Stage();
        Scene scene = new Scene(vBox, 350, 350);
        scene.getStylesheets().add(getClass().getResource("Stylesheet.css").toString());
        stage.setScene(scene);
        stage.setOnHidden(e -> killRuntimeProcess());
        stage.show();
    }
}
