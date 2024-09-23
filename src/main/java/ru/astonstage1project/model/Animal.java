package ru.astonstage1project.model;

public class Animal implements Comparable<Animal> {
    private String species;
    private String eyesColor;
    private boolean wool;

    private Animal() {
    }

    public String getSpecies() {
        return species;
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public boolean getWool() {
        return wool;
    }

    public static AnimalBuilder getBuilder() {
        return new Animal().new AnimalBuilder();
    }

    @Override
    public int compareTo(Animal other) {
        if (!this.species.equalsIgnoreCase(other.species))
            return this.species.compareTo(other.species);
        if (!this.eyesColor.equalsIgnoreCase(other.eyesColor))
            return this.eyesColor.compareTo(other.eyesColor);
        if (!this.wool & !other.wool | this.wool & other.wool) {
            return 0;
        } else if (!this.wool & other.wool) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "{ " + species
                + ", " + eyesColor
                + ", " + (wool?"шерстяной":"лысый") + " }";
    }

    public class AnimalBuilder {

        private AnimalBuilder() {
        }

        public AnimalBuilder setSpecies(String species) {
            Animal.this.species = species;
            return this;
        }

        public AnimalBuilder setEyesColor(String eyesColor) {
            Animal.this.eyesColor = eyesColor;
            return this;
        }

        public AnimalBuilder setWool(boolean wool) {
            Animal.this.wool = wool;
            return this;
        }

        public Animal build() {
            return Animal.this;
        }
    }
}
