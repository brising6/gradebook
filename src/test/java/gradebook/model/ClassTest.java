package gradebook.model;

import static org.junit.Assert.*;
import org.junit.*;

public class ClassTest {
	Class summer2013;
	Class fall2013;
	
	@Before
	public void setUp() {
		summer2013 = new Class(2013, 3, null);
		summer2013.addSection(new Section(null, "A1"));
		fall2013 = new Class(2013, 1, null);
		fall2013.addSection(new Section(null, "A1"));
		fall2013.addSection(new Section(null, "A2"));
		fall2013.addSection(new Section(null, "A3"));
	}
	@Test
	public void testAddSection() {
		assertEquals(1, summer2013.numberOfSections());
		assertEquals(3, fall2013.numberOfSections());
		assertEquals(0, fall2013.studentCount());
		assertEquals(2013, summer2013.getYear());
		assertEquals(1, fall2013.getSemester());
	}
}
