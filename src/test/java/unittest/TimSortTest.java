package unittest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.astonstage1project.action.RandomGen;
import ru.astonstage1project.storage.Storage;
import ru.astonstage1project.util.TimSort;

public class TimSortTest {
	Storage storage;

	void fillStorage(Storage storage, String type) {
		var params = new HashMap<String, String>();
		params.put(type, "33");

		var randomGen = new RandomGen(storage);
		randomGen.doing(params);
	}

	@BeforeEach
	void setUp() {
		storage = new Storage();
	}

	@Test
	void testSortAnimal() {
		fillStorage(storage, "animal");
		assertEquals(storage.animals.size(), 33);
		TimSort.sort(storage.animals);
	}

	@Test
	void testSortBarrel() {
		fillStorage(storage, "barrel");
		assertEquals(storage.barrels.size(), 33);

	}

	@Test
	void testSortHuman() {
		fillStorage(storage, "human");
		assertEquals(storage.humans.size(), 33);

	}

	@Test
	void testSortMix() {}
}
