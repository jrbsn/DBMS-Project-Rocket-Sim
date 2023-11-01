import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VariablePasser{

    public static void PyTranslator(double[] dataValues) throws IOException{
        
        
        String mass = String.valueOf(dataValues[0]);
        //System.out.println(mass);
        String drag = String.valueOf(dataValues[1]);
        //System.out.println(drag);
        String diameter = String.valueOf(dataValues[2]);
        //System.out.println(diameter);
// god i hope this fucking works i literally cant think of a better way
        ProcessBuilder Translator = new ProcessBuilder("python", "/home/callisto/Documents/DBMS-Project-Rocket-Sim/PyVariMod.py", mass, drag, diameter);
        Process process = Translator.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
        System.out.println(line);
}   
        int exitCode;
        try{
            exitCode = process.waitFor();
            System.out.println("Python script executed with exit code: " + exitCode);
    
        }
        catch (InterruptedException e){
            e.printStackTrace();
    
        }
    }

}

