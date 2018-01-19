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

    private CalculatePing calculatePing = new CalculatePing();
    private InfinityRadioButtonListener infinityRadioButtonListener = new InfinityRadioButtonListener();

    private String inputStartIP;
    private String countInput;
    private String size;
    private int inputEndOfEndIP;
    private int infinityPings;

    @FXML
    private void initialize() {
        infinityRadioButtonListener.infinityRadioButtonListener(infinityRadioButton, countInputTextField);

        button.setOnAction(event -> {
            inputStartIP = ipInputTextField.getText();
            inputEndOfEndIP = Integer.parseInt(ipEndInputTextField.getText());
            countInput = countInputTextField.getText();
            size = sizeInputTextField.getText();
            infinityPings = infinityRadioButtonListener.getInfinityPings();

            calculatePing.calculatePing(inputEndOfEndIP, infinityPings, inputStartIP, countInput, size);
        });
    }
}
