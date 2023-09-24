/**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     COLOMA, Stephen M.- 2232847@slu.edu.ph
 *     GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *     NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *     RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *     RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *     ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *     SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */

package Project2.GUI.UtilGUI;

import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditCoursePage extends JFrame {

    // Declare GUI components
    private JTextField courseNameField, courseIdField;
    private JButton updateButton;
    private JPanel editCoursePanel, buttonPanel;

    // Color theme from CourseListPage
    static Color mustard = new Color(255, 219, 87);
    static Color royaBlue = new Color(17, 41, 107);
    static Color flashWhite = new Color(237, 237, 237);
    static Color polynesianBlue = new Color(0, 80, 157);

    public EditCoursePage(DefaultListModel<Course<Term<Topic>>> courseDefaultListModel, Course<Term<Topic>> selectedCourse, int selectedIndex) {
        setTitle("Edit Course");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize and populate input fields with course details
        courseNameField = new JTextField(selectedCourse.getCourseName());
        courseIdField = new JTextField(selectedCourse.getCourseID());
        courseNameField.setBorder(BorderFactory.createLineBorder(polynesianBlue));
        courseIdField.setBorder(BorderFactory.createLineBorder(polynesianBlue));

        updateButton = new JButton("Update");
        buttonDesign(updateButton);

        updateButton.addActionListener(e -> {
            try {
                // Get the updated values from the input fields
                String updatedName = courseNameField.getText();
                String updatedId = courseIdField.getText();

                // Update the course details based on the input fields
                selectedCourse.setCourseName(updatedName);
                selectedCourse.setCourseID(updatedId);
                courseDefaultListModel.setElementAt(selectedCourse, selectedIndex);

                // Close the edit page
                dispose();
            } catch (Exception ex) {
                // Display an error message in case of unexpected exceptions
                JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Set up GUI layout for editing course details
        editCoursePanel = new JPanel(new GridLayout(4, 1, 5, 5));
        editCoursePanel.setBackground(mustard);
        editCoursePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        editCoursePanel.add(new JLabel("Course ID:"));
        editCoursePanel.add(courseIdField);
        editCoursePanel.add(new JLabel("Course Name:"));
        editCoursePanel.add(courseNameField);

        buttonPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        buttonPanel.setBackground(mustard);
        buttonPanel.add(updateButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));

        add(editCoursePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 190);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void buttonDesign(JButton button) {
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(polynesianBlue, 2, false),
                BorderFactory.createEmptyBorder(8, 18, 8, 18)));
        button.setBackground(flashWhite);
        button.setForeground(polynesianBlue);
        button.setPreferredSize(new Dimension(100, button.getPreferredSize().height)); // set width to 100 and keep the original height

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(polynesianBlue, 2, false),
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(polynesianBlue);
                button.setForeground(flashWhite);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(polynesianBlue, 2, false),
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(flashWhite);
                button.setForeground(polynesianBlue);
            }
        });
    }
}
