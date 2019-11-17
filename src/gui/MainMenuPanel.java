package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main menu panel to access operations for patients, doctors, the ward, and exit.
 * There is a button to access patient operations, a button to access doctor operations,
 * a button to access ward information, and a button to exit the program.
 */
public class MainMenuPanel extends JPanel {
    /**
     * Create the panel for the main menu. There is a button to access patient operations,
     * , a button to access doctor operations, a button to access ward information, and a
     * button to exit the program.
     */
    public MainMenuPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a button to access patient operations
        JButton patientOperationsButton = new JButton("Patient Operations");
        patientOperationsButton.setMaximumSize(patientOperationsButton.getPreferredSize());
        add(patientOperationsButton);
        patientOperationsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        patientOperationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                PatientOpsFrame frame = new PatientOpsFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a button to access doctor operations
        JButton doctorOperationsButton = new JButton("Doctor Operations");
        doctorOperationsButton.setMaximumSize(doctorOperationsButton.getPreferredSize());
        add(doctorOperationsButton);
        doctorOperationsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        doctorOperationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DoctorOpsFrame frame = new DoctorOpsFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a button to access ward information
        JButton wardInformationButton = new JButton("Ward Information");
        wardInformationButton.setMaximumSize(wardInformationButton.getPreferredSize());
        add(wardInformationButton);
        wardInformationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wardInformationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WardFrame frame = new WardFrame();
                frame.setLocation(300,300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a button to exit
        JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static final long serialVersionUID = 1;
}
