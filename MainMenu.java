import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    public static void main(String[] args) {
        JFrame frame = initializeFrame();
        addCenterText(frame);
        addImage(frame);
        JMenuBar menuBar = createMenuBar();
        addAccountMenu(menuBar, frame);
        addRocketMenu(menuBar, frame);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private static JFrame initializeFrame() {
        JFrame frame = new JFrame("MyRocket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        return frame;
    }

    private static void addCenterText(JFrame frame) {
        JLabel centerText = new JLabel("Welcome to MyRocket!", SwingConstants.CENTER);
        centerText.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(centerText, BorderLayout.NORTH);
    }

    private static void addImage(JFrame frame) {
        ImageIcon imageIcon = new ImageIcon(MainMenu.class.getResource("/resources/space.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        frame.add(imageLabel, BorderLayout.CENTER);
    }

    private static JMenuBar createMenuBar() {
        return new JMenuBar();
    }

    private static void addAccountMenu(JMenuBar menuBar, JFrame frame) {
        JMenu accountMenu = new JMenu("Account");
        menuBar.add(accountMenu);

        JMenuItem menuItemLogin = new JMenuItem("Login");
        menuItemLogin.addActionListener(e -> showLoginFrame());
        accountMenu.add(menuItemLogin);

        JMenuItem menuItemLogout = new JMenuItem("Logout");
        accountMenu.add(menuItemLogout);

        JMenuItem menuItemRegister = new JMenuItem("Register");
        accountMenu.add(menuItemRegister);

        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(e -> System.exit(0));
        accountMenu.add(menuItemExit);
    }

    private static void addRocketMenu(JMenuBar menuBar, JFrame frame) {
        JMenu rocketMenu = new JMenu("Rocket");
        menuBar.add(rocketMenu);

        JMenuItem menuItemCreateRocket = new JMenuItem("Create Rocket");
        menuItemCreateRocket.addActionListener(e -> FrameConstructor.main(new String[0]));
        rocketMenu.add(menuItemCreateRocket);

        JMenuItem menuItemEditRocket = new JMenuItem("Edit Rocket");
        rocketMenu.add(menuItemEditRocket);

        JMenuItem menuItemCompareRocket = new JMenuItem("Compare Rocket");
        rocketMenu.add(menuItemCompareRocket);

        JMenuItem menuItemGraphRocket = new JMenuItem("Graph Rocket");
        rocketMenu.add(menuItemGraphRocket);
    }

    private static void showLoginFrame() {
        LoginFrameConstructor.main(new String[0]);
    }
}
