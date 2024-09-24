package unittest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.astonstage1project.model.Animal;
import ru.astonstage1project.model.Barrel;
import ru.astonstage1project.model.Human;
import ru.astonstage1project.storage.Storage;
import ru.astonstage1project.util.TimSort;

public class TimSortTest {
	static Storage storage;
	static String[][] animals = new String[][] {
		{"кот", "зеленые", "true"},
		{"пес", "коричневые", "true"},
		{"змея", "желтые", "false"},
	};
	static String animalsResult = "{Animal{wool=false, eyesColor='желтые', species='змея'}}\n" +
			"{Animal{wool=true, eyesColor='зеленые', species='кот'}}\n" +
			"{Animal{wool=true, eyesColor='коричневые', species='пес'}}\n";

	static String[][] barrels = new String[][] {
		{"89", "железо", "уран"},
		{"5", "дерево", "пиво"},
		{"3", "пластик", "вода"},
	};
	static String barrelsResult = "{Barrel{volume=3, storedMaterial='вода', barrelMaterial='пластик'}}\n" +
			"{Barrel{volume=5, storedMaterial='пиво', barrelMaterial='дерево'}}\n" +
			"{Barrel{volume=89, storedMaterial='уран', barrelMaterial='железо'}}\n";

	static String[][] humans = new String[][] {
		{"m", "23", "Jhonson"},
		{"f", "20", "Peterson"},
		{"m", "89", "Miller"},
	};
	static String humansResult = "{Human{sex=FEMALE, age=20, surname='Peterson'}}\n" +
			"{Human{sex=MALE, age=23, surname='Jhonson'}}\n" +
			"{Human{sex=MALE, age=89, surname='Miller'}}\n";

	<T> String printList(List<T> list) {
		var out = new StringBuilder();
		for(T el : list) {
			out.append("{" + el.toString() + "}\n");
		}
		return out.toString();
	}

	@BeforeAll
	static void setUp() {
		storage = new Storage();
		for (String[] a : animals) {
			storage.animals.add(
				Animal.getBuilder()
						.setSpecies(a[0])
						.setEyesColor(a[1])
						.setWool(a[2] == "true" ? true : false)
						.build()
			);
		}
		for (String[] b : barrels) {
			storage.barrels.add(
				Barrel.getBuilder()
					.setVolume(Integer.parseInt(b[0]))
					.setBarrelMaterial(b[1])
					.setStoredMaterial(b[2])
					.build()
			);
		}
		for (String[] h : humans) {
			storage.humans.add(
				Human.getBuilder()
						.setSex(h[0] == "m" ? Human.Sex.MALE : Human.Sex.FEMALE)
						.setAge(Integer.parseInt(h[1]))
						.setSurname(h[2])
						.build()
			);
		}

	}

	@Test
	void testSortAnimal() {
		System.out.println("========= Before sort =============");
		System.out.println(printList(storage.animals));
		TimSort.sort(storage.animals);
		assertEquals(printList(storage.animals), animalsResult);
		System.out.println("========= After sort =============");
		System.out.println(printList(storage.animals));
	}

	@Test
	void testSortBarrel() {
		System.out.println("========= Before sort =============");
		System.out.println(printList(storage.barrels));
		TimSort.sort(storage.barrels);
		assertEquals(printList(storage.barrels), barrelsResult);
		System.out.println("========= After sort =============");
		System.out.println(printList(storage.barrels));

	}

	@Test
	void testSortHuman() {
		System.out.println("========= Before sort =============");
		System.out.println(printList(storage.humans));
		TimSort.sort(storage.humans);
		assertEquals(printList(storage.humans), humansResult);
		System.out.println("========= After sort =============");
		System.out.println(printList(storage.humans));

	}
}
