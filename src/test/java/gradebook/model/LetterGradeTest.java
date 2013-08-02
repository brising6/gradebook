package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class LetterGradeTest {
	Student brandon, brice, jack, bill, walker;
	GradingScheme scheme;
	ArrayList<GradebookItem> test;
	Section section1, section2, section3, section4, section5;
	Class class1, class2, class3, class4, class5;
	Course c1, c2, c3, c4, c5;
	
	@Before
	public void setUp() {
		scheme = new GradingSchemeFactory();
		brandon = new Student("Brandon", null, "902112345");
		brandon.setScheme(scheme);
		brice = new Student("Brice", scheme, "902221234");
		jack = new Student("Jack", scheme, "902331234");
		bill = new Student("Bill", scheme, "902441234");
		walker = new Student("Walker", scheme, "902551234");
		GradebookCategory category = new GradebookCategory("Test", .8);
		brandon.addGrade(new GradebookItem("Test 1", category, 90));
		test = new ArrayList<GradebookItem>();
		test.add(new GradebookItem("Test 1", category, 80));
		jack.setGrades(test);
		brice.addGrade(new GradebookItem("Test 1", category, 70));
		bill.addGrade(new GradebookItem("Test 1", category, 60));
		walker.addGrade(new GradebookItem("Test 1", category, 5));
		ArrayList<Student> roster1 = new ArrayList<Student>();
		roster1.add(walker);
		ArrayList<Student> roster2 = new ArrayList<Student>();
		roster2.add(bill);
		ArrayList<Student> roster3 = new ArrayList<Student>();
		roster3.add(brice);
		ArrayList<Student> roster4 = new ArrayList<Student>();
		roster4.add(jack);
		ArrayList<Student> roster5 = new ArrayList<Student>();
		roster5.add(brandon);
		section1 = new Section(roster1, "a1");
		section2 = new Section(roster2, "a2");
		section3 = new Section(roster3, "a3");
		section4 = new Section(roster4, "a4");
		section5 = new Section(roster5, "a5");
		class1 = new Class(2013, 1, "1");
		class1.addSection(section1);
		class2 = new Class(2013, 1, "1");
		class2.addSection(section2);
		class3 = new Class(2013, 1, "1");
		class3.addSection(section3);
		class4 = new Class(2013, 1, "1");
		class4.addSection(section4);
		class5 = new Class(2013, 1, "1");
		class5.addSection(section5);
		ArrayList<Class> classes1 = new ArrayList<Class>();
		classes1.add(class1);
		ArrayList<Class> classes2 = new ArrayList<Class>();
		classes2.add(class2);
		ArrayList<Class> classes3 = new ArrayList<Class>();
		classes3.add(class3);
		ArrayList<Class> classes4 = new ArrayList<Class>();
		classes4.add(class4);
		ArrayList<Class> classes5 = new ArrayList<Class>();
		classes5.add(class5);
		c1 = new Course("CS", 2340, "Objects and Design", null, new GradingSchemeFactory(), classes1);
		c2 = new Course("CS", 2340, "Objects and Design", null, new GradingSchemeFactory(), classes2);
		c3 = new Course("CS", 2340, "Objects and Design", null, new GradingSchemeFactory(), classes3);
		c4 = new Course("CS", 2340, "Objects and Design", null, new GradingSchemeFactory(), classes4);
		c5 = new Course("CS", 2340, "Objects and Design", null, new GradingSchemeFactory(), classes5);
	}
	@Test
	public void letterGradeTest() {
		assertEquals('F', c1.getLetterGrade());
		assertEquals('D', c2.getLetterGrade());
		assertEquals('C', c3.getLetterGrade());
		assertEquals('B', c4.getLetterGrade());
		assertEquals('A', c5.getLetterGrade());
	}
}
