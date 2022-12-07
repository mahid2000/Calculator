package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Driver class for View Assembly  acquired from JavaFX tutorial.
 *
 * @author Dave Cohen
 *
 */
public class Driver extends Application {

  /**
   *Main Method to launch JavaFX  Application. 
   *
   * @param args application class's to be launched
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("myView.fxml"));
    Scene scene = new Scene(root, 800, 500);
    primaryStage.setScene(scene);
    primaryStage.show();    
  }
}
