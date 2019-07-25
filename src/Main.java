import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println(makeListAndSortByAge("Persons.csv"));
	}
	public static List<Person> makeListAndSortByAge(String fileName) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		return br
				.lines()
				.map(s -> s.split(","))
				.filter(a -> Integer.parseInt(a[2].trim()) >17)
				.map(p -> new Person(p[0].trim(),p[1].trim(),Integer.parseInt(p[2].trim())))
				.sorted(Comparator.comparing(Person::getAge))
				.collect(Collectors.toList());
	}
}
