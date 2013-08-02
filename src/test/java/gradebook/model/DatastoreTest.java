package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class DatastoreTest {
	Course cs2340;
	Class summer2013;
	Class spring2013;
	Student brandon, brice, jack;
	Section a1, b2, c3;
	Datastore datastore;
	
	@Before
	public void setUp() {
		GradebookCategory category = new GradebookCategory("Test", .8);
    	GradebookCategory category2 = new GradebookCategory("Homework", .2);
		brandon = new Student("Brandon", new GradingSchemeFactory(), "902112345");
		brice = new Student("Brice", new GradingSchemeFactory(), "902221234");
		jack = new Student("Jack", new GradingSchemeFactory(), "902331234");
		ArrayList<Student> section1 = new ArrayList<Student>();
		ArrayList<Student> section2 = new ArrayList<Student>();
		ArrayList<Student> section3 = new ArrayList<Student>();
        brandon.addGrade(new GradebookItem("Test 1", category, 80));
        brandon.addGrade(new GradebookItem("Test 1", category, 80));
        brandon.addGrade(new GradebookItem("Test 1", category, 80));
        brandon.addGrade(new GradebookItem("Test 1", category, 80));
    	section1.add(brandon);
		section2.add(brice);
		section3.add(jack);
		a1 = new Section(section1, "a1");
		b2 = new Section(section2, "b2");
		c3 = new Section(section3, "c3");
        brice.addGrade(new GradebookItem("Test 1", category, 79));
        jack.addGrade(new GradebookItem("Test 1", category, 50));
        brandon.addGrade(new GradebookItem("Homework 1", category2, 0));
        brice.addGrade(new GradebookItem("Homework 1", category2, 79));
        jack.addGrade(new GradebookItem("Homework 1", category2, 50));
        ArrayList<Class> classes = new ArrayList<Class>();
		summer2013 = new Class(2013, 3, "C1012");
		spring2013 = new Class(2013, 2, "C1011");
		summer2013.addSection(a1);
		summer2013.addSection(b2);
		summer2013.addSection(c3);
		classes.add(summer2013);
        cs2340 = new Course("CS", 2340, "Objects and Design", null, new GradingSchemeFactory(), classes);
        datastore = new DatastoreHashMap();
        datastore.add(cs2340);
        datastore.add(summer2013);
        datastore.add(spring2013);
        datastore.add(brandon);
        datastore.add(brice);
        datastore.add(jack);
        datastore.add(a1);
        datastore.add(b2);
        datastore.add(c3);
	}
	
	@Test
	public void dataStoreTest() {
		assertEquals(a1, datastore.get(a1.getKey()));
		assertEquals("Brandon 902112345", brandon.getKey());
		assertEquals(brandon, datastore.get("Brandon 902112345"));
		assertEquals(summer2013, datastore.get(summer2013.getKey()));
	}
}
