package gradebook.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Brandon
 * Date: 7/30/13
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Course extends Component implements Storable {
    /**
     * This is the subject of the class.
     */
    private String subject;
    /**
     * The course number.
     */
    private int courseNumber;
    /**
     * The course name.
     */
    private String courseName;
    /**
     * The list of prerequisites.
     */
    private ArrayList<Course> prerequisites;
    /**
     * Grading scheme of the course.
     */
    private GradingScheme scheme;
    /**
     * The list of classes.
     */
    private ArrayList<Class> classes;

    /**
     * The Constructor.
     * @param subject1 the subject
     * @param courseNumber1 the course number
     * @param courseName1 the course name
     * @param prerequisites1 the prerequisite courses
     * @param scheme1 the scheme
     * @param classes1 the list of classes
     */
    public Course(final String subject1,
                  final int courseNumber1,
                  final String courseName1,
                  final ArrayList<Course> prerequisites1,
                  final GradingScheme scheme1,
                  final ArrayList<Class> classes1) {
        this.subject = subject1;
        this.scheme = scheme1;
        this.courseName = courseName1;
        this.courseNumber = courseNumber1;
        if (prerequisites1 == null) {
            this.prerequisites = new ArrayList<Course>();
        } else {
            this.prerequisites = prerequisites1;
        }
        super.addComponent(this);
        if (classes1 == null) {
            this.classes = new ArrayList<Class>();
        } else {
            this.classes = classes1;
        }
    }
    /**
     * Getter for the course number.
     * @return course number
     */
    public final int getCourseNumber() {
        return courseNumber;
    }
    /**
     * Getter for the subject.
     * @return subject
     */
    public final String getSubject() {
        return subject;
    }
    /**
     * Getter for prerequisite courses.
     * @return prerequisite
     */
    public final ArrayList<Course> getPreRequisites() {
        return prerequisites;
    }
    /**
     * Getter for the key.
     * @return course name
     */
    @Override
    public final String getKey() {
        return courseName;
    }
    /**
     * Getter for the grade scheme.
     * @return the grading scheme
     */
    public final GradingScheme getScheme() {
        return scheme;
    }
    /**
     * Method that returns the average of all the classes.
     * @return the average
     */
    @Override
    public final double getAverage() {
        double total = 0;
        int amount = 0;
        if (classes != null) {
            for (Class e: classes) {
                if (e != null) {
                    total += e.getAverage();
                    amount++;
                }
            }
        }
        return total / amount;
    }
    /**
     * Returns the average's lettergrade.
     * @return lettergrade
     */
    public final char getLetterGrade() {
        return scheme.getLetterGrade1Case(getAverage());
    }
    /**
     * Getter for the scheme.
     * @param scheme1 the scheme
     */
    public final void setScheme(final GradingScheme scheme1) {
        this.scheme = scheme1;
    }
    /**
     * Getter for the classes.
     * @return classes
     */
    public final ArrayList<Class> getClasses() {
        return classes;
    }
    /**
     * Method to add a class.
     * @param addClass the class to add.
     */
    public final void addClass(final Class addClass) {
        classes.add(addClass);
    }
    /**
     * Method that returns the student count.
     * @return total
     */
    @Override
    public final int studentCount() {
        int total = 0;
        if (classes != null) {
            for (Class e: classes) {
                total += e.studentCount();
            }
        }
        return total;
    }
}
