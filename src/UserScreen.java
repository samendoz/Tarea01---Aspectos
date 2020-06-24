import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserScreen {
	private static String nombre;
	
	public static void crearScreen() {
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setTitle("Funcionalidad adicional");
		
		TextField tf = new TextField();
		Button guardar = new Button("Guardar");
		
		guardar.setOnAction(e -> {
			nombre = tf.getText();
			tf.clear();
			popup.close();
		});
		
		VBox contenido = new VBox();
		HBox save = new HBox();
		Label info = new Label("Ingrese su nombre: ");
		save.getChildren().addAll(tf,guardar);
		contenido.getChildren().addAll(info,save);
		contenido.setAlignment(Pos.CENTER);
		
		Scene escenaPopup = new Scene(contenido, 300, 250);
		popup.setScene(escenaPopup);
		popup.alwaysOnTopProperty();
		popup.showAndWait();
	}
	
	public static String getNombre() {
		return nombre;
		
	}

}
