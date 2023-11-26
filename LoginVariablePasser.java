import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginVariablePasser {

    public static void loginTranslator(String username, String password) throws IOException {
        ProcessBuilder loginProcessBuilder = new ProcessBuilder("python", "LoginScript.py", username, password);
        Process process = loginProcessBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode;
        try {
            exitCode = process.waitFor();
            System.out.println("Login Python script executed with exit code: " + exitCode);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}