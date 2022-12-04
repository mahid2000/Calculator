import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class MyView {

    @FXML
    private Button calculateButton;

    @FXML
    private TextField inputBox;

    @FXML
    private Label label;

    @FXML
    private Label message;

    @FXML
    private MenuItem modeGUI;

    @FXML
    private MenuItem modeText;

    @FXML
    private Button reverseButton;

    @FXML
    private MenuItem viewAll;

    @FXML
    private MenuItem viewPrevious;

    @FXML
    void calcPressed(ActionEvent event) {
      double r = label.getRotate();
      label.setRotate(r + 90);
      String msg = inputBox.getText();
      message.setText(msg);
      

    }

    @FXML
    void historyView(ActionEvent event) {

    }

    @FXML
    void openGUI(ActionEvent event) {

    }

    @FXML
    void openText(ActionEvent event) {

    }

    @FXML
    void previousView(ActionEvent event) {

    }

    @FXML
    void revsersePress(ActionEvent event) {
      double r = label.getRotate();
      label.setRotate(r - 90);
      String msg = inputBox.getText();
      message.setText(new StringBuilder(msg).reverse().toString());
    }

    @FXML
    void setModeGUI(ActionEvent event) {

    }

    @FXML
    void setModeText(ActionEvent event) {

    }

    @FXML
    void viewHistory(ActionEvent event) {

    }

    @FXML
    void viewLast(ActionEvent event) {

    }

}
