import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import javax.swing.filechooser.FileNameExtensionFilter;
// import java.io.File;
// import java.io.IOException;
import java.io.File;

public class UserInterface {
    static double[] dataValues = new double[3];
    static boolean isSubmitted = false;
    
    public static void RocketGui(Runnable callback) {
        JFrame rocketframe = initializeFrame();

        JTextField massInput = addMassInput(rocketframe);
        JTextField dragInput = addDragInput(rocketframe);
        JTextField diameterInput = addDiameterInput(rocketframe);

        // Submit Button
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dataValues[0] = Double.parseDouble(massInput.getText());
                    dataValues[1] = Double.parseDouble(dragInput.getText());
                    dataValues[2] = Double.parseDouble(diameterInput.getText());
                    
                    isSubmitted = true;
                    callback.run();         // Run the callback

                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rocketframe, "Please enter valid numbers in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        rocketframe.add(submit);
        rocketframe.setVisible(true);
        
    }
    
    private static JFrame initializeFrame() {
        JFrame rocketframe = new JFrame("rocket");
        rocketframe.setLayout(new FlowLayout());
        rocketframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rocketframe.setSize(1280, 720);
        return rocketframe;
    }


    private static JTextField addMassInput(JFrame rocketframe) {
        JTextField mass = new JTextField(20);
        JLabel masslabel = new JLabel("Input mass here:");
        rocketframe.add(masslabel);
        rocketframe.add(mass);
        return mass;
    }

    private static JTextField addDragInput(JFrame rocketframe) {
        JTextField dragCoefficient = new JTextField(20);
        JLabel dragLabel = new JLabel("Input coefficient of drag here:");
        rocketframe.add(dragLabel);
        rocketframe.add(dragCoefficient);
        return dragCoefficient;
    }

    private static JTextField addDiameterInput(JFrame rocketframe) {
        JTextField diameter = new JTextField(20);
        JLabel diameterLabel = new JLabel("Input diameter here:");
        rocketframe.add(diameterLabel);
        rocketframe.add(diameter);
        return diameter;
    }
}