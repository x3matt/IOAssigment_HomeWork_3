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
				.filter(a -> checker(a))
				.map(p -> personMaker(p))
				.sorted(Comparator.comparing(Person::getAge))
				.collect(Collectors.toList());
	}
	private static boolean checker(String[] str) {
		return parser(str[2])>17;
	}
	private static Integer parser(String str) {
		return Integer.parseInt(str.trim());
	}
	private static Person personMaker(String[] str) {
		return new Person(str[0].trim(),str[1].trim(),parser(str[2].trim()));
	}
}
