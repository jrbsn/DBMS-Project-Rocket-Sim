import java.io.IOException;

public class VariablePasser{

    public static void PyTranslator() throws IOException{
        
      ListReferenceBased datalist = UserInterface.RocketGui();
        
        String mass = String.valueOf(datalist.get(0));
        String drag = String.valueOf(datalist.get(1));
        String diameter = String.valueOf(datalist.get(2));
// god i hope this fucking works i literally cant think of a better way
        ProcessBuilder Translator = new ProcessBuilder("python", "PyVariMod.py", mass, drag, diameter);
        Process process = Translator.start();
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

