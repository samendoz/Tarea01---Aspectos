import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

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
	
	public void guardarArchivo(String nombre) {
		try {
			Calendar calendario = Calendar.getInstance();
			File archivo = new File("Registro.txt");
			FileWriter escribir = new FileWriter(archivo, true);
			escribir.write(nombre);
			escribir.write("Color");//Aqui va el color
			escribir.write(calendario.get(Calendar.HOUR_OF_DAY));
			escribir.write("\n");			
			
			escribir.close();
		}catch (Exception e) {
			System.out.println("Error al escribir");
		}
	}
	
	public Pane getRoot() {
		return root;
	}
	
	public String getNombre() {
		return nombre;
		
	}

}
