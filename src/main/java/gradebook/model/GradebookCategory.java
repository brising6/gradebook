package gradebook.model;


/**
 * Created with IntelliJ IDEA.
 * User: Brandon
 * Date: 7/30/13
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class GradebookCategory {
    /**
     * The name of the category.
     */
    private String name;
    /**
     * How much the category is weighted.
     */
    private double weight;

    /**
     * The constructor.
     * @param name1 the name of the category
     * @param weight1 the weight of the category
     */
    public GradebookCategory(final String name1, final double weight1) {
        this.name = name1;
        this.weight = weight1;
    }
    /**
     * Getter for the weight.
     * @return the weight
     */
    public final double getWeight() {
        return weight;
    }
    /**
     * The getter for the name.
     * @return the name
     */
    public final String getName() {
        return name;
    }
}
