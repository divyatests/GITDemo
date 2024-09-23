import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaStreamPractice {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		ArrayList<String> Names = new ArrayList<String>();
		Names.add("Divya");
		Names.add("Raj");
		Names.add("Nayonika");
		Names.add("Vishal");
		Names.add("Anaisha");

		int[] a1 = { 1, 23, 5, 3, 5, 2, 6, 7, 7, 3, 2 };

		// TO print avg of numbers
		// System.out.println("average is" +
		// numbers.stream().mapToDouble(s->s.intValue()).average());

		// to print upper and lower case

		List<String> NewNames = Names.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

		// System.out.println(NewNames);
		// Names.stream().map(s->s.toLowerCase()).forEach(s->System.out.println(s));

		// To remove all duplicate elements
		List<Integer> a2 = Arrays.asList(1, 23, 5, 3, 5, 2, 6, 7, 7, 3, 2);
		// a2.stream().distinct().forEach(s->System.out.println(s));

		// To count number of string stating with a
		long count = NewNames.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(count);

		// TO sort in acs order and desc order
		NewNames.stream().sorted().forEach(s -> System.out.println(s));
		NewNames.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));

		// to see max value in a list
		Optional<Integer> max_val = a2.stream().max(Integer::compare);
		System.out.println(max_val);

		sortTable();
	}

	public static void sortTable() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		// Clcik on header
		// driver.findElement(By.xpath("//div[@class='tableFixHead']//tr/th[1])")).click();

		// get all the elements from table

		List<WebElement> NamesList = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr/td[1]"));
		// get name of all the elements

		List<String> NamesRetrived = NamesList.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(NamesRetrived);

		// Sort them

		List SortedNames = NamesRetrived.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(SortedNames);

	}

}
