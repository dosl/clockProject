package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


public class HomeController {
    private ClockModel clockModel = ClockModel.getInstance();
    @FXML
    Label currentTimeLabel;
    @FXML
    Button enterButton;
    @FXML
    Button cancelButton;
    @FXML
    ComboBox hourComboBox;
    @FXML
    ComboBox minuteComboBox;
    @FXML
    Button editButton;
    @FXML
    Label timeLabel;
    @FXML
    TableView tableView;

    private ObservableList<String> hourList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
    private ObservableList<String> minuteList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06","07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
            , "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");

    @FXML
    public void initialize() {
        hourComboBox.setItems(hourList);
        minuteComboBox.setItems(minuteList);
        hourComboBox.setValue("Please Select");
        minuteComboBox.setValue("Please Select");
        tableView.setItems(clockModel.getTimeList());
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
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    ClockModel clockModel = (ClockModel) tableView.getSelectionModel().getSelectedItem();
                    hourComboBox.setValue(clockModel.getHour());
                    minuteComboBox.setValue(clockModel.getMinute());
                }
            }
        });
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        checkTime();
    }

    public void checkTime() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    LocalDateTime localDateTime = LocalDateTime.now();
                    if (clockModel.getTimeList().equals(localDateTime.getHour()) && clockModel.getTimeList().equals(localDateTime.getMinute())) {
                        Alert errorAlert = new Alert(Alert.AlertType.WARNING, "Wake up", ButtonType.OK);
                        errorAlert.showAndWait();
                    }
                }
            }
        });
        thread.start();
    }

    @FXML
    public void handleEnterButtonClick(ActionEvent actionEvent) throws IOException {
        if (hourComboBox.getValue() == "Please Select" || minuteComboBox.getValue() == "Please Select") {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING, "Please select all combo box", ButtonType.OK);
            errorAlert.showAndWait();
        } else {
            int hour = Integer.parseInt(hourComboBox.getSelectionModel().getSelectedItem().toString());
            int minute = Integer.parseInt(minuteComboBox.getSelectionModel().getSelectedItem().toString());
//            int minute = minuteComboBox.getValue();
            ClockProperty clockProperty = new ClockProperty(hour, minute);
            clockModel.addTimeList(clockProperty);
            tableView.setItems(clockModel.getTimeList());
//            System.out.println(clockModel.getTimeList().toString());
            tableView.refresh();
            handleCancelButtonClick(actionEvent);
        }
    }

    @FXML
    public void handleCancelButtonClick(ActionEvent actionEvent) {
        hourComboBox.setValue("Please Select");
        minuteComboBox.setValue("Please Select");
    }

    @FXML
    public void handleEditButtonClick(ActionEvent actionEvent) {
        Stage metricStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit.fxml"));
            metricStage.setTitle("EditController");
            metricStage.setScene(new Scene(loader.load(), 600, 400));
            EditController editController = (EditController) loader.getController();
            metricStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
