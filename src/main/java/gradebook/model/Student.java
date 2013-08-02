package gradebook.model;

import java.util.ArrayList;

/**
 * This is the student class.
 */
public class Student extends Component implements Storable {
    /**
     * The student's name.
     */
    private String name;
    /**
     * The student's list of grades.
     */
    private ArrayList<GradebookItem> grades;
    /**
     * The grading scheme.
     */
    private GradingScheme scheme;
    /**
     * The student ID number.
     */
    private String studentID;
    /**
     * The constructor.
     * @param name1 the student's name
     * @param studentID1 student ID number
     * @param scheme1 the grading scheme
     */
    public Student(final String name1, final GradingScheme scheme1,
                    final String studentID1) {
        this.name = name1;
        this.scheme = scheme1;
        this.studentID = studentID1;
        super.addComponent(this);
        grades = new ArrayList<GradebookItem>();
    }
    /**
     * Getter for the name.
     * @return name
     */
    public final String getName() {
        return name;
    }
    /**
     * Getter for the student's grades.
     * @return grades
     */
    public final ArrayList<GradebookItem> getGrades() {
        return grades;
    }
    /**
     * Setter for the grades.
     * @param grades1 new grades
     */
    public final void setGrades(final ArrayList<GradebookItem> grades1) {
        this.grades = grades1;
    }
    /**
     * Method to add a grade.
     * @param grade the grade
     */
    public final void addGrade(final GradebookItem grade) {
        grades.add(grade);
    }
    /**
     * setter for the scheme.
     * @param scheme1 grading scheme
     */
    public final void setScheme(final GradingScheme scheme1) {
        this.scheme = scheme1;
    }
    /**
     * Getter for the grading scheme.
     * @return scheme
     */
    public final GradingScheme getScheme() {
        return scheme;
    }
    /**
     * Method for the average.
     * @return average
     */
    @Override
    public final double getAverage() {
        return scheme.getAverage(grades);
    }
    /**
     * Returns the lettergrade of the student.
     * @return lettergrade
     */
    public final char getLetterGrade() {
        return scheme.getLetterGrade(grades);
    }
    /**
     * Return the student count.
     * @return the student count (1)
     */
    @Override
    public final int studentCount() {
        return 1;
    }
    /**
     * Getter for the key.
     * @return the name
     */
    @Override
    public final String getKey() {
        return name + " " + studentID;
    }
}
