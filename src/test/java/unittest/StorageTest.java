package unittest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.astonstage1project.model.Animal;
import ru.astonstage1project.storage.Storage;

import static org.junit.jupiter.api.Assertions.*;


public class StorageTest {
    Storage storage;

    @BeforeEach
    void setUp() {
        storage = new Storage();
    }

    @Test
    void testAddAnimal() {
        Animal.AnimalBuilder animalBuilder = Animal.getBuilder();
        animalBuilder.setSpecies("123")
                .setWool(true)
                .setEyesColor("red");
        Animal animal = animalBuilder.build();

        int start_size = storage.animals.size();
        storage.add(animal);
        Animal gettedAnimal = storage.animals.getFirst();
        int end_size = storage.animals.size();

        assertEquals(start_size, 0);
        assertEquals(end_size, 1);
        assertEquals(gettedAnimal, animal);
    }

    @Test
    void testResetStorage() {
        Animal.AnimalBuilder animalBuilder = Animal.getBuilder();
        animalBuilder.setSpecies("123")
                .setWool(true)
                .setEyesColor("red");
        Animal animal = animalBuilder.build();

        int start_size = storage.animals.size();
        storage.add(animal);
        int middle_size = storage.animals.size();
        storage.reset();
        int end_size = storage.animals.size();

        assertEquals(start_size, 0);
        assertEquals(middle_size, 1);
        assertEquals(end_size, 0);
    }

    @AfterEach
    void tearDown() {
    }
}
