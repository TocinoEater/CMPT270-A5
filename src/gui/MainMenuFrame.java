package gui;

import javax.swing.*;

/**
 * The frame to obtain input to initialize the main menu, and then it will start the main menu.
 */
public class MainMenuFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the main menu.
     */
    public MainMenuFrame() {
        setTitle("Main Menu");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        MainMenuPanel panel = new MainMenuPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
