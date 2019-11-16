package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel for the access of a specific doctor. It has a prompt label, and a text field for the
 * entry of the doctor's health number. When the Enter key is pressed, the doctor name entered is
 * used to create a new window with the doctor's data and operations on the doctor.
 */
public class DoctorAccessPanel extends JPanel {
    /**
     * The text field for the entry of the doctor's name.
     */
    JTextField textField;

    /**
     * Create the panel with the prompt label and text field. If data is entered into the text field
     * that is not a valid doctor name, a brief error message is entered at the front of the text
     * field. Otherwise, a new window is created with the doctor's data and operations on the
     * doctor.
     */
    public DoctorAccessPanel() {
        JLabel promptLabel = new JLabel("Access doctor");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String doctorName = textField.getText();
                if (doctorName != null && doctorName.length() > 0) {
                    DoctorFrame frame = null;
                    try {
                        frame = new DoctorFrame(doctorName);
                    } catch (RuntimeException e) {
                        textField.setText("Invalid name: " + textField.getText());
                        textField.revalidate();
                        return;
                    }
                    frame.setLocation(300, 300);
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setVisible(true);
                    textField.setText("");
                    textField.revalidate();
                } else {
                    textField.setText("Empty field: " + textField.getText());
                    textField.revalidate();
                }
            }
        });
    }

    public static final long serialVersionUID = 1;
}
