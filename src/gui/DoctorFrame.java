package gui;

import containers.DoctorMapAccess;
import entities.Doctor;
import entities.Surgeon;

import javax.swing.*;

/**
 * The frame for the window to display the information for a doctor, and accept operations on the
 * doctor.
 */
public class DoctorFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information for a doctor.
     *
     * @param doctorName the name of the doctor
     */
    public DoctorFrame(String doctorName) {
        Doctor doctor = DoctorMapAccess.dictionary().get(doctorName);
        boolean isSurgeon = doctor instanceof Surgeon;
        if (doctor != null) {
            setTitle(doctor.getName() + (isSurgeon ? "(Surgeon)" : ""));
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            DoctorPanel panel = new DoctorPanel(doctor);
            add(panel);
        } else
            throw new RuntimeException("Invalid doctor name " + doctorName);
    }

    public static final long serialVersionUID = 1;
}
