package gradebook.model;

import java.util.Collection;

/**
 * This is the grading scheme interface.
 */
public interface GradingScheme {
    /**
     * Method to return the average.
     * @param grades grades
     * @return average
     */
    double getAverage(Collection<GradebookItem> grades);
    /**
     * Method to return the letter grade.
     * @param grades grade
     * @return letter grade
     */
    char getLetterGrade(Collection<GradebookItem> grades);
    /**
     * This method returns the letter grade for 1 score.
     * @param average the score
     * @return the letter grade
     */
    char getLetterGrade1Case(double average);
}
