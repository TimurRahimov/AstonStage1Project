package ru.astonstage1project.model;

public class Barrel implements Comparable<Barrel> {
    private int volume;
    private String storedMaterial;
    private String barrelMaterial;

    private Barrel() {
    }

    public int getVolume() {
        return volume;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public String getBarrelMaterial() {
        return barrelMaterial;
    }

    public static BarrelBuilder getBuilder() {
        return new Barrel().new BarrelBuilder();
    }

    @Override
    public String toString() {
        return "Barrel{" +
                "volume=" + volume +
                ", storedMaterial='" + storedMaterial + '\'' +
                ", barrelMaterial='" + barrelMaterial + '\'' +
                '}';
    }

    @Override
    public int compareTo(Barrel other) {
        if (this.volume != other.volume)
            return Integer.compare(this.volume, other.volume);
        if (!this.storedMaterial.equalsIgnoreCase(other.storedMaterial))
            return this.storedMaterial.compareTo(other.storedMaterial);
        return this.barrelMaterial.compareTo(other.barrelMaterial);
    }

    public class BarrelBuilder {
        private BarrelBuilder() {
        }

        public BarrelBuilder setVolume(int volume) {
            Barrel.this.volume = volume;
            return this;
        }

        public BarrelBuilder setStoredMaterial(String storedMaterial) {
            Barrel.this.storedMaterial = storedMaterial;
            return this;
        }

        public BarrelBuilder setBarrelMaterial(String barrelMaterial) {
            Barrel.this.barrelMaterial = barrelMaterial;
            return this;
        }

        public Barrel build() {
            return Barrel.this;
        }
    }
}
