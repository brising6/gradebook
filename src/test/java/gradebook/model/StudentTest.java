package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class StudentTest {
	Student brandon, brice, jack, bill;
	GradingScheme scheme;
	ArrayList<GradebookItem> test;
	
	@Before
	public void setUp() {
		scheme = new GradingSchemeFactory();
		brandon = new Student("Brandon", null, "902112345");
		brandon.setScheme(scheme);
		brice = new Student("Brice", scheme, "902221234");
		jack = new Student("Jack", scheme, "902331234");
		bill = new Student("Bill", scheme, "902441234");
		GradebookCategory category = new GradebookCategory("Test", .8);
		brandon.addGrade(new GradebookItem("Test 1", category, 80));
		test = new ArrayList<GradebookItem>();
		test.add(new GradebookItem("Test 1", category, 90));
		jack.setGrades(test);
		brice.addGrade(new GradebookItem("Test 1", category, 60));
		bill.addGrade(new GradebookItem("Test 1", category, 40));
	}
	
	@Test
	public void studentTest() {
		assertEquals("Brandon", brandon.getName());
		assertEquals(scheme, brandon.getScheme());
		assertEquals(1, brice.studentCount());
		assertEquals(test, jack.getGrades());
		assertEquals('B', brandon.getLetterGrade());
		assertEquals('A', jack.getLetterGrade());
		assertEquals('D', brice.getLetterGrade());
		assertEquals('F', bill.getLetterGrade());
	}
}
