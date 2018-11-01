package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    ClockModel clockModel = new ClockModel();
    @FXML
    Label currentTimeLabel;
    @FXML
    Label timeLabel1;
    @FXML
    Label timeLabel2;
    @FXML
    Label timeLabel3;
    @FXML
    Label timeLabel4;
    @FXML
    Label timeLabel5;
    //    @FXML Label timeLabel6;
//    @FXML Label timeLabel7;
//    @FXML Label timeLabel8;
//    @FXML Label timeLabel9;
//    @FXML Label timeLabel10;
    @FXML
    Button enterButton;
    @FXML
    Button cancelButton;
    @FXML
    TextField inputHourTextfield;
    @FXML
    TextField inputMinuteTextfield;
    @FXML
    Label resultLabel;
    private int count = 0;

    @FXML
    public void initialize() {
        currentTimeLabel.setText(clockModel.setTime().toString());
        currentTimeLabel.setText(String.valueOf(clockModel.getHour()) + ":" + String.valueOf(clockModel.getMinute()));
        timeLabel1.setVisible(false);
        timeLabel2.setVisible(false);
        timeLabel3.setVisible(false);
        timeLabel4.setVisible(false);
        timeLabel5.setVisible(false);
//        timeLabel6.setVisible(false);
//        timeLabel7.setVisible(false);
//        timeLabel8.setVisible(false);
//        timeLabel9.setVisible(false);

        resultLabel.setText("Input time in integer");
    }

    @FXML
    public void handleEnterButtonClick(ActionEvent actionEvent) {
        System.out.println("enter is click");
        String inputHour = inputHourTextfield.getText();
        String inputMinute = inputMinuteTextfield.getText();
        if (Integer.parseInt(inputHour) > 1 && Integer.parseInt(inputHour) < 24 && Integer.parseInt(inputMinute) > 0 && Integer.parseInt(inputMinute) < 60) {
            count++;
            if (count == 1) {
                timeLabel1.setVisible(true);
                timeLabel1.setText(inputHour + ":" + inputMinute);
                inputHourTextfield.setText("");
                inputMinuteTextfield.setText("");
            }
            if (count == 2) {
                timeLabel2.setVisible(true);
                timeLabel2.setText(inputHour + ":" + inputMinute);
                inputHourTextfield.setText("");
                inputMinuteTextfield.setText("");
            }
            if (count == 3) {
                timeLabel3.setVisible(true);
                timeLabel3.setText(inputHour + ":" + inputMinute);
                inputHourTextfield.setText("");
                inputMinuteTextfield.setText("");
            }
            if (count == 4) {
                timeLabel4.setVisible(true);
                timeLabel4.setText(inputHour + ":" + inputMinute);
                inputHourTextfield.setText("");
                inputMinuteTextfield.setText("");
            }
            if (count == 5) {
                timeLabel5.setVisible(true);
                timeLabel5.setText(inputHour + ":" + inputMinute);
                inputHourTextfield.setText("");
                inputMinuteTextfield.setText("");
            }
//            if (count == 6) {
//                timeLabel6.setVisible(true);
//                timeLabel6.setText(inputHour + ":" + inputMinute);
//                inputHourTextfield.setText("");
//                inputMinuteTextfield.setText("");
//            }
//            if (count == 7) {
//                timeLabel7.setVisible(true);
//                timeLabel7.setText(inputHour + ":" + inputMinute);
//                inputHourTextfield.setText("");
//                inputMinuteTextfield.setText("");
//            }
//            if (count == 8) {
//                timeLabel8.setVisible(true);
//                timeLabel8.setText(inputHour + ":" + inputMinute);
//                inputHourTextfield.setText("");
//                inputMinuteTextfield.setText("");
//            }
//            if (count == 9) {
//                timeLabel9.setVisible(true);
//                timeLabel9.setText(inputHour + ":" + inputMinute);
//                inputHourTextfield.setText("");
//                inputMinuteTextfield.setText("");
//            }
//            if (count == 10) {
//                timeLabel10.setVisible(true);
//                timeLabel10.setText(inputHour + ":" + inputMinute);
//                inputHourTextfield.setText("");
//                inputMinuteTextfield.setText("");
//            }
        } else {
            resultLabel.setText("You didn't follow the rule");
            inputHourTextfield.setText("");
            inputMinuteTextfield.setText("");
        }

    }

    @FXML
    public void handleCancelButtonClick(ActionEvent actionEvent) {
        inputHourTextfield.setText("");
        inputMinuteTextfield.setText("");
    }

}
