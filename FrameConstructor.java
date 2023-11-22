import java.io.IOException;

public class FrameConstructor {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            UserInterface.RocketGui(() -> {
                if (areValuesFilled(UserInterface.dataValues)) {
                    try {
                        VariablePasser.PyTranslator(UserInterface.dataValues);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
                else {
                    System.out.println("All values are not filled. Cannot execute VariablePasser.");
                }
            });
        });
    }

    public static boolean areValuesFilled(double[] dataValues) {
        for (double value : dataValues) {
            if (value == 0) {  // Assuming 0 means it's not filled; adjust this if 0 is a valid value
                return false;
            }
        }
        return true;
    }
}