
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginInterface {
    static String username;
    static String password;
    
    public static void displayLogin(Runnable callback) {
        // Initialize the login frame
        JFrame loginFrame = initializeLoginFrame();

        // Add username input field
        JTextField usernameInput = addUsernameInput(loginFrame);

        // Add password input field
        JPasswordField passwordInput = addPasswordInput(loginFrame);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameInput.getText();
                String password = new String(passwordInput.getPassword());

                // You can add your login logic here
                // For example, checking the username and password

                callback.run(); // Run the callback
            }
        });
        loginFrame.add(submitButton);
        loginFrame.setVisible(true);
    }

    private static JFrame initializeLoginFrame() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setLayout(new FlowLayout());
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change to DISPOSE to not close entire application
        loginFrame.setSize(300, 150); // Adjust size as needed
        return loginFrame;
    }

    public static JTextField addUsernameInput(JFrame loginFrame) {
        JTextField username = new JTextField(20);
        JLabel usernameLabel = new JLabel("Username:");
        loginFrame.add(usernameLabel);
        loginFrame.add(username);
        return username;
    }

    public static JPasswordField addPasswordInput(JFrame loginFrame) {
        JPasswordField password = new JPasswordField(20);
        JLabel passwordLabel = new JLabel("Password:");
        loginFrame.add(passwordLabel);
        loginFrame.add(password);
        return password;
    }

    public static String addUsernameInput() {
        return null;
    }
}

