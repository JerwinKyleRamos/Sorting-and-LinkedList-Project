package Project2.GUI.UtilGUI;

import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;
import java.awt.*;


public class EditCoursePage extends JFrame {
    private JTextField courseNameField, courseIdField;
    private JButton updateButton;
    private JPanel editCoursePanel, buttonPanel;

    public EditCoursePage(DefaultListModel<Course<Term<Topic>>> courseDefaultListModel, Course<Term<Topic>> selectedCourse, int selectedIndex) {
        setTitle("Edit Course");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize and populate input fields with course details
        courseNameField = new JTextField(selectedCourse.getCourseName());
        courseIdField = new JTextField(selectedCourse.getCourseID());

        updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            // Update the course details based on the input fields
            selectedCourse.setCourseName(courseNameField.getText());
            selectedCourse.setCourseID(courseIdField.getText());
            courseDefaultListModel.setElementAt(selectedCourse, selectedIndex);

            // Close the edit page
            dispose();
        });

        editCoursePanel = new JPanel(new GridLayout(4, 1, 5, 5));
        editCoursePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        editCoursePanel.add(new JLabel("Course ID"));
        editCoursePanel.add(courseIdField);
        editCoursePanel.add(new JLabel("Course Name:"));
        editCoursePanel.add(courseNameField);
        editCoursePanel.setBackground(Color.PINK);

        buttonPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        buttonPanel.add(updateButton);
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));

        add(editCoursePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 180);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}