
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {

    public static ListReferenceBased RocketGui() {
        ListReferenceBased datalist = new ListReferenceBased();

        JFrame rocketframe = initializeFrame();
        
        addMassInput(rocketframe, datalist);
        addDragInput(rocketframe, datalist);
        addDiameterInput(rocketframe, datalist);
        
        rocketframe.setVisible(true);
        return datalist;
        
    }

    private static JFrame initializeFrame() {
        JFrame rocketframe = new JFrame("rocket");
        rocketframe.setLayout(new FlowLayout());
        rocketframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rocketframe.setSize(1280, 720);
        return rocketframe;
    }

    private static void addMassInput(JFrame rocketframe, ListReferenceBased datalist) {
        JTextField mass = new JTextField(20);
        JLabel masslabel = new JLabel("Input mass here:");
        mass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                masslabel.setText("Mass:");
                String mass_string = mass.getText();
                try {
                    Double massvalue = Double.parseDouble(mass_string);
                    datalist.add(0, massvalue);
                    // System.out.print("mass ");
                    System.out.println(datalist.get(0));
                    
                } catch (NumberFormatException ex) {
                    // Handle invalid number format here, e.g. display an error message
                }
            }
        });
        rocketframe.add(masslabel);
        rocketframe.add(mass);
    }

    private static void addDragInput(JFrame rocketframe, ListReferenceBased datalist) {
        // Coefficient of Drag input
        JTextField dragCoefficient = new JTextField(20);
        JLabel dragLabel = new JLabel("Input coefficient of drag here:");
        dragCoefficient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dragLabel.setText("Coefficient of Drag:");
                String drag_string = dragCoefficient.getText();
                try {
                    double dragValue = Double.parseDouble(drag_string);
                    datalist.add(1, dragValue);
                    // System.out.print("coefficent of drag ");
                    System.out.println(datalist.get(1));
                    

                } catch (NumberFormatException ex) {
                    // Handle invalid number format here, e.g. display an error message
                }
            }
        });
        rocketframe.add(dragLabel);
        rocketframe.add(dragCoefficient);
    }

    private static void addDiameterInput(JFrame rocketframe, ListReferenceBased datalist) {
        // Diameter input
        JTextField diameter = new JTextField(20);
        JLabel diameterLabel = new JLabel("Input diameter here:");
        diameter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diameterLabel.setText("Diameter:");
                String diameter_string = diameter.getText();
                try {
                    double diameterValue = Double.parseDouble(diameter_string);
                    datalist.add(2, diameterValue);
                    // System.out.print("diameter ");
                    System.out.println(datalist.get(2));
                    
                } catch (NumberFormatException ex) {
                    // Handle invalid number format here, e.g. display an error message
                }
            }
        });
        rocketframe.add(diameterLabel);
        rocketframe.add(diameter);
    }
}