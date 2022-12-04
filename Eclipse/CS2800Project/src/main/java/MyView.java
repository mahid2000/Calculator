import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyView {

    @FXML
    private Button mainButton;

    @FXML
    private Label label;

    @FXML
    void isPressed(ActionEvent event) {
      label.setText("pressed");
    }

}
