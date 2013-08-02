package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class ComponentTest {
	Course cs2340;
	Course cs2200;
	Class summer2013;
	Class spring2013;
	Student brandon, brice, jack;
	Section a1, b2, c3;
	GradingScheme scheme;
	ArrayList<Class> classes;
	ArrayList<Course> prereqs;
	
	@Before
	public void Setup() {
		scheme = new GradingSchemeFactory();
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
        classes = new ArrayList<Class>();
		summer2013 = new Class(2013, 3, "C1012");
		spring2013 = new Class(2013, 2, "C1011");
		summer2013.addSection(a1);
		summer2013.addSection(b2);
		summer2013.addSection(c3);
		classes.add(summer2013);
		cs2200 = new Course("CS", 2200, "Stuff", null, new GradingSchemeFactory(), null);
		cs2200.addClass(summer2013);
		prereqs = new ArrayList<Course>();
		prereqs.add(cs2200);
        cs2340 = new Course("CS", 2340, "Objects and Design", prereqs, new GradingSchemeFactory(), classes);
        cs2340.setScheme(scheme);
	}
	@Test
	public void testAverage() {
		assertEquals(64, (int)Math.round(a1.getAverage()));
		assertEquals(50, (int)Math.round(jack.getAverage()));
		assertEquals(64, (int)Math.round(a1.getAverage()));
		assertEquals(64, (int)Math.round(cs2340.getAverage()));
		assertEquals(64, (int)Math.round(summer2013.getAverage()));
	}
	@Test
	public void testLetterGrade(){
		assertEquals('D', cs2340.getLetterGrade());
		assertEquals('C', brice.getLetterGrade());
	}
	@Test
	public void testCourse() {
		assertEquals(classes, cs2340.getClasses());
		assertEquals(3, cs2340.studentCount());
		assertEquals(2340, cs2340.getCourseNumber());
		assertEquals("CS", cs2340.getSubject());
		assertEquals(prereqs, cs2340.getPreRequisites());
		assertEquals(scheme, cs2340.getScheme());
	}
}
