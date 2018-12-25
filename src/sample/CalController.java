package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;

import java.util.Random;

public class CalController {
    @FXML
    Label position1, position2;
    @FXML
    Label operator;
    @FXML
    TextField answer;
    @FXML
    Button enterButton;

    String[] operatorList = {"+", "-"};
    String[] numberList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    Random random = new Random();
    private int trueAnswer;
    private boolean isFalse = true;


    @FXML
    public void initialize() throws IOException {
        int p1 = random.nextInt(10);
        int p2 = random.nextInt(10);
        int op = random.nextInt(2);
        position1.setText(numberList[p1]);
        position2.setText(numberList[p2]);
        operator.setText(operatorList[op]);
        playSound();
    }

    public int findAnswer() {
        if (operator.getText().equals("+")) {
            trueAnswer = Integer.parseInt(position1.getText()) + Integer.parseInt(position2.getText());
        }
        if (operator.getText().equals("-")) {
            trueAnswer = Integer.parseInt(position1.getText()) - Integer.parseInt(position2.getText());
        }
        return trueAnswer;
    }

    public void playSound() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isFalse) {
                    try {
                        File file = new File("Wake-up-sounds.wav");
                        InputStream in = new FileInputStream(file);
                        AudioStream as = new AudioStream(in);
                        AudioPlayer.player.start(as);
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
    }

    @FXML
    public void handleEnterButtonClick(ActionEvent actionEvent) {
        if (Integer.parseInt(answer.getText()) == (findAnswer())) {
//            AudioPlayer.player.stop(as);
            isFalse = false;
            Alert correctAlert = new Alert(Alert.AlertType.INFORMATION, "Correct", ButtonType.OK);
            correctAlert.showAndWait();
            Stage stage = (Stage) enterButton.getScene().getWindow();
            stage.close();

        } else {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK);
            errorAlert.showAndWait();
        }
    }
}
