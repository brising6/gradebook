package gradebook.model;

import java.util.ArrayList;

/**
 * This class helps with finding grades for each component.
 */
public abstract class Component implements Storable {
    /**
     * This is a list of the components.
     */
    private ArrayList<Component> components;

    /**
     * The constructor instantiates the ArrayList.
     */
    public Component() {
        components = new ArrayList<Component>();
    }
    /**
     * This method gets the average of the component.
     * @return the average of the components
     */
    public abstract double getAverage();
    /**
     * This method gets the count of the students in the components.
     * @return count of the students
     */
    public abstract int studentCount();
    /**
     * This method adds a component.
     * @param component the component
     * @return the component
     */
    public final Component addComponent(final Component component) {
        components.add(component);
        return component;
    }

    @Override
    public abstract String getKey();
}
