import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    static double[] dataValues = new double[3];
    static String rocketName;
    static boolean isSubmitted = false;
    
    public static void RocketGui(Runnable callback) {
        JFrame rocketFrame = initializeFrame();

        JTextField nameInput = addNameInput(rocketFrame);
        JTextField massInput = addMassInput(rocketFrame);
        JTextField thrustInput = addthrustInput(rocketFrame);
        JTextField diameterInput = addDiameterInput(rocketFrame);

        // Submit Button
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rocketName = nameInput.getText();
                    dataValues[0] = Double.parseDouble(massInput.getText());
                    dataValues[1] = Double.parseDouble(thrustInput.getText());
                    dataValues[2] = Double.parseDouble(diameterInput.getText());
                    
                    isSubmitted = true;
                    callback.run(); // Run the callback

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rocketFrame, "Please enter valid numbers in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        rocketFrame.add(submit);
        rocketFrame.setVisible(true);
        
    }
    
    private static JFrame initializeFrame() {
        JFrame rocketFrame = new JFrame("Rocket Interface");
        rocketFrame.setLayout(new FlowLayout());
        rocketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rocketFrame.setSize(800, 800);
        return rocketFrame;
    }

    private static JTextField addNameInput(JFrame rocketFrame) {
        JTextField name = new JTextField(20);
        JLabel nameLabel = new JLabel("Input rocket name here:");
        rocketFrame.add(nameLabel);
        rocketFrame.add(name);
        return name;
    }

    private static JTextField addMassInput(JFrame rocketFrame) {
        JTextField mass = new JTextField(20);
        JLabel massLabel = new JLabel("Input mass here:");
        rocketFrame.add(massLabel);
        rocketFrame.add(mass);
        return mass;
    }

    private static JTextField addthrustInput(JFrame rocketFrame) {
        JTextField thrustCoefficient = new JTextField(20);
        JLabel thrustLabel = new JLabel("Input thrust coefficient here:"); // Updated the label
        rocketFrame.add(thrustLabel);
        rocketFrame.add(thrustCoefficient);
        return thrustCoefficient;
    }

    private static JTextField addDiameterInput(JFrame rocketFrame) {
        JTextField diameter = new JTextField(20);
        JLabel diameterLabel = new JLabel("Input diameter here:");
        rocketFrame.add(diameterLabel);
        rocketFrame.add(diameter);
        return diameter;
    }
}