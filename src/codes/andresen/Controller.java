package codes.andresen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {

    @FXML
    Button button = new Button();

    @FXML
    TextField ipInputTextField = new TextField();

    @FXML
    TextField countInputTextField = new TextField();

    @FXML
    TextField sizeInputTextField = new TextField();

    @FXML
    TextField ipEndInputTextField = new TextField();

    @FXML
    RadioButton infinityRadioButton = new RadioButton();

    private Pinger pinger = new Pinger();

    private String inputStartIP;
    private int inputEndOfEndIP;
    private int numberOfPings;
    private int infinityPings;

    @FXML
    private void initialize() {
        infinityRadioButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(infinityRadioButton.isSelected()){
                countInputTextField.setDisable(true);
                infinityPings = -1;
            }else{
                countInputTextField.setDisable(false);
                infinityPings = 0;
            }
        });

        button.setOnAction(event -> {
            inputStartIP = ipInputTextField.getText();
            inputEndOfEndIP = Integer.parseInt(ipEndInputTextField.getText());

            int pos = inputStartIP.lastIndexOf(".");
            int endOfFirstIP = Integer.parseInt(inputStartIP.substring(pos+1, inputStartIP.length()));
            String beginningOfFirstIP = inputStartIP.substring(0, pos);
            numberOfPings = inputEndOfEndIP - endOfFirstIP +1;

            for(int i = 0; i < numberOfPings; i++){
                String ip = beginningOfFirstIP + "." + Integer.toString(endOfFirstIP);
                String count;
                String size = sizeInputTextField.getText();

                if(infinityPings == -1){
                    count = "-1";
                }else {
                    count = countInputTextField.getText();
                }

                try {
                    pinger.ping(ip, count, size);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                endOfFirstIP++;
            }
        });
    }
}
