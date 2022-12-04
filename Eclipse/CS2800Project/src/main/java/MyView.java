import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MyView {
  

    @FXML
    private Parent root2;
    
    @FXML
    private Button calculateButton;

    @FXML
    private TextField inputBox;

    @FXML
    private Label label;

    @FXML
    private Label message;

    @FXML
    private Button modeGUI;

    @FXML
    private Button modeText;

    @FXML
    private Button reverseButton;

    @FXML
    private MenuItem viewAll;

    @FXML
    private MenuItem viewPrevious;
    
    @FXML
    public void setModeText(ActionEvent event) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("textView.fxml"));
      Stage window = (Stage) ((Node) modeText).getScene().getWindow();
      window.setScene(new Scene(root, 800, 500));
      window.show();
    }
    
    @FXML
    public void setModeGUI(ActionEvent event) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("myView.fxml"));
      Stage window = (Stage) ((Node) modeGUI).getScene().getWindow();
      window.setScene(new Scene(root, 800, 500));
      window.show();
    }

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
    void viewHistory(ActionEvent event) {

    }

    @FXML
    void viewLast(ActionEvent event) {

    }

}
