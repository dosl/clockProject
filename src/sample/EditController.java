package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditController {
    private ClockModel clockModel = ClockModel.getInstance();
    @FXML
    ComboBox hourComboBox;
    @FXML
    ComboBox minuteComboBox;
    @FXML
    TableView tableView;
    @FXML
    Button cancel;
    private ObservableList<Integer> hourList = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);
    private ObservableList<Integer> minuteList = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30
            , 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59);
    @FXML
    public void initialize() {
        hourComboBox.setItems(hourList);
        minuteComboBox.setItems(minuteList);
        hourComboBox.setValue("Please Select");
        minuteComboBox.setValue("Please Select");
        tableView.setItems(clockModel.getTimeList());
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    ClockModel clockModel = (ClockModel) tableView.getSelectionModel().getSelectedItem();
                    hourComboBox.setValue(clockModel.getHour());
                    minuteComboBox.setValue(clockModel.getMinute());
                }
            }
        });
    }
    public void handleEnterButtonClick(ActionEvent actionEvent){
        if (hourComboBox.getValue() == "Please Select" || minuteComboBox.getValue() == "Please Select"){
            Alert errorAlert = new Alert(Alert.AlertType.WARNING, "Please select all combo box", ButtonType.OK);
            errorAlert.showAndWait();
        }else{
//            timeList.remove(tableView.getSelectionModel().getSelectedItem());
        }
    }
    public void handleCancelButtonClick(ActionEvent actionEvent){
        Stage stage = (Stage) cancel.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
