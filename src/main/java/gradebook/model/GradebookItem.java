package gradebook.model;

/**
 * Created with IntelliJ IDEA.
 * User: Brandon
 * Date: 7/30/13
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class GradebookItem {
    /**
     * The name of the item.
     */
    private String name;
    /**
     * The category of the item.
     */
    private GradebookCategory category;
    /**
     * The score of the item.
     */
    private double score;

    /**
     * The constructor.
     * @param name1 the name of the item
     * @param category1 the category
     * @param score1 the score
     */
    public GradebookItem(final String name1, final GradebookCategory category1,
                         final double score1) {
        this.name = name1;
        this.category = category1;
        this.score = score1;
    }
    /**
     * Getter for the score.
     * @return score
     */
    public final double getScore() {
        return score;
    }
    /**
     * Getter for the weight.
     * @return weight
     */
    public final double getWeight() {
        return category.getWeight();
    }
    /**
     * Getter for the category.
     * @return category
     */
    public final GradebookCategory getCategory() {
        return category;
    }
    /**
     * Getter for the name.
     * @return name
     */
    public final String getName() {
        return name;
    }
}
