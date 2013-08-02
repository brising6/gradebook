package gradebook.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Brandon
 * Date: 7/30/13
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Section extends Component implements Storable {
    /**
     * The list of students in the section.
     */
    private ArrayList<Student> roster;
    /**
     * The name of the section.
     */
    private String name;

    /**
     * The constructor.
     * @param roster1 the list of students
     * @param name1 the name of the section
     */
    public Section(final ArrayList<Student> roster1, final String name1) {
        if (roster1 != null) {
            this.roster = roster1;
        } else {
            this.roster = new ArrayList<Student>();
        }
        this.name = name1;
        super.addComponent(this);
    }
    /**
     * Method to get the average.
     * @return the average
     */
    public final double getAverage() {
        double total = 0;
        if (roster != null) {
            for (Student e: roster) {
                total += e.getAverage();
            }
        }
        return total / roster.size();
    }
    /**
     * Method to get the student count.
     * @return student count
     */
    public final int studentCount() {
        return roster.size();
    }
    /**
     * Getter for the key.
     * @return the key(the name)
     */
    @Override
    public final String getKey() {
        return name;
    }
}
