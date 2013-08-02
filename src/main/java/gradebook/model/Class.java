package gradebook.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Brandon
 * Date: 7/30/13
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Brandon
 */
public class Class extends Component implements Storable {
    /**
     * These are the sections of the class.
     */
    private ArrayList<Section> sections;
    /**
     * This is the year the class is held.
     */
    private int year;
    /**
     * This is the semester in which the class is held.
     */
    private int semester;
    /**
     * This is the class' code for storing.
     */
    private String classCode;
    /**
     * this is the constructor for the Class class.
     * @param year1 year of the class
     * @param semester1 semester of the class
     * @param classCode1 class' code
     */
    public Class(final int year1, final int semester1,
                final String classCode1) {
        super.addComponent(this);
        this.year = year1;
        this.classCode = classCode1;
        this.semester = semester1;
        sections = new ArrayList<Section>();
    }
    /**
     * This method adds a section to the class.
     * @param section section to add
     */
    public final void addSection(final Section section) {
        sections.add(section);
    }
    /**
     * This method gets the number of sections.
     * @return number of sections
     */
    public final int numberOfSections() {
        return sections.size();
    }
    /**
     * This method gets the average of the sections.
     * @return average of sections
     */
    @Override
    public final double getAverage() {
      double total = 0;
      if (sections != null) {
          for (Section e: sections) {
              if (e != null) {
                  total += e.getAverage();
              }
          }
      }
      return total / sections.size();
    }
    /**
     * This method gets the student counts from each of the sections.
     * @return total
     */
    public final int studentCount() {
        int total = 0;
        if (sections != null) {
            for (Section e: sections) {
                if (e != null) {
                    total += e.studentCount();
                }
            }
        }
        return total;
    }
    /**
     * This method gets the year of the class.
     *
     * @return year
     */
    public final int getYear() {
        return year;
    }
    /**
     * This method gets the semester of the class.
     * @return semester
     */
    public final int getSemester() {
        return semester;
    }
    /**
     * This method gets the key for the datastore.
     * @return key of class
     */
    @Override
    public final String getKey() {
        return classCode;
    }
}
