package unittest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.astonstage1project.util.Search;
import ru.astonstage1project.util.TimSort;

public class BinarySearchTest {
	static List<String> list = new ArrayList<>();
	static Map<String, Integer> want = new HashMap<>();

	<T> String printList(List<T> list) {
		var out = new StringBuilder();
		for(T el : list) {
			out.append("{" + el.toString() + "}\n");
		}
		return out.toString();
	}

	@BeforeAll
	static void setUp() {
		list.add("string1");
		list.add("String1");
		list.add("ng1");
		list.add("Ang1");
		list.add("A-ng1");
		TimSort.sort(list);

		want.put("ng1", 3);
		want.put("A-ng1", 0);
		want.put("Ng1", -1);
	}

	@Test
	void binarySearchTest() {
		System.out.println(printList(list));
		for(Map.Entry<String, Integer> e : want.entrySet()) {
			var result = Search.binary(list, e.getKey());
			assertEquals(result, e.getValue());
		}
	}
}
