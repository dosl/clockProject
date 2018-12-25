package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RemoveController {
    private ClockModel clockModel = ClockModel.getInstance();
    @FXML
    ComboBox hourComboBox;
    @FXML
    ComboBox minuteComboBox;
    @FXML
    TableView tableView;
    @FXML
    Button cancel;
    @FXML
    public void initialize() {
        tableView.setItems(clockModel.getTimeList());
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    ClockModel clockModel = (ClockModel) tableView.getSelectionModel().getSelectedItem();
                }
            }
        });
    }
    @FXML
    public void handleEnterButtonClick(ActionEvent actionEvent){
        if (tableView.getSelectionModel().getSelectedItem()==null){
            Alert errorAlert = new Alert(Alert.AlertType.WARNING, "Please select time", ButtonType.OK);
            errorAlert.showAndWait();
        }else{
            clockModel.removeTimeList(tableView.getSelectionModel().getSelectedItem());
            Alert endAlert = new Alert(Alert.AlertType.WARNING, "Time is remove", ButtonType.OK);
            endAlert.showAndWait();
            handleCancelButtonClick(actionEvent);
        }
    }
    @FXML
    public void handleCancelButtonClick(ActionEvent actionEvent){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
