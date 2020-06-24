import java.util.Arrays;
import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public aspect Observer {
    File file = new File("log.txt");
    Calendar cal = Calendar.getInstance();
    
    @After("execution(void backgroundColorChange(..))")
    public void writeLog(JoinPoint joinpoint){
    	String argumento=Arrays.toString(joinpoint.getArgs()).replace("[","").replace("]","");
    	String line = "Color elegido: "+argumento+" ----- Hora de cambio de color: " + cal.get(Calendar.HOUR_OF_DAY)+":"+ cal.get(Calendar.MINUTE) + "\n";
    	try {
    		Files.write(file.toPath(), line.getBytes(),  StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    	}catch (IOException ex) {
            System.out.println("No hay linea");
        }finally{
        	System.out.println(line);
        }
    }
    
    
    @After("execution(void setUsuario(..))")
    public void writeUser(JoinPoint joinpoint) {
    	String argumento = Arrays.toString(joinpoint.getArgs()).replace("[","").replace("]","");
        String line = "Usuario registrado: "+argumento+ "\n";
        try {
        	Files.write(file.toPath(), line.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        }catch (IOException ex) {
        	System.out.println("No hay usuario");
        }finally {
        	System.out.println(line);
        }
    }

}