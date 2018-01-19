package codes.andresen;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

class InfinityRadioButtonListener {
    private int infinityPings;

    void infinityRadioButtonListener(RadioButton infinityRadioButton, TextField countInputTextField) {
        infinityRadioButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(infinityRadioButton.isSelected()){
                countInputTextField.setDisable(true);
                infinityPings = -1;
            }else{
                countInputTextField.setDisable(false);
                infinityPings = 0;
            }
        });
    }

    int getInfinityPings() {
        return infinityPings;
    }
}
