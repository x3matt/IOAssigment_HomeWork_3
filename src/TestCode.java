import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestCode {

	@Test
	public void makeListAndSortByAgeTest() throws Exception{
		//"Persons.csv"
		List<Person> res= Arrays.asList(
				new Person("Ivan","Ivanov",18)
				,new Person("Piotr","Andreew",20)
				,new Person("Anna","Karenina",10)
				);
		assertEquals(res, Main.makeListAndSortByAge("Persons.csv"));
	}
 }

