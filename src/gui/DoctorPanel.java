package gui;

import containers.PatientMapAccess;
import entities.Doctor;
import entities.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to display the information for a doctor, and accept operations on the doctor. The
 * panel gives the doctor's name and specialty (if any). The user has the option to add another patient
 * or remove a patient, and access a patient the same as if they accessed the patient from the patient
 * ops menu.
 */
public class DoctorPanel extends JPanel {
    /**
     * Create the panel to display the doctor's information and accept operations on the doctor.
     *
     * @param doctor the doctor whose information is to be displayed and on whom operations can be
     *        done
     */
    public DoctorPanel(Doctor doctor) {
        /*
         * The creation of the panel is placed in another method as it needs to be invoked whenever
         * the patient information of the doctor is changed.
         */
        build(doctor);
    }

    /**
     * Fill in the panel to display the doctor's information and accept operations on the doctor.
     *
     * @param doctor the doctor whose information is to be displayed and on whom operations can be
     *        done
     */
    private void build(Doctor doctor) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Name: " + doctor.getName()));
        // todo: add doctor specialty if applicable

        JPanel addPatientPanel = addPatientPanel(doctor);
        add(addPatientPanel);
        addPatientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addPatientPanel.setMaximumSize(addPatientPanel.getPreferredSize());

        JPanel removePatientPanel = removePatientPanel(doctor);
        add(removePatientPanel);
        removePatientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        removePatientPanel.setMaximumSize(removePatientPanel.getPreferredSize());

        add(new JLabel("  ")); // blank line in the panel for spacing
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    /**
     * A panel to add a doctor-patient association for this doctor. The panel as a prompt to enter
     * the doctor's name, and a field to enter the name.
     *
     * @param doctor the current doctor
     * @return a panel to associate a new patient with this doctor
     */
    private JPanel addPatientPanel(final Doctor doctor) {
        JPanel addPatientPanel = new JPanel();
        final JTextField textField = new JTextField(10);
        addPatientPanel.add(textField);
        final JButton addButton = new JButton("Add patient");
        addPatientPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int healthNum = validateHealthNum(textField);

                Patient patient = PatientMapAccess.dictionary().get(healthNum);
                if (patient != null) {
                    // recreate the panel as it has changed
                    try {
                        doctor.addPatient(patient);
                        JOptionPane.showMessageDialog(DoctorPanel.this,
                                "Patient " + patient.getHealthNumber() + " successfully added");
                    } catch (RuntimeException e) {
                        JOptionPane.showMessageDialog(DoctorPanel.this, e.getMessage());
                    }
                    removeAll();
                    build(doctor);
                    revalidate();
                } else {
                    textField.setText("Invalid id: " + textField.getText());
                    textField.revalidate();
                    return;
                }
            }
        });
        return addPatientPanel;
    }

    /**
     * A panel to remove a doctor-patient association for this doctor. The panel as a prompt to enter
     * the patient's health number, a field to enter the name, and a submit button.
     *
     * @param doctor the current doctor
     * @return a panel to associate a new doctor with this patient
     */
    private JPanel removePatientPanel(final Doctor doctor) {
        JPanel removePatientPanel = new JPanel();
        final JTextField textField = new JTextField(10);
        removePatientPanel.add(textField);
        final JButton addButton = new JButton("Remove patient");
        removePatientPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int healthNum = validateHealthNum(textField);

                // recreate the panel as it has changed
                try {
                    doctor.removePatient(healthNum);
                    JOptionPane.showMessageDialog(DoctorPanel.this,
                            "Patient " + healthNum + " successfully removed");
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(DoctorPanel.this, e.getMessage());
                }
                removeAll();
                build(doctor);
                revalidate();
            }
        });
        return removePatientPanel;
    }

    private int validateHealthNum(JTextField textField) {
        String valueAsString = textField.getText();
        int healthNum = -1;
        if (valueAsString != null && !valueAsString.isBlank()) {
            try {
                healthNum = Integer.parseInt(valueAsString);
            } catch (NumberFormatException e) {
                textField.setText("Not a valid int: " + textField.getText());
                textField.revalidate();
            }
        }
        return healthNum;
    }

    public static final long serialVersionUID = 1;
}
