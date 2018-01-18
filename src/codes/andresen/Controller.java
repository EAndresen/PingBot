package codes.andresen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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

//    private Pinger pinger = new Pinger();
    private CalculatePing calculatePing = new CalculatePing();

    private String inputStartIP;
    private int inputEndOfEndIP;
    private int infinityPings;
    private String countInput;

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
            countInput = countInputTextField.getText();

            calculatePing.calculatePing(inputEndOfEndIP,
                                        infinityPings,
                                        inputStartIP,
                                        countInput,
                                        sizeInputTextField.getText());

        });
    }
}
