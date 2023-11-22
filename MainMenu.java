import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    //public 
    public static void main(String[] args) {
        // Create and set up the window
        JFrame frame = new JFrame("MyRocket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout()); // Set layout

        // Screen text
        JLabel centerText = new JLabel("Welcome to MyRocket!", SwingConstants.CENTER);
        centerText.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(centerText, BorderLayout.NORTH); // Add to the top

        // Load and display image
        ImageIcon imageIcon = new ImageIcon(MainMenu.class.getResource("/resources/space.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        frame.add(imageLabel, BorderLayout.CENTER); // Add image to the center
        
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the "Account" menu
        JMenu accountMenu = new JMenu("Account");
        menuBar.add(accountMenu);
        
        JMenu rocketMenu = new JMenu("Rocket");
        menuBar.add(rocketMenu);

        // Add menu items
        JMenuItem menuItemLogin = new JMenuItem("Login");
        JMenuItem menuItemLogout = new JMenuItem("Logout");
        JMenuItem menuItemRegister = new JMenuItem("Register");
        JMenuItem menuItemExit = new JMenuItem("Exit");

        JMenuItem createRocket = new JMenuItem("Create Rocket");
        JMenuItem editRocket = new JMenuItem("Edit Rocket");
        JMenuItem compareRocket = new JMenuItem("Compare Rocket");


        // Adding menu items to the account menu
        accountMenu.add(menuItemLogin);
        accountMenu.add(menuItemLogout);
        accountMenu.add(menuItemRegister);
        accountMenu.addSeparator(); // Adds a separator line
        accountMenu.add(menuItemExit);

        rocketMenu.add(createRocket);
        rocketMenu.add(editRocket);
        rocketMenu.add(compareRocket);

        // Adding action listeners to the menu items
        menuItemExit.addActionListener(e -> System.exit(0));
        menuItemLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame loginFrame = new JFrame("Login");
                loginFrame.setSize(300, 150); // Adjust size as needed
                loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loginFrame.setLayout(new GridLayout(3, 2, 5, 5)); // Rows, Cols, Hgap, Vgap

                // Username field
                JLabel userLabel = new JLabel("Username:");
                JTextField userField = new JTextField(15);
                userField.setPreferredSize(new Dimension(150, 20));

                // Password field
                JLabel passLabel = new JLabel("Password:");
                JPasswordField passField = new JPasswordField(15);
                passField.setPreferredSize(new Dimension(150, 20));

                // Login button
                JButton loginButton = new JButton("Login");
                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle login logic here
                        String username = userField.getText();
                        char[] passwordArray = passField.getPassword();
                        String password = new String(passwordArray);

                        // You can add your authentication logic here
                        

                    }
                });

                // Add components to the login frame
                loginFrame.add(userLabel);
                loginFrame.add(userField);
                loginFrame.add(passLabel);
                loginFrame.add(passField);
                loginFrame.add(new JLabel("")); // Placeholder for grid alignment
                loginFrame.add(loginButton);

                loginFrame.setVisible(true);
            }
        });

        // Set the menu bar on the frame
        frame.setJMenuBar(menuBar);

        // Display the window
        frame.setVisible(true);
    }
}
