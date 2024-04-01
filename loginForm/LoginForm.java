package loginForm;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends Frame implements ActionListener {
    TextField usernameField, passwordField;
    Button loginButton, logoutButton;
    Label statusLabel;
    Panel loginPanel, welcomePanel;
    
    public LoginForm() {
        // Initialize login panel
        loginPanel = new Panel(new GridLayout(3, 2));
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new TextField();
        passwordField.setEchoChar('*');
        loginButton = new Button("Login");
        loginButton.addActionListener(this);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        
        // Initialize welcome panel
        welcomePanel = new Panel();
        Label welcomeLabel = new Label("Welcome, User!");
        logoutButton = new Button("Logout");
        logoutButton.addActionListener(this);
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(logoutButton);
        
        // Initialize status label
        statusLabel = new Label();
        
        // Add components to the frame
        add(loginPanel);
        add(welcomePanel);
        add(statusLabel);
        
        // Set initial visibility
        loginPanel.setVisible(true);
        welcomePanel.setVisible(false);
        
        // Frame settings
        setTitle("Login Form");
        setSize(500, 150);
        setLayout(new FlowLayout());
        setVisible(true);
        
        // Close window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.equals("admin") && password.equals("123")) {
                loginPanel.setVisible(false);
                welcomePanel.setVisible(true);
                statusLabel.setText("");
            } else {
                statusLabel.setText("Invalid username or password.");
            }
        } else if (e.getSource() == logoutButton) {
            loginPanel.setVisible(true);
            welcomePanel.setVisible(false);
            usernameField.setText("");
            passwordField.setText("");
            statusLabel.setText("");
        }
    }
    
    public static void main(String[] args) {
        new LoginForm();
    }
}