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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;


/**
 * Controller class for javaFx application.
 *
 * @author Mahid
 *
 */
public class MyView {

  private CalcModel casio = new CalcModel();
  private boolean isInfix = true;

  @FXML
  private Button answer;

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
  private ToggleButton togglePostFix;

  @FXML
  private Label helper;


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
   * Method to switch between infix and postfix when button is toggled.
   *
   * @param event button pressed
   * @return boolean isInfix
   */
  @FXML
  public boolean isToggled(ActionEvent event) {
    if (isInfix) {
      isInfix = false;
      togglePostFix.setText("Postfix");
      return isInfix;
    }
    isInfix = true;
    togglePostFix.setText("InFix");
    return isInfix;
  }

  /**
   * Event handler that detects when the calculate button is pressed and calls the CalcModel.
   *
   * @param event calculateButton is pressed
   */
  @FXML
  void calcPressed(ActionEvent event) {
    // Get String value from input box
    String msg = inputBox.getText();
    // call calculator to evaluate input
    Float ans = casio.calculate(msg, isInfix);
    // if a not a number float is returned then return error message
    if (Float.isNaN(ans)) {
      message.setText("Invalid Expression Exception!!! ");
      helper.setText(
          "Some Tips:\n"
          + "Remember to put spaces inbetween !!!\n"
          + "Infix has brackets but postfix does not...\n"
          + "Postfix has both operaters before operation\n"
          + "The expression must have 2 floats for every one opperator ");
      return;
    }
    message.setText(msg + " equals ");
    inputBox.setText(ans.toString());
  }


  @FXML
  void prevAns(ActionEvent event) {
    Float ans = casio.prevAnswer();
    inputBox.appendText(ans.toString());
  }

}
