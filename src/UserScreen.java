import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class UserScreen {
	private Pane root;
	private TextField tf;
	private String nombre;
	private Button guardar;
	
	public UserScreen() {
		root = new Pane();
		tf = new TextField();
		guardar =new Button("Guardar");
		crearScreen();
		
	}
	
	public void crearScreen() {
		VBox contenido = new VBox();
		HBox save = new HBox();
		Label info = new Label("Ingrese su nombre: ");
		save.getChildren().addAll(tf,guardar);
		contenido.getChildren().addAll(info,save);
		root.getChildren().add(contenido);
	}
	
	public void funcionBoton() {
		guardar.setOnMouseClicked(e->{
			nombre=tf.getText();
			tf.clear();
			
		});
		
	}
	
	public Pane getRoot() {
		return root;
	}
	
	public String getNombre() {
		return nombre;
		
	}

}
