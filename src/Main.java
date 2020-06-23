import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		Scene sc= new Scene(new Pantalla().getRoot(), 400,200);
	    primaryStage.setScene(sc);
        primaryStage.setTitle("Tarea01 - Observer");
	    primaryStage.show();
	}
	public static void main(String[] args) {
        launch(args);
    }
}
