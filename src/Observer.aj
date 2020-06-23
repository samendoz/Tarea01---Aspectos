import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;

public aspect Observer {
    File file = new File("log.txt");
    Calendar cal = Calendar.getInstance();
    pointcut success() : call(void backgroundColorChange() && args(String color));
    after() : success() {
    	
    	//writeFile();
    }
    
    void writeFile(String color){
    	String line = "Color: " + color + "; Hora del cambio: " + cal.get(Calendar.HOUR_OF_DAY)+":"+ cal.get(Calendar.MINUTE) + "\n";
    	try {
    		Files.write(file.toPath(), line.getBytes(),  StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    	}catch (IOException ex) {
            System.out.println("no hay linea");
        }finally{
    	System.out.print(line);
        }
    }
}