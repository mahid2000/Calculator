package calculator;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for javaFx application.
 *
 * @author Mahid
 *
 */
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
  private Button modeGui;

  @FXML
  private Button modeText;

  @FXML
  private Button reverseButton;

  @FXML
  private MenuItem viewAll;

  @FXML
  private MenuItem viewPrevious;

  @FXML
  private RadioButton r1;

  @FXML
  private RadioButton r2;


  /**
   * Event handler that detects when the change view button is pressed and switches the scene to
   * Text.
   *
   * @param event modeText button is pressed
   * @throws IOException if it cannot retrieve the fxml document
   */
  @FXML
  public void setModeText(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("textView.fxml"));
    Stage window = (Stage) ((Node) modeText).getScene().getWindow();
    window.setScene(new Scene(root, 800, 500));
    window.show();
  }

  /**
   * Event Handler that detects when the change view button is pressed and switches the scene to
   * GUI.
   *
   * @param event modeGui is pressed
   * @throws IOException if it cannot retrieve the fxml document
   */
  @FXML
  public void setModeGui(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("myView.fxml"));
    Stage window = (Stage) ((Node) modeGui).getScene().getWindow();
    window.setScene(new Scene(root, 800, 500));
    window.show();
  }

  /**
   * Event handler that detects when the calculate button is pressed.
   *
   * @param event calculateButton is pressed
   */
  @FXML
  void calcPressed(ActionEvent event) {
    double r = label.getRotate();
    label.setRotate(r + 90);
    String msg = inputBox.getText();
    message.setText(msg);
  }


  //
  // @FXML
  // void revsersePress(ActionEvent event) {
  // double r = label.getRotate();
  // label.setRotate(r - 90);
  // String msg = inputBox.getText();
  // message.setText(new StringBuilder(msg).reverse().toString());
  // }
  //



  @FXML
  void isPressed(ActionEvent event) {

  }

  @FXML
  void r2IsPressed(ActionEvent event) {

  }

}
