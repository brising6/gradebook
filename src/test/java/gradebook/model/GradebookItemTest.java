package gradebook.model;


import static org.junit.Assert.*;

import org.junit.*;

public class GradebookItemTest {
	GradebookItem item;
	GradebookCategory category;
	
	@Before
	public void setUp() {
		category = new GradebookCategory("Test", .8);
		item = new GradebookItem("Test 1", category, 79);
	}
	
	@Test
	public void gradbookItemTest() {
		System.out.println(category.getName());
		assertEquals("Test", category.getName());
		assertEquals(category, item.getCategory());
		assertEquals("Test 1", item.getName());
	}
}
