package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class HomeController {
    private ClockModel clockModel = ClockModel.getInstance();
    private ArrayList<ClockProperty> clockList = new ArrayList<>();
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
    private ObservableList<String> minuteList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
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
//        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                if (event.getClickCount() == 1) {
//                    ClockModel clockModel = (ClockModel) tableView.getSelectionModel().getSelectedItem();
//                    hourComboBox.setValue(clockModel.getHour());
//                    minuteComboBox.setValue(clockModel.getMinute());
//                }
//            }
//        });
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        checkTime();
    }

    public void checkTime() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ClockModel clockModel = new ClockModel();

//                    System.out.println(clockList.toString() + "list time");
//                        System.out.println(c.getHour());
//                    System.out.println("[" + clockModel.getHour() + " " + clockModel.getMinute() + "]" + "real time");
                    for (int i = 0; i < clockList.size(); i++) {
                        if (clockList.get(i).toString().equals(clockModel.getHour() + " " + clockModel.getMinute()) &&clockModel.getSec()==0) {
                            clockModel.removeTimeList(clockList.get(i));
                            System.out.println("-------------------------------------wake up------------------------------");
                            Platform.runLater(() -> {
                                try {
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cal.fxml"));
                                    Parent parent = (Parent) fxmlLoader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(parent));
                                    stage.setTitle("Let's think");
                                    stage.initStyle(StageStyle.UNDECORATED);
                                    stage.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                    }
                }
            }
        });
        thread.start();
    }

    @FXML
    public void handleEnterButtonClick(ActionEvent actionEvent) {
        if (hourComboBox.getValue() == "Please Select" || minuteComboBox.getValue() == "Please Select") {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING, "Please select all combo box", ButtonType.OK);
            errorAlert.showAndWait();
        } else {
            int hour = Integer.parseInt(hourComboBox.getSelectionModel().getSelectedItem().toString());
            int minute = Integer.parseInt(minuteComboBox.getSelectionModel().getSelectedItem().toString());
            ClockProperty clockProperty = new ClockProperty(hour, minute);
            clockModel.addTimeList(clockProperty);
            clockList.add(clockProperty);
            tableView.setItems(clockModel.getTimeList());
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
    public void handleRemoveButtonClick(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Remove.fxml"));
            stage.setTitle("RemoveController");
            stage.setScene(new Scene(loader.load(), 600, 400));
            RemoveController removeController = (RemoveController) loader.getController();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
