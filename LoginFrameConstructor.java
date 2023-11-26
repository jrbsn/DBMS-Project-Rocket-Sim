public class LoginFrameConstructor {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginInterface.displayLogin(() -> {
                if (areCredentialsValid(LoginInterface.username, LoginInterface.password)) {
                    try {
                        // Here you can add the logic that should be executed after a successful login
                        // For example, opening another frame or performing some operations
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Invalid login credentials.");
                }
            });
        });
    }

    public static boolean areCredentialsValid(String username, String password) {
        // Here, add your logic to validate the username and password
        // This is just a placeholder logic. You should replace it with your actual validation logic.
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }
}