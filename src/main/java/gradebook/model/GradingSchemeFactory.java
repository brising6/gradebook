package gradebook.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Brandon
 * Date: 7/31/13
 * Time: 8:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class GradingSchemeFactory implements GradingScheme {
    /**
     * Grade A char.
     */
    public static final char A = 'A';
    /**
     * Grade B char.
     */
    public static final char B = 'B';
    /**
     * Grade C char.
     */
    public static final char C = 'C';
    /**
     * Grade D char.
     */
    public static final char D = 'D';
    /**
     * Grade F char.
     */
    public static final char F = 'F';
    /**
     * Grade A cuttoff index.
     */
    public static final int CUTTOFFA = 90;
    /**
     * Grade B cuttoff index.
     */
    public static final int CUTTOFFB = 80;
    /**
     * Grade C cuttoff index.
     */
    public static final int CUTTOFFC = 70;
    /**
     * Grade D cuttoff index.
     */
    public static final int CUTTOFFD = 60;
    @Override
    public final double getAverage(final Collection<GradebookItem> grades) {
        double achieved = 0;
        double possible = 0;
        HashMap<Double, ArrayList<Double>> averager = new HashMap<Double,
                                                    ArrayList<Double>>();
        for (GradebookItem e: grades) {
            if (!averager.containsKey(e.getWeight())) {
                ArrayList<Double> list = new ArrayList<Double>();
                list.add(e.getScore());
                averager.put(e.getWeight(), list);
            } else {
                ArrayList<Double> list = averager.get(e.getWeight());
                averager.remove(e.getWeight());
                list.add(e.getScore());
                averager.put(e.getWeight(), list);
            }
        }
        for (Double e: averager.keySet()) {
            double average = 0;
            for (Double n: averager.get(e)) {
                average += n;
            }
            average /= averager.get(e).size();
            achieved += average * e;
            possible += e;
        }
        return achieved / possible;
    }
    @Override
    public final char getLetterGrade(final Collection<GradebookItem> grades) {
        double grade = getAverage(grades);
        if (grade < CUTTOFFA) {
            if (grade < CUTTOFFB) {
                if (grade < CUTTOFFC) {
                    if (grade < CUTTOFFD) {
                        return F;
                    }
                    return D;
                }
                return C;
            }
            return B;
        }
        return A;
    }
    /**
     * Returns the lettergrade for a single score.
     * @param grade the grade
     * @return the lettergrade
     */
    public final char getLetterGrade1Case(final double grade) {
        if (grade < CUTTOFFA) {
            if (grade < CUTTOFFB) {
                if (grade < CUTTOFFC) {
                    if (grade < CUTTOFFD) {
                        return F;
                    }
                    return D;
                }
                return C;
            }
            return B;
        }
        return A;
    }
}
