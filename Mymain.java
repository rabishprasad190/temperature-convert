package com.internshala.helllofx;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
    @FXML
    public Label welcomeLebel;
    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField textfield;

    @FXML
    public Button convertbutton;
    public static final String C_TO_F="Celsious to faranite";
    public static final String F_TO_C="faranite to celsious";

    private boolean isC_TO_F=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(C_TO_F);
        choiceBox.getItems().add(F_TO_C);

        choiceBox.setValue(C_TO_F);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if(t1.equals(C_TO_F)){
                isC_TO_F=true;
            }else
                isC_TO_F=false;
        });

        convertbutton.setOnAction(actionEvent ->
        {
            convert();
        });
    }

    private void convert() {
        String input = textfield.getText();
        float entertemp = Float.parseFloat(input);
        float newtemp = 0.0f;
        if (isC_TO_F) {
            newtemp = (entertemp * 9 / 5) + 32;
        } else {
            newtemp = (entertemp - 32) * 5 / 9;
        }
        display(newtemp);
    }
        private void display(float newtemp){
            String unit =isC_TO_F? "F" : "C";
            System.out.println(newtemp + unit);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Result");
            alert.setContentText(newtemp + unit);
            alert.show();
        }

}
