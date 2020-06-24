import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Pantalla{
	private VBox root;
	private HBox botonera;
	private HBox botoneraAdicionales;
    private Label title;

    
    public Pantalla(){
    	root = new VBox();
    	title = new Label("Seleccione el color de fondo de su preferencia");
    	botonera = new HBox();
    	botoneraAdicionales = new HBox();
    	root.getChildren().addAll(title, botonera,botoneraAdicionales);
    	root.setSpacing(25);
    	root.setAlignment(Pos.CENTER);
    	generateButtons();
    }
   public void generateButtons(){
	   Button blue = new Button("Azul");
	   Button red = new Button("Rojo");
	   Button green = new Button("Verde");
	   botonera.getChildren().addAll(blue, red, green);
	   botonera.setSpacing(25);
	   botonera.setAlignment(Pos.CENTER);
	   
	   blue.setOnAction(e -> backgroundColorChange("blue"));
	   red.setOnAction(e -> backgroundColorChange("red"));
	   green.setOnAction(e -> backgroundColorChange("green")); 
	   
	   Button exit = new Button("Exit");
	   Button funcAdicional = new Button("Funcionalidad Adicional");
	   
	   funcAdicional.setOnAction(e -> {
		   UserScreen.crearScreen();
	   });
	   
	   botoneraAdicionales.getChildren().addAll(funcAdicional, exit);
	   botoneraAdicionales.setSpacing(25);
	   botoneraAdicionales.setAlignment(Pos.CENTER);
	   exit.setOnAction(e -> Platform.exit());
   }
   
   private void backgroundColorChange(String color) {
	   String style = "-fx-background-color: "+color+ ";";
	   title.setTextFill(Color.WHITE);
	   root.setStyle(style);
   }
   
   public VBox getRoot() {
	   return this.root;
   }
   
   
}