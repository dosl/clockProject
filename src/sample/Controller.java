package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
    @FXML
    Line position1_1;
    @FXML
    Line position1_2;
    @FXML
    Line position1_3;
    @FXML
    Line position1_4;
    @FXML
    Line position1_5;
    @FXML
    Line position1_6;
    @FXML
    Line position1_7;
    @FXML
    Line position2_1;
    @FXML
    Line position2_2;
    @FXML
    Line position2_3;
    @FXML
    Line position2_4;
    @FXML
    Line position2_5;
    @FXML
    Line position2_6;
    @FXML
    Line position2_7;
    @FXML
    Line position3_1;
    @FXML
    Line position3_2;
    @FXML
    Line position3_3;
    @FXML
    Line position3_4;
    @FXML
    Line position3_5;
    @FXML
    Line position3_6;
    @FXML
    Line position3_7;
    @FXML
    Line position4_1;
    @FXML
    Line position4_2;
    @FXML
    Line position4_3;
    @FXML
    Line position4_4;
    @FXML
    Line position4_5;
    @FXML
    Line position4_6;
    @FXML
    Line position4_7;
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
    @FXML
    Button editButton;
    @FXML
    Label timeLabel;

    private int count = 0;

    @FXML
    public void initialize() {
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Timeline timeline = new Timeline((
                new KeyFrame(
                        Duration.millis(500), event -> {
                    final long diff = System.currentTimeMillis();
                    if (diff < 0) {
                        timeLabel.setText(timeFormat.format(0));
                    } else {
                        timeLabel.setText(timeFormat.format(diff));
                    }
                }
                )
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
//        currentTimeLabel.setText(clockModel.setTime().toString());
        currentTimeLabel.setText(String.valueOf(clockModel.getHour()) + ":" + String.valueOf(clockModel.getMinute()));
        timeLabel1.setVisible(false);
        timeLabel2.setVisible(false);
        timeLabel3.setVisible(false);
        timeLabel4.setVisible(false);
        timeLabel5.setVisible(false);
        int h1 = clockModel.getHour() / 10;
        //int h2 = Math.floorMod(clockModel.getHour(), 10);
        int h2 = clockModel.getHour() % 10;
        int m1 = clockModel.getMinute() / 10;
        int m2 = clockModel.getMinute() % 10;
        System.out.println(h1);
        System.out.println(h2);
        if (h1 == 0) {
            position1_1.setVisible(true);
            position1_2.setVisible(true);
            position1_3.setVisible(true);
            position1_4.setVisible(false);
            position1_5.setVisible(true);
            position1_6.setVisible(true);
            position1_7.setVisible(true);
        }
        if (h1 == 1) {
            position1_1.setVisible(true);
            position1_2.setVisible(false);
            position1_3.setVisible(false);
            position1_4.setVisible(false);
            position1_5.setVisible(true);
            position1_6.setVisible(false);
            position1_7.setVisible(false);
        }
        if (h1 == 2) {
            position1_1.setVisible(false);
            position1_2.setVisible(true);
            position1_3.setVisible(true);
            position1_4.setVisible(true);
            position1_5.setVisible(true);
            position1_6.setVisible(true);
            position1_7.setVisible(false);
        }
        if (h1 == 3) {
            position1_1.setVisible(false);
            position1_2.setVisible(true);
            position1_3.setVisible(true);
            position1_4.setVisible(true);
            position1_5.setVisible(false);
            position1_6.setVisible(true);
            position1_7.setVisible(true);
        }
        if (h1 == 4) {
            position1_1.setVisible(true);
            position1_2.setVisible(false);
            position1_3.setVisible(true);
            position1_4.setVisible(true);
            position1_5.setVisible(false);
            position1_6.setVisible(false);
            position1_7.setVisible(true);
        }
        if (h1 == 5) {
            position1_1.setVisible(true);
            position1_2.setVisible(true);
            position1_3.setVisible(false);
            position1_4.setVisible(true);
            position1_5.setVisible(false);
            position1_6.setVisible(true);
            position1_7.setVisible(true);
        }
        if (h1 == 6) {
            position1_1.setVisible(true);
            position1_2.setVisible(true);
            position1_3.setVisible(false);
            position1_4.setVisible(true);
            position1_5.setVisible(true);
            position1_6.setVisible(true);
            position1_7.setVisible(true);
        }
        if (h1 == 7) {
            position1_1.setVisible(false);
            position1_2.setVisible(true);
            position1_3.setVisible(true);
            position1_4.setVisible(false);
            position1_5.setVisible(false);
            position1_6.setVisible(false);
            position1_7.setVisible(true);
        }
        if (h1 == 8) {
            position1_1.setVisible(true);
            position1_2.setVisible(true);
            position1_3.setVisible(true);
            position1_4.setVisible(true);
            position1_5.setVisible(true);
            position1_6.setVisible(true);
            position1_7.setVisible(true);
        }
        if (h1 == 9) {
            position1_1.setVisible(true);
            position1_2.setVisible(true);
            position1_3.setVisible(true);
            position1_4.setVisible(true);
            position1_5.setVisible(false);
            position1_6.setVisible(true);
            position1_7.setVisible(true);
        }
        if (h2 == 0) {
            position2_1.setVisible(true);
            position2_2.setVisible(true);
            position2_3.setVisible(true);
            position2_4.setVisible(false);
            position2_5.setVisible(true);
            position2_6.setVisible(true);
            position2_7.setVisible(true);
        }
        if (h2 == 1) {
            position2_1.setVisible(true);
            position2_2.setVisible(false);
            position2_3.setVisible(false);
            position2_4.setVisible(false);
            position2_5.setVisible(true);
            position2_6.setVisible(false);
            position2_7.setVisible(false);
        }
        if (h2 == 2) {
            position2_1.setVisible(false);
            position2_2.setVisible(true);
            position2_3.setVisible(true);
            position2_4.setVisible(true);
            position2_5.setVisible(true);
            position2_6.setVisible(true);
            position2_7.setVisible(false);
        }
        if (h2 == 3) {
            position2_1.setVisible(false);
            position2_2.setVisible(true);
            position2_3.setVisible(true);
            position2_4.setVisible(true);
            position2_5.setVisible(false);
            position2_6.setVisible(true);
            position2_7.setVisible(true);
        }
        if (h2 == 4) {
            position2_1.setVisible(true);
            position2_2.setVisible(false);
            position2_3.setVisible(true);
            position2_4.setVisible(true);
            position2_5.setVisible(false);
            position2_6.setVisible(false);
            position2_7.setVisible(true);
        }
        if (h2 == 5) {
            position2_1.setVisible(true);
            position2_2.setVisible(true);
            position2_3.setVisible(false);
            position2_4.setVisible(true);
            position2_5.setVisible(false);
            position2_6.setVisible(true);
            position2_7.setVisible(true);
        }
        if (h2 == 6) {
            position2_1.setVisible(true);
            position2_2.setVisible(true);
            position2_3.setVisible(false);
            position2_4.setVisible(true);
            position2_5.setVisible(true);
            position2_6.setVisible(true);
            position2_7.setVisible(true);
        }
        if (h2 == 7) {
            position2_1.setVisible(false);
            position2_2.setVisible(true);
            position2_3.setVisible(true);
            position2_4.setVisible(false);
            position2_5.setVisible(false);
            position2_6.setVisible(false);
            position2_7.setVisible(true);
        }
        if (h2 == 8) {
            position2_1.setVisible(true);
            position2_2.setVisible(true);
            position2_3.setVisible(true);
            position2_4.setVisible(true);
            position2_5.setVisible(true);
            position2_6.setVisible(true);
            position2_7.setVisible(true);
        }
        if (h2 == 9) {
            position2_1.setVisible(true);
            position2_2.setVisible(true);
            position2_3.setVisible(true);
            position2_4.setVisible(true);
            position2_5.setVisible(false);
            position2_6.setVisible(true);
            position2_7.setVisible(true);
        }
        if (m1 == 0) {
            position3_1.setVisible(true);
            position3_2.setVisible(true);
            position3_3.setVisible(true);
            position3_4.setVisible(false);
            position3_5.setVisible(true);
            position3_6.setVisible(true);
            position3_7.setVisible(true);
        }
        if (m1 == 1) {
            position3_1.setVisible(true);
            position3_2.setVisible(false);
            position3_3.setVisible(false);
            position3_4.setVisible(false);
            position3_5.setVisible(true);
            position3_6.setVisible(false);
            position3_7.setVisible(false);
        }
        if (m1 == 2) {
            position3_1.setVisible(false);
            position3_2.setVisible(true);
            position3_3.setVisible(true);
            position3_4.setVisible(true);
            position3_5.setVisible(true);
            position3_6.setVisible(true);
            position3_7.setVisible(false);
        }
        if (m1 == 3) {
            position3_1.setVisible(false);
            position3_2.setVisible(true);
            position3_3.setVisible(true);
            position3_4.setVisible(true);
            position3_5.setVisible(false);
            position3_6.setVisible(true);
            position3_7.setVisible(true);
        }
        if (m1 == 4) {
            position3_1.setVisible(true);
            position3_2.setVisible(false);
            position3_3.setVisible(true);
            position3_4.setVisible(true);
            position3_5.setVisible(false);
            position3_6.setVisible(false);
            position3_7.setVisible(true);
        }
        if (m1 == 5) {
            position3_1.setVisible(true);
            position3_2.setVisible(true);
            position3_3.setVisible(false);
            position3_4.setVisible(true);
            position3_5.setVisible(false);
            position3_6.setVisible(true);
            position3_7.setVisible(true);
        }
        if (m1 == 6) {
            position3_1.setVisible(true);
            position3_2.setVisible(true);
            position3_3.setVisible(false);
            position3_4.setVisible(true);
            position3_5.setVisible(true);
            position3_6.setVisible(true);
            position3_7.setVisible(true);
        }
        if (m1 == 7) {
            position3_1.setVisible(false);
            position3_2.setVisible(true);
            position3_3.setVisible(true);
            position3_4.setVisible(false);
            position3_5.setVisible(false);
            position3_6.setVisible(false);
            position3_7.setVisible(true);
        }
        if (m1 == 8) {
            position3_1.setVisible(true);
            position3_2.setVisible(true);
            position3_3.setVisible(true);
            position3_4.setVisible(true);
            position3_5.setVisible(true);
            position3_6.setVisible(true);
            position3_7.setVisible(true);
        }
        if (m1 == 9) {
            position3_1.setVisible(true);
            position3_2.setVisible(true);
            position3_3.setVisible(true);
            position3_4.setVisible(true);
            position3_5.setVisible(false);
            position3_6.setVisible(true);
            position3_7.setVisible(true);
        }
        if (m2 == 0) {
            position4_1.setVisible(true);
            position4_2.setVisible(true);
            position4_3.setVisible(true);
            position4_4.setVisible(false);
            position4_5.setVisible(true);
            position4_6.setVisible(true);
            position4_7.setVisible(true);
        }
        if (m2 == 1) {
            position4_1.setVisible(true);
            position4_2.setVisible(false);
            position4_3.setVisible(false);
            position4_4.setVisible(false);
            position4_5.setVisible(true);
            position4_6.setVisible(false);
            position4_7.setVisible(false);
        }
        if (m2 == 2) {
            position4_1.setVisible(false);
            position4_2.setVisible(true);
            position4_3.setVisible(true);
            position4_4.setVisible(true);
            position4_5.setVisible(true);
            position4_6.setVisible(true);
            position4_7.setVisible(false);
        }
        if (m2 == 3) {
            position4_1.setVisible(false);
            position4_2.setVisible(true);
            position4_3.setVisible(true);
            position4_4.setVisible(true);
            position4_5.setVisible(false);
            position4_6.setVisible(true);
            position4_7.setVisible(true);
        }
        if (m2 == 4) {
            position4_1.setVisible(true);
            position4_2.setVisible(false);
            position4_3.setVisible(true);
            position4_4.setVisible(true);
            position4_5.setVisible(false);
            position4_6.setVisible(false);
            position4_7.setVisible(true);
        }
        if (m2 == 5) {
            position4_1.setVisible(true);
            position4_2.setVisible(true);
            position4_3.setVisible(false);
            position4_4.setVisible(true);
            position4_5.setVisible(false);
            position4_6.setVisible(true);
            position4_7.setVisible(true);
        }
        if (m2 == 6) {
            position4_1.setVisible(true);
            position4_2.setVisible(true);
            position4_3.setVisible(false);
            position4_4.setVisible(true);
            position4_5.setVisible(true);
            position4_6.setVisible(true);
            position4_7.setVisible(true);
        }
        if (m2 == 7) {
            position4_1.setVisible(false);
            position4_2.setVisible(true);
            position4_3.setVisible(true);
            position4_4.setVisible(false);
            position4_5.setVisible(false);
            position4_6.setVisible(false);
            position4_7.setVisible(true);
        }
        if (m2 == 8) {
            position4_1.setVisible(true);
            position4_2.setVisible(true);
            position4_3.setVisible(true);
            position4_4.setVisible(true);
            position4_5.setVisible(true);
            position4_6.setVisible(true);
            position4_7.setVisible(true);
        }
        if (m2 == 9) {
            position4_1.setVisible(true);
            position4_2.setVisible(true);
            position4_3.setVisible(true);
            position4_4.setVisible(true);
            position4_5.setVisible(false);
            position4_6.setVisible(true);
            position4_7.setVisible(true);
        }
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
